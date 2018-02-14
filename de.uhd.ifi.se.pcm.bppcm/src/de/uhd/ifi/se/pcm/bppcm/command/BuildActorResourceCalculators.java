package de.uhd.ifi.se.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.SimActiveResource;

/**
 * This command creates and returns a list of {@link Calculator}s. The following calculators are
 * created:
 * <ul>
 * <li>a {@link DemandCalculator} for each resource.</li>
 * <li>a {@link StateCalculator} for each resource.</li>
 * </ul>
 * 
 * @author Robert Heinrich
 * 
 */
public class BuildActorResourceCalculators implements IPCMCommand<List<Calculator>> {

    private EventSimModel model;
    private ActorResourceRegistry registry;

    /**
     * Constructs a new command that creates calculators for actor resources.
     * 
     * @param registry
     *            the registry for actor resources
     */
    public BuildActorResourceCalculators(EventSimModel model, ActorResourceRegistry registry) {
        this.registry = registry;
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calculator> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        
    	// collect all active resources
        Set<SimActiveResource> resources = model.execute(new CollectActorResources(registry));

        // build calculators for each active resource
        List<Calculator> calculators = new ArrayList<Calculator>();
        for (SimActiveResource r : resources) {
            calculators.add(setupDemandCalculator(this.model.getProbeSpecContext(), r));

            // set up a ResourceStateCalculator for each actor resource
            calculators.addAll(setupResourceStateCalculator(this.model.getProbeSpecContext(), r));
            
        }
        return calculators;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Returns the probe set ID for the demand probe of the specified resource.
     * 
     * @param resource
     *            the resource
     * @return the probe set ID
     */
    public static Integer getDemandedTimeProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
        return probeSpecContext.obtainProbeSetId("demand_" + resource.getName() + "_" + resource.getId());
    }

    /**
     * Returns the probe set ID for the state probe of the specified resource.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the probe set ID
     */
    public static Integer getStateProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource, int instance) {
        return probeSpecContext.obtainProbeSetId("state_" + getInstanceDescription(resource, instance));
    }

    public static Integer getOverallUtilisationProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
        return probeSpecContext.obtainProbeSetId("overallUtilization_" + resource.getDescription());
    }

    /**
     * Creates and returns a {@link DemandCalculator} for the specified resource
     * 
     * @param resource
     *            the resource
     * @return the created calculator
     */
    private DemandCalculator setupDemandCalculator(ProbeSpecContext probeSpecContext, final SimActiveResource resource) {
        final Integer probeSetId = getDemandedTimeProbeSetId(probeSpecContext, resource);
        DemandCalculator calculator = probeSpecContext.getCalculatorFactory().buildDemandCalculator(
                resource.getDescription(), probeSetId);
        return calculator;
    }

    /**
     * Creates and returns a {@link StateCalculator} for each specified resource.
     * 
     * @param resource
     *            the resource
     * @return the list of created calculators
     */
    private List<StateCalculator> setupResourceStateCalculator(ProbeSpecContext probeSpecContext,
            SimActiveResource resource) {
        List<StateCalculator> calculators = new ArrayList<StateCalculator>();
        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
            final Integer probeSetID = getStateProbeSetId(probeSpecContext, resource, instance);
            calculators.add(probeSpecContext.getCalculatorFactory().buildStateCalculator(
                    getInstanceDescription(resource, instance), probeSetID));
        }
        return calculators;
    }

    private StateCalculator setupOverallUtilisationCalculator(ProbeSpecContext probeSpecContext,
            SimActiveResource resource) {
        final Integer stateProbeSetID = getOverallUtilisationProbeSetId(probeSpecContext, resource);
        return probeSpecContext.getCalculatorFactory().buildOverallUtilizationCalculator(resource.getDescription(),
                stateProbeSetID);
    }

    /**
     * Returns a textual description of the specified resource.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the resource instance's description
     */
    private static String getInstanceDescription(SimActiveResource resource, int instance) {
        String description = resource.getDescription();
        return description;
    }

}

