package de.uhd.ifi.se.bp;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@link Activity} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class ActivityTraversalStrategy implements IUsageTraversalStrategy<Activity> {

	@Override
	public ITraversalInstruction<AbstractUserAction, UserState> traverse(
			Activity activity, User user, UserState state) {
		
		// allocate scenario behavior of subprocess
		ScenarioBehaviour behaviour = activity.getScenario();
		
		// traverse the scenario behavior of the subprocess
		return UsageTraversalInstructionFactory.traverseScenarioBehaviour(user.getModel(), behaviour, activity.getSuccessor());
	}
}
