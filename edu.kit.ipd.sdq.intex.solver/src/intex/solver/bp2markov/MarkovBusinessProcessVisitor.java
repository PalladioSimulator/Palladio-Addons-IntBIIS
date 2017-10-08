package intex.solver.bp2markov;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.reliability.MarkovEvaluationType;
import org.palladiosimulator.reliability.MarkovHardwareInducedFailureType;
import org.palladiosimulator.reliability.markov.MarkovChain;
import org.palladiosimulator.solver.reliability.pcm2markov.FailureDescription;
import org.palladiosimulator.solver.reliability.pcm2markov.MarkovBuilder;
import org.palladiosimulator.solver.reliability.pcm2markov.MarkovTransformationSource;
import org.palladiosimulator.solver.reliability.pcm2markov.MarkovUsageModelVisitor;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel;


/**
 * @author sonja
 *
 */
public class MarkovBusinessProcessVisitor extends MarkovUsageModelVisitor {

    /**
     * The Markov Builder is used to create Markov Chain instances.
     */
    private final MarkovBuilder markovBuilder;
		
    /**
     * The prefix list enables unique naming of all Markov states, which in turn allows to search
     * for differences between two chains.
     */
    private final List<String> prefixes;
	
	public MarkovBusinessProcessVisitor(final MarkovTransformationSource transformationState,
			final MarkovEvaluationType evaluationType, final boolean simplifiedStateHandling, final boolean optimize,
			final boolean recordTraces) {
		super(transformationState, evaluationType, simplifiedStateHandling, optimize, recordTraces);
		this.prefixes = new ArrayList<String>();
		this.markovBuilder = new MarkovBuilder(recordTraces);
		LOGGER.debug("Made Markov BP Visitor");
	}

	// overrides doSwitch from MarkovUsageModelVisitor
	@Override
	protected MarkovChain doSwitch(final int classifierID, final EObject theEObject) {
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof ActorStepRel) {
			LOGGER.debug("Used ActorStepRel from Markov Bp Visitor");
			ActorStepRel actorStepRel = (ActorStepRel) theEObject;
			return caseActorStepRel(actorStepRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof AcquireDeviceResourceActionRel) {
			LOGGER.debug("Used AcquireDeviceRel from Markov Bp Visitor");
			AcquireDeviceResourceActionRel acquireDeviceResourceActionRel = (AcquireDeviceResourceActionRel) theEObject;
			return caseAcquireDeviceResourceActionRel(acquireDeviceResourceActionRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof ReleaseDeviceResourceActionRel) {
			LOGGER.debug("Used ReleaseDeviceRel from Markov Bp Visitor");
			ReleaseDeviceResourceActionRel releaseDeviceResourceActionRel = (ReleaseDeviceResourceActionRel) theEObject;
			return caseReleaseDeviceResourceActionRel(releaseDeviceResourceActionRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof Activity) {
			LOGGER.debug("Used Activity from Markov Bp Visitor");
			Activity activity = (Activity) theEObject;
			return caseActivity(activity);
		}
		// calls MarkovUsageModelVisitor
		return super.doSwitch(classifierID, theEObject);
	}

	/**
	 * ActorStep with reliability information for Markov Chain
	 * Aggregates reliability of ActorStep and its Role
	 * 
	 * @param actorStepRel
	 * @return MarkovChain
	 */
	public MarkovChain caseActorStepRel(ActorStepRel actorStepRel) {
		String name = actorStepRel.getEntityName() + "[" + actorStepRel.getId() + "]";
		prefixes.add(name);
		LOGGER.debug("Visit AcotrStepRel: " + name);

		// get the responsible role for this actor step 
		RoleRel reponsibleRole = (RoleRel) actorStepRel.getResponsibleRole();
		// and its reliability information
		double roleMttf = reponsibleRole.getMttf();
		double roleMttrep = reponsibleRole.getMttrep();
		
		double roleFailure = 1 - calculateAverageResourceAvailability(roleMttf, roleMttrep);
		
		double actorActionFailure = calculateCombinedFailureProbActorStepAndResource(
				actorStepRel.getFailureProbability(), roleFailure);
				
		/*
		 * Some kind of failure type needs to be there to use
		 * initBasicMarkovChainWithFailures, therefore a
		 * MarkovHardwareInducedFailureType is created, an FailureDescription for
		 * initiating a Markov chain with ActorStep and Role failures
		 * 
		 * TODO: create a failure type for BP elements
		 */
		List<FailureDescription> actionFailure = new ArrayList<FailureDescription>();
		actionFailure.add(new FailureDescription(MarkovHardwareInducedFailureType.createInternalFailureType(
				MarkovEvaluationType.SINGLE, "containerID", "resourceID"), actorActionFailure));

		MarkovChain resultChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes, actionFailure);
		
		prefixes.remove(prefixes.size() - 1);

		return resultChain;
	}
	
	/**
	 * acquireDeviceResourceRel with reliability information for Markov Chain
	 * Aggregates reliability of acquireDeviceResourceRel and its DeviceResource
	 * 
	 * @param acquireDeviceResourceRel
	 * @return MarkovChain
	 */
	public MarkovChain caseAcquireDeviceResourceActionRel(AcquireDeviceResourceActionRel acquireDeviceResourceRel) {
		String name = acquireDeviceResourceRel.getEntityName() + "[" + acquireDeviceResourceRel.getId() + "]";
		prefixes.add(name);
		LOGGER.debug("Visit AquireDeviceResourceRel: " + name);
		
		// get the needed device resource
		DeviceResourceRel neededDeviceResource = (DeviceResourceRel) acquireDeviceResourceRel.getPassiveresource_AcquireAction();
		// and its reliability information
		double mttf = neededDeviceResource.getMttf();
		double mttr = neededDeviceResource.getMttr();
		
		double deviceFailure = 1 - calculateAverageResourceAvailability(mttf, mttr);
		
		double deviceActionFailure = calculateCombinedFailureProbActorStepAndResource(
				acquireDeviceResourceRel.getFailureProbability(), deviceFailure);
		
		/*
		 * Some kind of failure type needs to be there to use
		 * initBasicMarkovChainWithFailures, therefore a
		 * MarkovHardwareInducedFailureType is created, an FailureDescription for
		 * initiating a Markov chain with ActorStep and Role failures
		 * 
		 * TODO: create a failure type for BP elements
		 */
		List<FailureDescription> actionFailure = new ArrayList<FailureDescription>();
		actionFailure.add(new FailureDescription(MarkovHardwareInducedFailureType.createInternalFailureType(
				MarkovEvaluationType.SINGLE, "containerID", "resourceID"), deviceActionFailure));

		MarkovChain resultChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes, actionFailure);

		prefixes.remove(prefixes.size() - 1);

		return resultChain;
	}

