
package intex.solver.bp2markov;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.solver.models.PCMInstance;
import org.palladiosimulator.solver.visitors.UsageModelVisitor;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel;

/**
 * @author sonja
 *
 */
public class BusinessProcessVisitor extends UsageModelVisitor {

	/**
	 * @param inst a PCM instance
	 */
	public BusinessProcessVisitor(PCMInstance inst) {
		super(inst);
		logger.debug("Made BP Visitor");
	}

	// overrides doSwitch from UsageModelVisitor
	@Override
	protected Object doSwitch(final int classifierID, final EObject theEObject) {
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof ActorStepRel) {
			logger.debug("Used ActorStepRel from Bp Visitor");
			ActorStepRel actorStepRel = (ActorStepRel) theEObject;
			return caseActorStepRel(actorStepRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof AcquireDeviceResourceActionRel) {
			logger.debug("Used AcquireDeviceRel from Bp Visitor");
			AcquireDeviceResourceActionRel acquireDeviceResourceActionRel = (AcquireDeviceResourceActionRel) theEObject;
			return caseAcquireDeviceResourceActionRel(acquireDeviceResourceActionRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof ReleaseDeviceResourceActionRel) {
			logger.debug("Used ReleaseDeviceRel from Bp Visitor");
			ReleaseDeviceResourceActionRel releaseDeviceResourceActionRel = (ReleaseDeviceResourceActionRel) theEObject;
			return caseReleaseDeviceResourceActionRel(releaseDeviceResourceActionRel);
		}
		// can not be compared to classifier id because they interfere with them from PCM usage model
		if (theEObject instanceof Activity) {
			logger.debug("Used Activity from Bp Visitor");
			Activity activity = (Activity) theEObject;
			return caseActivity(activity);
		}
		// calls UsageModelVisitor
		return super.doSwitch(classifierID, theEObject);

	}

	/**
	 * Just to take BP elements during dependency solver into account
	 * 
	 * @param object
	 * @return object
	 */
	public Object caseActorStepRel(ActorStepRel object) {
		logger.debug("Visit ActorStepRel");
		doSwitch(object.getSuccessor());
		return object;
	}

	/**
	 * Just to take BP elements during dependency solver into account
	 * 
	 * @param object
	 * @return object
	 */
	public Object caseAcquireDeviceResourceActionRel(AcquireDeviceResourceActionRel object) {
		logger.debug("Visit AcquireDeviceResourceActionRel");
		doSwitch(object.getSuccessor());
		return object;
	}

	/**
	 * Just to take BP elements during dependency solver into account
	 * 
	 * @param object
	 * @return object
	 */
	public Object caseReleaseDeviceResourceActionRel(ReleaseDeviceResourceActionRel object) {
		logger.debug("Visit ReleaseDeviceResourceActionRel");
		doSwitch(object.getSuccessor());
		return object;
	}

	/**
	 * Go into activity in order to use visitor on it
	 * 
	 * @param object
	 * @return object
	 */
	public Object caseActivity(Activity object) {
		logger.debug("Visit Activity");
		doSwitch(getScecarioBehaviour(object));
		doSwitch(object.getSuccessor());
		return object;
	}

	/**
	 * Just to take BP elements during dependency solver into account
	 * 
	 * @param object
	 * @return object
	 */
	private ScenarioBehaviour getScecarioBehaviour(Activity object) {
		ScenarioBehaviour scenarioBehaviour = object.getScenario();
		return scenarioBehaviour;
	}
}
