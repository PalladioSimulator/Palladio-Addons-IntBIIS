package edu.kit.ipd.sdq.pcm.simulation.bpscheduler;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;

/**
 * Creates scheduler for business process
 * 
 * @author Robert Heinrich
 *
 */
public class BusinessProcessSchedulerFactory implements SchedulerExtensionFactory {

	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores) {
		// TODO Auto-generated method stub
		return null;
	}

}
