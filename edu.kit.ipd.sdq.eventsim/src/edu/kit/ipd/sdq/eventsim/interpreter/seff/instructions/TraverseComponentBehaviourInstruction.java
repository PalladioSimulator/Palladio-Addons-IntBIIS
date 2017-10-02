package edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.command.seff.FindActionInResourceDemandingBehaviour;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;

/**
 *  TODO: adjust javadoc since the term scope is slightly outdated and should be better denoted by
 * the level of traversal hierarchy.
 * 
 * Use this instruction to continue the traversal with a specified
 * {@link ResourceDemandingBehaviour}. This opens a new scope on the {@link TraversalStateStack}. As
 * soon as the specified behaviour has been traversed completely, the previous scope is restored.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraverseComponentBehaviourInstruction implements
        ITraversalInstruction<AbstractAction, RequestState>, IRequestTraversalInstruction {

    private final EventSimModel model;
    private final ComponentInstance component;
    private final AbstractAction actionAfterCompletion;
    private final ResourceDemandingBehaviour behaviour;

    /**
     * Constructs a new instruction.
     * 
     * @param model
     *            the simulation model
     * @param behaviour
     *            the behaviour that is to be traversed in a new scope
     * @param component
     *            the component that provides the specified behaviour
     * @param actionAfterCompletion
     *            the action that is to be traversed after leaving the scope
     */
    public TraverseComponentBehaviourInstruction(final EventSimModel model, final ResourceDemandingBehaviour behaviour,
            final ComponentInstance component, final AbstractAction actionAfterCompletion) {
        this.model = model;
        this.component = component;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractAction process(RequestState state) {
        state.setPreviousPosition(state.getCurrentPosition());
        state.setCurrentPosition(this.actionAfterCompletion);

        final StartAction startAction = this.model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(
                this.behaviour, StartAction.class));

        state.pushStackFrame();
        state.setCurrentPosition(startAction);
        state.setComponent(this.component);

        return startAction;
    }

}
