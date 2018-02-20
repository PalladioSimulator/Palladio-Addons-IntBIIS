package de.uhd.ifi.se.pcm.bppcm.resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.inject.Singleton;

import de.uhd.ifi.se.pcm.bppcm.NewEventSimClasses.IntBIISSimDeviceResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This registry maps a given device resource specification to a specified device resource instance.
 * 
 * @author Robert Heinrich
 * 
 */

@Singleton
public class DeviceResourceRegistry  {
	
	// maps DeviceResource ID -> device resource instance
    private Map<String, IntBIISSimDeviceResource /*DeviceResourceInstance*/> map;
    
    private List<Consumer<IntBIISSimDeviceResource>> registrationListeners;
    
    /**
     * Constructs a new registry for device resources.
     */
    public DeviceResourceRegistry() {
        this.map = new HashMap<String, IntBIISSimDeviceResource /*DeviceResourceInstance*/>();
        registrationListeners = new LinkedList<>();
    }
    
    
    public void addResourceRegistrationListener(Consumer<IntBIISSimDeviceResource> listener) {
        registrationListeners.add(listener);
    }

    private void notifyRegistrationListeners(IntBIISSimDeviceResource resource) {
        registrationListeners.forEach(listener -> listener.accept(resource));
    }
    
    /**
     * Registers a device resource instance by mapping the given device resource specification to
     * the specified device resource instance.
     * 
     * @param specification
     *            the device resource specification
     * @param instance
     *            the device resource instance
     */
    public void registerDeviceResource(DeviceResource specification, IntBIISSimDeviceResource instance/*DeviceResourceInstance instance*/) {
        map.put(specification.getId(), instance);
    }
    
    /**
     * Returns the device resource instance for the given device resource specification
     * 
     * @param specification
     *            the device resource specification
     * @return the resource instance for the passed specification
     */
    public IntBIISSimDeviceResource getDeviceResource(DeviceResource specification) {
    	IntBIISSimDeviceResource r = map.get(specification.getId());
        if (r == null) {
            throw new RuntimeException("Could not find the actor resource instance for "
                    + PCMEntityHelper.toString(specification));
        }
        return r;
    }
}
