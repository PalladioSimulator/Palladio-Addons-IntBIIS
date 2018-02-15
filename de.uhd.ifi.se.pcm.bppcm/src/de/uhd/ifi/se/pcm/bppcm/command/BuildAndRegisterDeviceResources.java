package de.uhd.ifi.se.pcm.bppcm.command;

import de.uhd.ifi.se.pcm.bppcm.core.EventSimModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationEnvironmentModel;
import edu.kit.ipd.sdq.eventsim.api.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.resources.ResourceFactory;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;

/**
 * Builds up a registry that contains all device resources of the PCM model.
 * 
 * @author Robert Heinrich
 * 
 */
public class BuildAndRegisterDeviceResources implements IPCMCommand<Void> {

	private final EventSimModel eventSimModel;
	
	/**
     * Constructs a command that builds up a registry containing all device resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     */
    public BuildAndRegisterDeviceResources(EventSimModel model) {
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
		
		// for each device resource specification
        for (DeviceResource specification : oem.getDeviceResources()) {
            
        	// create device resource instance
            SimPassiveResource res = ResourceFactory.createDeviceResource(eventSimModel, specification);
                   
            // register the created device resource instance
            eventSimModel.getDeviceResourceRegistry().registerDeviceResource(specification, res);
            
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
