package edu.kit.ipd.sdq.eventsim.workload;

import java.util.ArrayList;
import java.util.List;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.BpusagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.ClosedWorkload;
import org.palladiosimulator.pcm.usagemodel.OpenWorkload;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ProcessWorkload;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.Workload;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import de.uhd.ifi.se.bp.ProcessWorkloadGenerator;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;

/**
 * This command creates and returns a list of all {@link IWorkloadGenerator}s for a PCM usage model.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildWorkloadGenerator implements IPCMCommand<List<IWorkloadGenerator>> {

    private final EventSimModel model;

    /**
     * Constructs a new command that creates all workload generators.
     * 
     * @param model
     *            the simulation model
     */
    public BuildWorkloadGenerator(final EventSimModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IWorkloadGenerator> execute(final PCMModel pcm, final ICommandExecutor<PCMModel> executor) {
        final List<IWorkloadGenerator> workloads = new ArrayList<IWorkloadGenerator>();
        for (final UsageScenario u : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            final Workload w = u.getWorkload_UsageScenario();
            // the new process workload
            if (BpusagemodelPackage.eINSTANCE.getProcessWorkload().isInstance(w)) {
            	workloads.add(new ProcessWorkloadGenerator(this.model, (ProcessWorkload) w)); 
            }else if (BpusagemodelPackage.eINSTANCE.getProcessWorkload().isInstance(w)) {
            	workloads.add(new ProcessWorkloadGenerator(this.model, (ProcessWorkload) w)); 
            }else if (UsagemodelPackage.eINSTANCE.getClosedWorkload().isInstance(w)) {
                workloads.add(new ClosedWorkloadGenerator(this.model, (ClosedWorkload) w));
            } else {
                throw new UnexpectedModelStructureException(
                        "Found a workload which is neither an OpenWorkload nor a ClosedWorkload.");
            }
        }
        return workloads;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
