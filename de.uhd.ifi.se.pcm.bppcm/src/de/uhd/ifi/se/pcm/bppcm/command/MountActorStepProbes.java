package de.uhd.ifi.se.bp;

import java.util.Set;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.UsageInterpreterConfiguration;

/**
 * Determines the execution time of {@link ActorStep}s
 * 
 * @author Robert Heinrich
 *
 */
public class MountActorStepProbes implements IPCMCommand<Void> {

	private final UsageInterpreterConfiguration interpreterConfig;
	
	public MountActorStepProbes(UsageInterpreterConfiguration interpreterConfig) {
        this.interpreterConfig = interpreterConfig;
    }
	
	@Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario scenario : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            Set<ActorStep> actorSteps = executor.execute(new FindActorStepsOfScenario(scenario));
            for (final ActorStep as : actorSteps) {
                this.interpreterConfig.addTraversalListener(as, new IUsageTraversalListener() {

                    @Override
                    public void before(AbstractUserAction action, User u, UserState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(as.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), as.getId(),
                                        probeSpecContext.obtainProbeSetId(as.getId() + "_start")));
                    }

                    @Override
                    public void after(AbstractUserAction action, User u, UserState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(as.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), as.getId(),
                                        probeSpecContext.obtainProbeSetId(as.getId() + "_end")));
                    }
                });
            }
        }
        // this command is not supposed to return a value
        return null;
    }


	@Override
	public boolean cachable() {
		// TODO Auto-generated method stub
		return false;
	}

}
