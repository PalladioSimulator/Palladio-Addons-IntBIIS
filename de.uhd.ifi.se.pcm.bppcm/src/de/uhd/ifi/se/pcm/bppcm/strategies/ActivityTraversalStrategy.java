package de.uhd.ifi.se.pcm.bppcm.strategies;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;

import java.util.function.Consumer;


import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import edu.kit.ipd.sdq.eventsim.interpreter.SimulationStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.TraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;

/**
 * This traversal strategy is responsible for {@link Activity} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class ActivityTraversalStrategy implements SimulationStrategy<Activity, User> {

//	@Override
//	public ITraversalInstruction<AbstractUserAction, UserState> traverse(
//			Activity activity, User user, UserState state) {
//		
//		// allocate scenario behavior of subprocess
//		ScenarioBehaviour behaviour = activity.getScenario();
//		
//		// traverse the scenario behavior of the subprocess
//		return UsageTraversalInstructionFactory.traverseScenarioBehaviour(user.getModel(), behaviour, activity.getSuccessor());
//	}



	@Override
	public void simulate(Activity action, User entity, Consumer<TraversalInstruction> onFinishCallback) {
		
		// allocate scenario behavior of subprocess
		ScenarioBehaviour behaviour = action.getScenarioBehaviour_AbstractUserAction();
		
		entity.simulateBehaviour(behaviour, () -> {
			onFinishCallback.accept(() -> {
				entity.simulateAction(action.getSuccessor());
			});
		});
	}
}
