package de.uhd.ifi.se.bp;

import java.util.HashMap;
import java.util.Map;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This registry maps a given device resource specification to a specified device resource instance.
 * 
 * @author Robert Heinrich
 * 
 */
public class DeviceResourceRegistry {
	
	// maps DeviceResource ID -> device resource instance
    private Map<String, SimPassiveResource /*DeviceResourceInstance*/> map;
    
    /**
     * Constructs a new registry for device resources.
     */
    public DeviceResourceRegistry() {
        this.map = new HashMap<String, SimPassiveResource /*DeviceResourceInstance*/>();
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
    public void registerDeviceResource(DeviceResource specification, SimPassiveResource instance/*DeviceResourceInstance instance*/) {
        map.put(specification.getId(), instance);
    }
    
    /**
     * Returns the device resource instance for the given device resource specification
     * 
     * @param specification
     *            the device resource specification
     * @return the resource instance for the passed specification
     */
    public SimPassiveResource getDeviceResource(DeviceResource specification) {
    	SimPassiveResource r = map.get(specification.getId());
        if (r == null) {
            throw new RuntimeException("Could not find the actor resource instance for "
                    + PCMEntityHelper.toString(specification));
        }
        return r;
    }
}
