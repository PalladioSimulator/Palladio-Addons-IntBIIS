package de.uhd.ifi.se.bp;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationEnvironmentModel;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;

/**
 * Builds up a registry that contains all actor resources of the PCM model.
 * 
 * @author Robert Heinrich
 * 
 */
public class BuildAndRegisterActorResources implements IPCMCommand<Void> {

	private final EventSimModel model;
	
	/**
     * Constructs a command that builds up a registry containing all actor resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     */
    public BuildAndRegisterActorResources(EventSimModel model) {
        this.model = model;
    }
	
	@Override
	public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
			
			// get the organization environment model
			OrganizationEnvironmentModel oem = model.getOrganizationalModel();
			
			// return if the oem is not contained in the model
			// if only IT is simulated the oem is not required
			if(oem == null){
				return null;
			}
		
		// for each actor resource specification
        for (ActorResource specification : oem.getActorResources()) {
            
        	// create actor resource instance
            ActorResourceInstance actorResourceInstance = new ActorResourceInstance(this.model, specification);

            // register the created actor resource instance
            model.getActorResourceRegistry().registerActorResource(specification, actorResourceInstance);
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
