package de.uhd.ifi.se.bp;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@ReleaseDeviceResource} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class ReleaseDeviceResourceTraversalStrategy implements IUsageTraversalStrategy<ReleaseDeviceResourceAction> {

	@Override
	public ITraversalInstruction<AbstractUserAction, UserState> traverse(
			ReleaseDeviceResourceAction action, User entity, UserState state) {
		

        final DeviceResource passiveResouce = action.getPassiveresource_ReleaseAction();

        final SimPassiveResource res = entity.getSimulatedProcess().getModel().getDeviceResourceRegistry().getDeviceResource(passiveResouce);
        		
        res.release(entity.getSimulatedProcess(), 1);

        return UsageTraversalInstructionFactory.traverseNextAction(action.getSuccessor());
	}

}
