package de.uhd.ifi.se.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;

/**
 * This calculator determines the execution time of activities
 * 
 * @author Robert Heinrich
 *
 */
public class BuildActivityExecutionTimeCalculators implements IPCMCommand<List<Calculator>> {

	private EventSimModel model;

    public BuildActivityExecutionTimeCalculators(EventSimModel model) {
        this.model = model;
    }
	
	@Override
	public List<Calculator> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        ProbeSpecContext probeSpecContext = model.getProbeSpecContext();
        CalculatorRegistry registry = probeSpecContext.getCalculatorRegistry();

        // build a calculator for each Activity
        UsageModel usageModel = pcm.getUsageModel();
        for (UsageScenario scenarios : usageModel.getUsageScenario_UsageModel()) {
            Set<Activity> activities = executor.execute(new FindActivitiesOfScenario(scenarios));
            for (Activity a : activities) {
                Calculator calculator = probeSpecContext.getCalculatorFactory().buildResponseTimeCalculator(
                        buildActivityName(a), probeSpecContext.obtainProbeSetId(a.getId() + "_start"),
                        probeSpecContext.obtainProbeSetId(a.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(a.getId(), calculator);
            }
        }
        return calculators;
	}
	
	/**
     * Creates and returns a string describing the specified {@link Activity}.
     * 
     * @param activity
     *            the activity in the process
     * @return a description of the specified activity
     */
    private String buildActivityName(Activity activity) {
        StringBuilder builder = new StringBuilder();
        builder.append("Activity_");
        builder.append(activity.getEntityName());
        builder.append(" <Activity id: ");
        builder.append(activity.getId());
        builder.append(">");
        return builder.toString();
    }

	@Override
	public boolean cachable() {
		// TODO Auto-generated method stub
		return false;
	}

}
