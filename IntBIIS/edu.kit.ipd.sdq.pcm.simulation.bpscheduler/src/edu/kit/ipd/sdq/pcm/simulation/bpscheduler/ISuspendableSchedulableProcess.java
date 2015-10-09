package edu.kit.ipd.sdq.pcm.simulation.bpscheduler;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * The process for the suspendable FCFS resource
 * 
 * @author Robert Heinrich
 *
 */
public interface ISuspendableSchedulableProcess extends ISchedulableProcess {

    boolean isInterruptable();

    void setInterruptable(boolean isInterruptable);

}