	/**
	 * releaseDeviceResourceActionRel with reliability information for Markov Chain
	 * does not aggregate because device is already with acquire taken into account
	 * 
	 * @param releaseDeviceResourceActionRel
	 * @return MarkovChain
	 */
	public MarkovChain caseReleaseDeviceResourceActionRel(ReleaseDeviceResourceActionRel releaseDeviceResourceActionRel) {
		String name = releaseDeviceResourceActionRel.getEntityName() + "[" + releaseDeviceResourceActionRel.getId() + "]";
		prefixes.add(name);
		LOGGER.debug("Visit ReleaseDeviceResourceRel: " + name);
		
		double deviceActionFailure = releaseDeviceResourceActionRel.getFailureProbability();
		
		/*
		 * Some kind of failure type needs to be there to use
		 * initBasicMarkovChainWithFailures, therefore a
		 * MarkovHardwareInducedFailureType is created, an FailureDescription for
		 * initiating a Markov chain with ActorStep and Role failures
		 * 
		 * TODO: create a failure type for BP elements
		 */
		List<FailureDescription> actionFailure = new ArrayList<FailureDescription>();
		actionFailure.add(new FailureDescription(MarkovHardwareInducedFailureType.createInternalFailureType(
				MarkovEvaluationType.SINGLE, "containerID", "resourceID"), deviceActionFailure));

		MarkovChain resultChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes, actionFailure);

		prefixes.remove(prefixes.size() - 1);

		return resultChain;
	}
	
	/**
	 * @param activity
	 * @return MarkovChain
	 */
	public MarkovChain caseActivity(Activity activity) {
		String name = activity.getEntityName() + "[" + activity.getId() + "]";
		prefixes.add(name);
		LOGGER.debug("Visit Activity: " + name);

		MarkovChain resultChain = doSwitch(activity.getScenario());
				
		prefixes.remove(prefixes.size() - 1);

		return resultChain;
	}
	
	/**
	 * calculate average availability from MTTF and MTTR or MTTF and MTTRepl
	 * 
	 * @param mttf
	 * @param mttr
	 * @return average availability of resource
	 */
	private double calculateAverageResourceAvailability(double mttf, double mttr) {
		/*
		 * in case mttf and mttr are both 0, this means the resource is always available
		*/
		if (mttf == 0.0 && mttr == 0.0) {
			return 1.0;
		} else {
			return mttf / (mttf + mttr);
		}
	}

	/**
	 * calculate the combined failure probability of action and resource
	 * 
	 * @param stepFailure
	 * @param resourceFailure
	 * @return combined failure probability
	 */
	private double calculateCombinedFailureProbActorStepAndResource(double stepFailure, double resourceFailure) {
		return 1 - ((1 - stepFailure) * (1 - resourceFailure));
	}
}
