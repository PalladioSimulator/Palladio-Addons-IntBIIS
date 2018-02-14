package de.uhd.ifi.se.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;

/**
 * This calculator determines the execution time of actor steps
 * 
 * @author Robert Heinrich
 *
 */
public class BuildActorStepExecutionTimeCalculators implements IPCMCommand<List<Calculator>> {

	private EventSimModel model;

    public BuildActorStepExecutionTimeCalculators(EventSimModel model) {
        this.model = model;
    }
	
	@Override
	public List<Calculator> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        ProbeSpecContext probeSpecContext = model.getProbeSpecContext();
        CalculatorRegistry registry = probeSpecContext.getCalculatorRegistry();

        // build a calculator for each ActorStep
        UsageModel usageModel = pcm.getUsageModel();
        for (UsageScenario scenarios : usageModel.getUsageScenario_UsageModel()) {
            Set<ActorStep> steps = executor.execute(new FindActorStepsOfScenario(scenarios));
            for (ActorStep as : steps) {
                Calculator calculator = probeSpecContext.getCalculatorFactory().buildResponseTimeCalculator(
                        buildActorStepName(as), probeSpecContext.obtainProbeSetId(as.getId() + "_start"),
                        probeSpecContext.obtainProbeSetId(as.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(as.getId(), calculator);
            }
        }
        return calculators;
	}
	
	/**
     * Creates and returns a string describing the specified {@link ActorStep}.
     * 
     * @param step
     *            the actor step
     * @return a description of the specified step
     */
    private String buildActorStepName(ActorStep step) {
        StringBuilder builder = new StringBuilder();
        builder.append("ActorStep_");
        builder.append(step.getEntityName());
        builder.append(" <ActorStep id: ");
        builder.append(step.getId());
        builder.append(">");
        return builder.toString();
    }

	@Override
	public boolean cachable() {
		// TODO Auto-generated method stub
		return false;
	}

}
