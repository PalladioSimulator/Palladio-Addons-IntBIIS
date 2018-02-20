package de.uhd.ifi.se.pcm.bppcm.resources.entities;

import de.uhd.ifi.se.pcm.bppcm.core.EventSimModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.resources.BPResourceFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;

/**
 * The actor resource instance
 * 
 * @author Robert Heinrich
 * 
 */
public class ActorResourceInstance extends AbstractSimEntityDelegator {
	
	// the processing resource
	private SimActiveResource resource;
	
	private ActorResource specification;
	
	public ActorResourceInstance(EventSimModel model, ActorResource specification){
		super(model, specification.getEntityName());
		
		this.specification = specification;
		
		// create the active resource
		this.resource = BPResourceFactory.createActiveResource(model, specification); 
		// the name of the actor resource to be displayed
		this.resource.getResourceContainer().setEntityName(specification.getEntityName());
		//this.resource.setDescription(specification.getEntityName());
		
	}
	
	public SimActiveResource getResource(){
		return resource;
	}

	public ActorResource getSpecification() {
		return specification;
	}

}
