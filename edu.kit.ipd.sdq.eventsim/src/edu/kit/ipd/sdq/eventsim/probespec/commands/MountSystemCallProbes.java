package edu.kit.ipd.sdq.eventsim.probespec.commands;

import java.util.Set;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.command.usage.FindSystemCallsOfScenario;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.UsageInterpreterConfiguration;

/**
 * This command registers a {@link ITraversalListener} before and after each
 * {@link EntryLevelSystemCall}. The listeners take a {@link ProbeType#CURRENT_TIME} sample before
 * and after a call in order to enable the calculation of the call's response time.
 * 
 * @author Philipp Merkle
 * 
 */
public class MountSystemCallProbes implements IPCMCommand<Void> {

    private final UsageInterpreterConfiguration interpreterConfig;
    
    public MountSystemCallProbes(UsageInterpreterConfiguration interpreterConfig) {
        this.interpreterConfig = interpreterConfig;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            Set<EntryLevelSystemCall> calls = executor.execute(new FindSystemCallsOfScenario(s));
            for (final EntryLevelSystemCall c : calls) {
                this.interpreterConfig.addTraversalListener(c, new IUsageTraversalListener() {

                    @Override
                    public void before(AbstractUserAction action, User u, UserState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "_start")));
                    }

                    @Override
                    public void after(AbstractUserAction action, User u, UserState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "_end")));
                    }
                });
            }
        }

        // this command is not supposed to return a value
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
