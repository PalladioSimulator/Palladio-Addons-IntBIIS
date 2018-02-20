package de.uhd.ifi.se.pcm.bppcm.NewEventSimClasses;

import org.osgi.framework.Bundle;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.kit.ipd.sdq.eventsim.api.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.api.PCMModel;
import edu.kit.ipd.sdq.eventsim.api.events.SimulationPrepareEvent;
import edu.kit.ipd.sdq.eventsim.api.events.SimulationStopEvent;
import edu.kit.ipd.sdq.eventsim.api.events.IEventHandler.Registration;
import edu.kit.ipd.sdq.eventsim.instrumentation.description.core.InstrumentationDescription;
import edu.kit.ipd.sdq.eventsim.instrumentation.description.resource.PassiveResourceRep;
import edu.kit.ipd.sdq.eventsim.instrumentation.injection.Instrumentor;
import edu.kit.ipd.sdq.eventsim.instrumentation.injection.InstrumentorBuilder;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementFacade;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementStorage;
import edu.kit.ipd.sdq.eventsim.measurement.osgi.BundleProbeLocator;
import edu.kit.ipd.sdq.eventsim.resources.Activator;
import edu.kit.ipd.sdq.eventsim.resources.PassiveResourceRegistry;
import de.uhd.ifi.se.pcm.bppcm.resources.DeviceResourceRegistry;
import edu.kit.ipd.sdq.eventsim.resources.ProcessRegistry;
import edu.kit.ipd.sdq.eventsim.resources.ResourceProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;

//TODO: Device Resources nearly PassiveResources but no assembly cntxt needed ... still seperation?
@Singleton
public class IntBIISDeviceResourceModel implements IDeviceResource{
	
	private Instrumentor<SimPassiveResource, ?> instrumentor;

    @Inject
    private MeasurementStorage measurementStorage;

    @Inject
    private PCMModel pcm;

    @Inject
    private InstrumentationDescription instrumentation;

    private MeasurementFacade<ResourceProbeConfiguration> measurementFacade;

    @Inject
    private ProcessRegistry processRegistry;

    @Inject
    private DeviceResourceRegistry resourceRegistry;
	
    @Inject
    public IntBIISDeviceResourceModel(ISimulationMiddleware middleware) {
        // initialize in simulation preparation phase
        middleware.registerEventHandler(SimulationPrepareEvent.class, e -> {
            init();
            return Registration.UNREGISTER;
        });
        // finalize on simulation stop
        middleware.registerEventHandler(SimulationStopEvent.class, e -> {
            finalise();
            return Registration.UNREGISTER;
        });
    }
    
    public void init() {
        // setup measurement facade
        Bundle bundle = Activator.getContext().getBundle();
        measurementFacade = new MeasurementFacade<>(new ResourceProbeConfiguration(), new BundleProbeLocator<>(bundle));

        // add hints for extracting IDs and names
        measurementStorage.addIdExtractor(SimPassiveResource.class,
                c -> ((SimPassiveResource) c).getSpecification().getId());
        measurementStorage.addNameExtractor(SimPassiveResource.class, c -> ((SimPassiveResource) c).getName());

        // create instrumentor for instrumentation description
        instrumentor = InstrumentorBuilder.buildFor(pcm).inBundle(Activator.getContext().getBundle())
                .withDescription(instrumentation).withStorage(measurementStorage).forModelType(PassiveResourceRep.class)
                .withMapping(
                        (SimPassiveResource r) -> new PassiveResourceRep(r.getSpecification(), r.getAssemblyContext()))
                .createFor(measurementFacade);

        // instrument newly created resources
        resourceRegistry.addResourceRegistrationListener(resource -> {
            // create probes and calculators (if requested by instrumentation description)
            instrumentor.instrument(resource);
        });
    }
    
    public void finalise() {
        // nothing to do
    }
    
    

   public SimPassiveResource getPassiveResource(final DeviceResource specification) {
       final SimPassiveResource simResource = resourceRegistry.getDeviceResource(specification);
       if (simResource == null) {
           throw new RuntimeException("Passive resource " + PCMEntityHelper.toString(specification)
                   + " could not be found.");
       }
       return simResource;
   }
}
