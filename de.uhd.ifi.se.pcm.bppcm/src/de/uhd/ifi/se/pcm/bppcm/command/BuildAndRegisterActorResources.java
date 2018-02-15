package de.uhd.ifi.se.pcm.bppcm.command;

import de.uhd.ifi.se.pcm.bppcm.core.EventSimModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationEnvironmentModel;
import de.uhd.ifi.se.pcm.bppcm.resources.entities.ActorResourceInstance;
import edu.kit.ipd.sdq.eventsim.api.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;

/**
 * Builds up a registry that contains all actor resources of the PCM model.
 * 
 * @author Robert Heinrich
 * 
 */
public class BuildAndRegisterActorResources implements IPCMCommand<Void> {

	private final EventSimModel eventSimModel;
	
	/**
     * Constructs a command that builds up a registry containing all actor resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     */
    public BuildAndRegisterActorResources(EventSimModel model) {
        this.eventSimModel = model;
    }
	
	@Override
	public Void execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
			
			// get the organization environment model
			OrganizationEnvironmentModel oem = eventSimModel.getOrganizationalModel();
			
			// return if the oem is not contained in the model
			// if only IT is simulated the oem is not required
			if(oem == null){
				return null;
			}
		
		// for each actor resource specification
        for (ActorResource specification : oem.getActorResources()) {
            
        	// create actor resource instance
            ActorResourceInstance actorResourceInstance = new ActorResourceInstance(this.eventSimModel, specification);

            // register the created actor resource instance
            eventSimModel.getActorResourceRegistry().registerActorResource(specification, actorResourceInstance);
        }
		
        // this command is not supposed to return a value
		return null;
	}

	@Override
	public boolean cachable() {
		// TODO Auto-generated method stub
		return false;
	}



}
