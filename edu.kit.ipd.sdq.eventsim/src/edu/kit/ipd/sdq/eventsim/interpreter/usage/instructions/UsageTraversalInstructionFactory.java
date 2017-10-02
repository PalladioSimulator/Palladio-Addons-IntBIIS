package edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.EndTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.InterruptTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseAfterLeavingScope;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.TraverseNextAction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalInstruction;

public class UsageTraversalInstructionFactory {

    private static EndUsageTraversal END_USAGE_TRAVERSAL = new EndUsageTraversal();
    private static TraverseUsageAfterLeavingScope TRAVERSE_USAGE_AFTER_LEAVING_SCOPE = new TraverseUsageAfterLeavingScope();

    public static EndUsageTraversal endTraversal() {
        return END_USAGE_TRAVERSAL;
    }

    public static InterruptUsageTraversal interruptTraversal(AbstractUserAction resumeAction) {
        return new InterruptUsageTraversal(resumeAction);
    }

    public static TraverseUsageAfterLeavingScope traverseAfterLeavingScope() {
        return TRAVERSE_USAGE_AFTER_LEAVING_SCOPE;
    }

    public static TraverseNextUsageAction traverseNextAction(AbstractUserAction nextAction) {
        return new TraverseNextUsageAction(nextAction);
    }

    public static TraverseUsageBehaviourInstruction traverseScenarioBehaviour(final EventSimModel model,
            final ScenarioBehaviour behaviour, final AbstractUserAction actionAfterCompletion) {
        return new TraverseUsageBehaviourInstruction(model, behaviour, actionAfterCompletion);
    }

    public static class EndUsageTraversal extends EndTraversal<AbstractUserAction, UserState> implements
            IUsageTraversalInstruction {
    }

    public static class InterruptUsageTraversal extends InterruptTraversal<AbstractUserAction, UserState>
            implements IUsageTraversalInstruction {
        public InterruptUsageTraversal(AbstractUserAction resumeAction) {
            super(resumeAction);
        }
    }

    public static class TraverseUsageAfterLeavingScope extends
            TraverseAfterLeavingScope<AbstractUserAction, UserState> implements IUsageTraversalInstruction {
    }

    public static class TraverseNextUsageAction extends TraverseNextAction<AbstractUserAction, UserState>
            implements IUsageTraversalInstruction {
        public TraverseNextUsageAction(AbstractUserAction nextAction) {
            super(nextAction);
        }
    }

}
