package edu.kit.ipd.sdq.eventsim.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions.TraverseComponentBehaviourInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;

/**
 * This traversal strategy is responsible for {@link ExternalCallAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class ExternalCallActionStrategy implements ISeffTraversalStrategy<ExternalCallAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final ExternalCallAction action,
            final Request request, final RequestState state) {
        // find the component which provides the required call
        final ComponentInstance currentComponent = state.getComponent();
        final ComponentInstance providingComponent = currentComponent.getProvidingComponent(action
                .getCalledService_ExternalService());
        final ResourceDemandingSEFF seff = providingComponent.getServiceEffectSpecification(action
                .getCalledService_ExternalService());

        return new TraverseComponentBehaviourInstruction(request.getModel(), seff, providingComponent, action
                .getSuccessor_AbstractAction());
    }

}
