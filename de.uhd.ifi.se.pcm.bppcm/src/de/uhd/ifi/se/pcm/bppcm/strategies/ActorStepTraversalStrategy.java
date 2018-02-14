package de.uhd.ifi.se.pcm.bppcm.strategies;


import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uhd.ifi.se.pcm.bppcm.core.EventSimModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import edu.kit.ipd.sdq.eventsim.interpreter.SimulationStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.TraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;

import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;


/**
 * This traversal strategy is responsible for {@link ActorStep} actions.
 * 
 * @author Robert Heinrich
 * 
 */
public class ActorStepTraversalStrategy implements SimulationStrategy<ActorStep, User>{

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

	@Override
	public void simulate(ActorStep action, Request entity, Consumer<TraversalInstruction> onFinishCallback) {
		// TODO Auto-generated method stub
		final EventSimModel model = (EventSimModel)entity.getModel();
		ActorResource selectedActor = model.getDispatcher().dispatchdispatch((User)entity.getUser(),action);
		
	}

	@Override
	public void simulate(ActorStep action, User entity, Consumer<TraversalInstruction> onFinishCallback) {
		final EventSimModel model = (EventSimModel)entity.getModel();
		ActorResource selectedActor = model.getDispatcher().dispatch(entity, action);
	}

}
