package de.uhd.ifi.se.pcm.bppcm.NewEventSimClasses;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceType;

import com.google.inject.Inject;

import de.uhd.ifi.se.pcm.bppcm.resources.ActorResourceRegistry;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import edu.kit.ipd.sdq.eventsim.api.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.api.PCMModel;
import edu.kit.ipd.sdq.eventsim.api.events.SimulationPrepareEvent;
import edu.kit.ipd.sdq.eventsim.api.events.SimulationStopEvent;
import edu.kit.ipd.sdq.eventsim.api.events.IEventHandler.Registration;
import edu.kit.ipd.sdq.eventsim.instrumentation.description.core.InstrumentationDescription;
import edu.kit.ipd.sdq.eventsim.instrumentation.description.resource.ActiveResourceRep;
import edu.kit.ipd.sdq.eventsim.instrumentation.injection.Instrumentor;
import edu.kit.ipd.sdq.eventsim.instrumentation.injection.InstrumentorBuilder;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementFacade;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementStorage;
import edu.kit.ipd.sdq.eventsim.measurement.osgi.BundleProbeLocator;
import edu.kit.ipd.sdq.eventsim.resources.Activator;
import edu.kit.ipd.sdq.eventsim.resources.ActiveResourceRegistry;
import edu.kit.ipd.sdq.eventsim.resources.EventSimActiveResourceModel;
import edu.kit.ipd.sdq.eventsim.resources.ProcessRegistry;
import edu.kit.ipd.sdq.eventsim.resources.ResourceProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;

public class IntBIISActorResourceModel implements IActorResource {
	 private static final Logger logger = Logger.getLogger(EventSimActiveResourceModel.class);

	    private Map<ResourceInterface, ResourceType> resourceInterfaceToTypeMap;

	    private Instrumentor<SimActiveResource, ?> instrumentor;

	    @Inject
	    private MeasurementStorage measurementStorage;

	    @Inject
	    private PCMModel pcm;

	    private MeasurementFacade<ResourceProbeConfiguration> measurementFacade;

	    @Inject
	    private InstrumentationDescription instrumentation;

	    @Inject
	    private ProcessRegistry processRegistry;
	    
	    @Inject
	    private ActiveResourceRegistry resourceRegistry;
	    
	    @Inject 
	    private ActorResourceRegistry actorRegistry;
	    
	    @Inject
	    public IntBIISActorResourceModel(ISimulationMiddleware middleware) {
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
	        resourceInterfaceToTypeMap = new HashMap<>();
	    }
	    
	    public void init() {
	        // setup measurement facade
	        Bundle bundle = Activator.getContext().getBundle();
	        measurementFacade = new MeasurementFacade<>(new ResourceProbeConfiguration(), new BundleProbeLocator<>(bundle));

	        // add hints for extracting IDs and names
	        measurementStorage.addIdExtractor(SimActiveResource.class, c -> ((SimActiveResource) c).getId());
	        measurementStorage.addNameExtractor(SimActiveResource.class, c -> ((SimActiveResource) c).getName());
	        measurementStorage.addIdExtractor(SimulatedProcess.class,
	                c -> Long.toString(((SimulatedProcess) c).getEntityId()));
	        measurementStorage.addNameExtractor(SimulatedProcess.class, c -> ((SimulatedProcess) c).getName());

	        // create instrumentor for instrumentation description
	        instrumentor = InstrumentorBuilder.buildFor(pcm).inBundle(Activator.getContext().getBundle())
	                .withDescription(instrumentation).withStorage(measurementStorage).forModelType(ActiveResourceRep.class)
	                .withMapping(
	                        (SimActiveResource r) -> new ActiveResourceRep(r.getResourceContainer(), r.getResourceType()))
	                .createFor(measurementFacade);
	        
	        //TODO do this for actorResourceRegistry
	        // instrument newly created resources
	        resourceRegistry.addResourceRegistrationListener(resource -> {
	            // create probes and calculators (if requested by instrumentation description)
	            instrumentor.instrument(resource);
	        });
	    }
	    
	    public void finalise() {
	        actorRegistry.finalise();

	        // clean up scheduler
	        AbstractActiveResource.cleanProcesses();
	    }

}
