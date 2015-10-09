package edu.kit.ipd.sdq.eventsim.interpreter.usage.strategies;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@link Delay} actions.
 * 
 * @author Philipp Merkle
 * 
 */
public class DelayTraversalStrategy implements IUsageTraversalStrategy<Delay> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IUsageTraversalInstruction traverse(final Delay delay, final User user, final UserState state) {
        // evaluate StoEx
        final PCMRandomVariable delayTimeSpecification = delay.getTimeSpecification_Delay();
        final double delayTime = NumberConverter.toDouble(StackContext.evaluateStatic(delayTimeSpecification
                .getSpecification()));

        // schedule the traversal to continue after the desired delay
        new ResumeUsageTraversalEvent(user.getModel(), state).schedule(user, delayTime);

        return UsageTraversalInstructionFactory.interruptTraversal(delay.getSuccessor());
    }

}
