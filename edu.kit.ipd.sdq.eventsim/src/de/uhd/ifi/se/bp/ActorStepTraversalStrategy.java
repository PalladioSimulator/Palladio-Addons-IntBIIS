package de.uhd.ifi.se.bp;

import org.apache.log4j.Logger;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@link ActorStep} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class ActorStepTraversalStrategy implements IUsageTraversalStrategy<ActorStep>{

    private static final Logger logger = Logger.getLogger(ActorStepTraversalStrategy.class);
    
	@Override
	public ITraversalInstruction<AbstractUserAction, UserState> traverse(
			ActorStep action, User user, UserState state) {
		final EventSimModel model = user.getModel();
		
		// set flag whether the execution of the step is interruptable
		user.getSimulatedProcess().setInterruptable(action.isInterruptable());

        ActorResource selectedActor = model.getDispatcher().dispatch(user, action);
        
        
        // allocate the resource demand to the selected actor
        if (selectedActor != null){
        	
        	final PCMRandomVariable d = action.getProcessingTime();
        
        	final double demand = NumberConverter.toDouble(state.getStoExContext().evaluate(d.getSpecification()));
      
        	model.getActorResourceRegistry().getActorResourceForContext(selectedActor).getResource().consumeResource(user.getSimulatedProcess(), demand);
        	
        	logger.info("Queue-Legth of " + selectedActor.getEntityName() + " AFTER allocation is: " + model.getActorResourceRegistry().getActorResourceForContext(selectedActor).getResource().getCurrentDemand());
        }
        
        // wait for resting time before the next step
        user.passivate(new ResumeUsageTraversalEvent(model, state), action.getRestingTime());
         
        return UsageTraversalInstructionFactory.interruptTraversal(action.getSuccessor());
           
    }

}
