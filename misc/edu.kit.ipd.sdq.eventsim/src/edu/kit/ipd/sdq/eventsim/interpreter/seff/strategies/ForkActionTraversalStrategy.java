package edu.kit.ipd.sdq.eventsim.interpreter.seff.strategies;

import java.util.List;

import org.palladiosimulator.pcm.seff.ForkAction;
import org.palladiosimulator.pcm.seff.ForkedBehaviour;
import edu.kit.ipd.sdq.eventsim.entities.ForkedRequest;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.events.BeginForkedBehaviourTraversalEvent;
import edu.kit.ipd.sdq.eventsim.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

public class ForkActionTraversalStrategy implements ISeffTraversalStrategy<ForkAction> {

    @Override
    public IRequestTraversalInstruction traverse(ForkAction fork, Request request, RequestState state) {
        new ResumeSeffTraversalEvent(request.getModel(), state).schedule(request, 0);

        List<ForkedBehaviour> asynchronousBehaviours = fork.getAsynchronousForkedBehaviours_ForkAction();
        for (ForkedBehaviour b : asynchronousBehaviours) {
            ForkedRequest forkedRequest = new ForkedRequest(request.getModel(), b, true, request);
            new BeginForkedBehaviourTraversalEvent(request.getModel(), b, state).schedule(forkedRequest, 0);
        }

        if (fork.getSynchronisingBehaviours_ForkAction() != null) {
            throw new EventSimException("Synchronous forked behaviours are not yet supported.");
        }

        // TODO nur zulässig, falls keine synchronen Behaviours vorhanden. Ansonsten müsste hier
        // gewartet werden, bis alle forked behaviours abgearbeitet sind.
        return RequestTraversalInstructionFactory.interruptTraversal(fork.getSuccessor_AbstractAction());
        // return new TraverseNextAction<AbstractAction>(fork.getSuccessor_AbstractAction());
    }

}
