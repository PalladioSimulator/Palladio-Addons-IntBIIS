package de.uhd.ifi.se.bp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This registry maps a given actor resource specification to a specified actor resource instance.
 * 
 * @author Robert Heinrich
 *
 */
public class ActorResourceRegistry {
	
	// maps ActorResource ID -> actor resource instance
    private Map<String, ActorResourceInstance> map;
    
    /**
     * Constructs a new registry for actor resources.
     */
    public ActorResourceRegistry() {
        this.map = new HashMap<String, ActorResourceInstance>();
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
