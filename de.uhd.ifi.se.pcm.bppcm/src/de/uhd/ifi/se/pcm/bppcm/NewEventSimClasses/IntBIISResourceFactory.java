package de.uhd.ifi.se.pcm.bppcm.NewEventSimClasses;

import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.uhd.ifi.se.pcm.bppcm.core.EventSimModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;

@Singleton
public class IntBIISResourceFactory {

	  private SchedulerModel model;
	  @Inject
	  private ISchedulingFactory schedulingFactory;
	  
	  
	  private static final String FCFS = "FCFS";

	    private static final String PROCESSOR_SHARING = "ProcessorSharing";

	    private static final String DELAY = "Delay";
	    
	    private static final String BP_FCFS = "Suspenable_FCFS";
	  
	  @Inject
	  public IntBIISResourceFactory(SchedulerModel model){
		  this.model = model;
	  }
	
	
    /**
     * Creates a SimPassiveResource in accordance with the given DeviceResource specification.
     * 
     * @param model
     *            the simulation model
     * @param specification
     *            the DeviceResource specification
     * 
     * Note, the assembly context is neglected for device resources. It is assumed that the context is not required.
     * 
     */
    public static SimDeviceResource createDeviceResource(final EventSimModel model,
            final DeviceResource specification) {
        // obtain capacity by evaluating the associated StoEx
        final PCMRandomVariable capacitySpecification = specification.getCapacity();
        final int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

        final String name = specification.getEntityName();
        final String resourceId = specification.getId();
        final String combinedId = resourceId;

       
        
        
        IPassiveResource schedulerResource = new SimSimpleFairPassiveDeviceResource(specification, model, capacity, name, combinedId);



        return new SimDeviceResource(model, schedulerResource, specification);
    }
    
    
    /*
     * This is a replica of the ResourceFactory Method, but fitted to ActorResource.
     * No call to the real resource factory will be made to get the possibility to create a Suspendable Process.
     * TODO This causes much duplicated code 
     */
//    public static SimActiveResource createActiveActorResource(ActorResource specification){
//    	
//    	
//    	 // TODO reliability stuff
//        // double mttf = specification.getMTTF();
//        // double mttr = specification.getMTTR();
//        final int numberOfReplicas = 1;
//        final PCMRandomVariable processingRate = CoreFactory.eINSTANCE.createPCMRandomVariable();
//    	processingRate.setSpecification("1");
//        final String schedulingPolicyId = specification.getSchedulingPolicy().getId();
//
//        IActiveResource resource = null;
//        String resourceName;
//        switch (schedulingPolicyId) {
//        case FCFS:
//            resourceName = SchedulingStrategy.FCFS.toString();
//            resource = schedulingFactory.createSimFCFSResource(resourceName, getNextResourceId());
//            break;
//        case DELAY:
//            resourceName = SchedulingStrategy.DELAY.toString();
//            resource = schedulingFactory.createSimDelayResource(resourceName, getNextResourceId());
//            break;
//        case PROCESSOR_SHARING:
//            resourceName = SchedulingStrategy.PROCESSOR_SHARING.toString();
//            resource = schedulingFactory.createSimProcessorSharingResource(resourceName, getNextResourceId(),
//                    numberOfReplicas);
//            break;
//        default:
//            // try instantiating resource from extension point, used e.g. by exact schedulers
//            resource = schedulingFactory.createResourceFromExtension(specification.getSchedulingPolicy().getId(),
//                    getNextResourceId(), numberOfReplicas);
//            resourceName = specification.getSchedulingPolicy().getEntityName();
//            // TODO do we need to initialize the resource by calling a method as SimuCom does?
//
//            if (resource == null) {
//                throw new EventSimException("Unknown scheduling policy: " + schedulingPolicyId.toString());
//            }
//        }
//
//        SimActiveResource r = null;
//        // special case for HDD resources
//        if (specification instanceof HDDProcessingResourceSpecification) {
//            HDDProcessingResourceSpecification hdd = (HDDProcessingResourceSpecification) specification;
//            r = this.resourceFactory.createActiveHDDResource(resource, processingRate.getSpecification(),
//                    numberOfReplicas, specification.getSchedulingPolicy(), hdd,
//                    hdd.getWriteProcessingRate().getSpecification(), hdd.getReadProcessingRate().getSpecification());
//        } else { // normal case (no HDD resource)
//            r = this.resourceFactory.createActiveResource(resource, processingRate.getSpecification(), numberOfReplicas,
//                    specification.getSchedulingPolicy(), specification);
//        }
//
//        return r;
//    	
//    }

}
