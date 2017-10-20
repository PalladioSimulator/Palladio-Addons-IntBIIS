package de.uhd.ifi.se.bp;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.AcquireDeviceResourceAction;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@AcquireDeviceResource} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class AcquireDeviceResourceTraversalStrategy implements IUsageTraversalStrategy<AcquireDeviceResourceAction> {

	@Override
	public ITraversalInstruction<AbstractUserAction, UserState> traverse(
			AcquireDeviceResourceAction action, User entity, UserState state) {
		
        final DeviceResource passiveResouce = action.getPassiveresource_AcquireAction();

        final SimPassiveResource res = entity.getSimulatedProcess().getModel().getDeviceResourceRegistry().getDeviceResource(passiveResouce);
        
        final boolean acquired = res.acquire(entity.getSimulatedProcess(), 1, false, action.getTimeoutValue());

        if (acquired) {
            return UsageTraversalInstructionFactory.traverseNextAction(action.getSuccessor());
        } else {
            entity.passivate(new ResumeUsageTraversalEvent(entity.getSimulatedProcess().getModel(), state), 0);

            // here, it is assumed that the passive resource grants access to waiting processes as
            // soon as the requested capacity becomes available. Thus, we do not need to acquire the
            // passive resource again as this will be done within the release method. Accordingly
            // the traversal resumes with the successor of this action.
            return UsageTraversalInstructionFactory.interruptTraversal(action.getSuccessor());
        }
	}

}
