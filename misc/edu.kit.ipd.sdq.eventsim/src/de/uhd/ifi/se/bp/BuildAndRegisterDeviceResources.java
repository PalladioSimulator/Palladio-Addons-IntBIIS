package de.uhd.ifi.se.bp;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationEnvironmentModel;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.ResourceFactory;

/**
 * Builds up a registry that contains all device resources of the PCM model.
 * 
 * @author Robert Heinrich
 * 
 */
public class BuildAndRegisterDeviceResources implements IPCMCommand<Void> {

	private final EventSimModel model;
	
	/**
     * Constructs a command that builds up a registry containing all device resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     */
    public BuildAndRegisterDeviceResources(EventSimModel model) {
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
		
		// for each device resource specification
        for (DeviceResource specification : oem.getDeviceResources()) {
            
        	// create device resource instance
            SimPassiveResource res = ResourceFactory.createDeviceResource(model, specification);
                   
            // register the created device resource instance
            model.getDeviceResourceRegistry().registerDeviceResource(specification, res);
            
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
