package de.uhd.ifi.se.pcm.bppcm.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.resources.entities.ActorResourceInstance;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This registry maps a given actor resource specification to a specified actor resource instance.

 * 
 * @author Robert Heinrich
 *
 */
@Singleton
public class ActorResourceRegistry {
	//TODO: Not completely equal to ActiveResourceRegistry. Need to test if working
	// maps ActorResource ID -> actor resource instance
    private Map<String, ActorResourceInstance> map;
    
    private List<Consumer<ActorResourceInstance>> registrationListeners;
    
    /**
     * Constructs a new registry for actor resources.
     */
    public ActorResourceRegistry() {
        this.map = new HashMap<String, ActorResourceInstance>();
    }
    
    public void addResourceRegistrationListener(Consumer<ActorResourceInstance> listener) {
        registrationListeners.add(listener);
    }
    
    private void notifyRegistrationListeners(ActorResourceInstance resource) {
        registrationListeners.forEach(listener -> listener.accept(resource));
    }
    public void finalise(){
    	for(ActorResourceInstance resource : map.values()){
    		resource.getResource().deactivateResource();
    	}
    }
    
    /**
     * Registers an actor resource instance by mapping the given actor resource specification to
     * the specified actor resource instance.
     * 
     * @param specification
     *            the actor resource specification
     * @param instance
     *            the actor resource instance
     */
    public void registerActorResource(ActorResource specification, ActorResourceInstance instance) {
        map.put(specification.getId(), instance);
        
        notifyRegistrationListeners(instance);
    }
    
    /**
     * Returns the actor resource instance for the given actor resource specification
     * 
     * @param specification
     *            the actor resource specification
     * @return the resource instance for the passed specification
     */
    public ActorResourceInstance getActorResourceForContext(ActorResource specification) {
        ActorResourceInstance r = map.get(specification.getId());
        if (r == null) {
            throw new RuntimeException("Could not find the actor resource instance for "
                    + PCMEntityHelper.toString(specification));
        }
        return r;
    }
    
    /**
     * Returns all actor resource instances registered with this registry.
     * 
     * @return a collection of all registered actor resource instances
     */
    public Collection<ActorResourceInstance> getAllActorResourceInstances() {
        return map.values();
    }

}
