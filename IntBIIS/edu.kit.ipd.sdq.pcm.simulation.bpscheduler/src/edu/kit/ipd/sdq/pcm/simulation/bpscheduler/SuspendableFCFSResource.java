package edu.kit.ipd.sdq.pcm.simulation.bpscheduler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

/**
 * The scheduling policy for the suspendable FCFS resource
 * 
 * @author Robert Heinrich
 *
 */
public class SuspendableFCFSResource extends AbstractActiveResource {

    private static final Logger logger = Logger.getLogger(SuspendableFCFSResource.class);

    private final State RUNNING_STATE = new RunningState();

    private final State SUSPENDING_STATE = new SuspendingState();

    private final State SUSPENDED_STATE = new SuspendedState();

    private Deque<ISuspendableSchedulableProcess> processQ_Interruptable;

    private Deque<ISuspendableSchedulableProcess> processQ_NonInterruptable;

    // the step currently processed
    private ISuspendableSchedulableProcess currentStep;

    // the progress bar
    private Hashtable<ISchedulableProcess, Double> running_processes;

    private SuspendEvent suspendEvent;

    private ProcessingFinishedEvent processingFinishedEvent;

    private double lastTime;

    private double suspendetTime;

    private double suspendetAt;

    private State state;
    
    private double remainingDemand;

    public SuspendableFCFSResource(SchedulerModel model, int capacity, String name, String id) {
        super(model, capacity, name, id);
        switchState(RUNNING_STATE);
        processQ_Interruptable = new ArrayDeque<ISuspendableSchedulableProcess>();
        processQ_NonInterruptable = new ArrayDeque<ISuspendableSchedulableProcess>();
        running_processes = new Hashtable<ISchedulableProcess, Double>();
        processingFinishedEvent = new ProcessingFinishedEvent(model);
        suspendEvent = new SuspendEvent(model);
    }

    public Hashtable<ISchedulableProcess, Double> getRunning_processes() {
        return running_processes;
    }

    private class ProcessingFinishedEvent extends AbstractSimEventDelegator<ISchedulableProcess> {

        public ProcessingFinishedEvent(SchedulerModel model) {
            super(model, ProcessingFinishedEvent.class.getName());
        }

        @Override
        public void eventRoutine(ISchedulableProcess process) {
            logger.info("Handling " + ProcessingFinishedEvent.class.getSimpleName() + " for " + process.getId()
                    + " (t=" + currentSimulationTime());

            logger.info("Finished "+ process.getId() + " at " + currentSimulationTime());
            
            ISchedulableProcess first = process;
            
            toNow();

            running_processes.remove(first);
            // the finished step is no longer the current step
            currentStep = null;
            // remove finished step from queue
            if (((ISuspendableSchedulableProcess) first).isInterruptable()) {
                processQ_Interruptable.remove(first);
            } else {
                processQ_NonInterruptable.remove(first);
            }
            fireStateChange(processQ_Interruptable.size() + processQ_NonInterruptable.size(), 0);

            fireDemandCompleted(first);
            logger.info("Demand of Process " + first + " finished.");

            if (state == RUNNING_STATE || state == SUSPENDING_STATE) {
                scheduleNextEvent();
            }
            first.activate();
        }

    }

    private class SuspendEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {

        public SuspendEvent(SchedulerModel model) {
            super(model, SuspendEvent.class.getName());
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            logger.info("Handling " + SuspendEvent.class.getSimpleName() + " for " + resource.getId() + " (t="
                    + currentSimulationTime() + ")");

            toNow();

            // check whether there are still non-interruptible steps in the queue
            // i.e., new non-interruptible steps arrived while processing the other
            if (!processQ_NonInterruptable.isEmpty()) {
                logger.info("found further non-interruptable jobs in queue");

                scheduleNextEvent();
            } else {
                logger.info("found no further non-interruptable jobs in queue");
                toNow();

                processingFinishedEvent.removeEvent();

                if (!running_processes.isEmpty() && !(currentStep==null)) {

                    // get remaining demand for process
                    double remainingDemand = running_processes.get(currentStep);

                    // if process has no demand left, finish the process before suspending this
                    // resource
                    if (MathTools.equalsDouble(0, remainingDemand)) {
                        processingFinishedEvent.schedule(currentStep, 0);
                    }
                }

                switchState(SUSPENDED_STATE);
                suspendetTime = 0;
                suspendetAt = getModel().getSimulationControl().getCurrentSimulationTime();

            }
        }
    }

    protected void scheduleNextEvent() {
        state.scheduleNextEvent();
    }

    private void toNow() {
        state.toNow();
    }

    public void start() {
        // nothing to do
    }

    @Override
    protected void dequeue(ISchedulableProcess process) {
        // nothing to do
    }

    @Override
    protected void doProcessing(ISchedulableProcess process, int resourceServiceID, double demand) {
        assert demand > 0 : "demand must be > 0";
        toNow();
        logger.info("FCFS: " + process + " demands " + demand);
        running_processes.put(process, demand);
        remainingDemand += demand;

        if (((ISuspendableSchedulableProcess) process).isInterruptable()) {
            processQ_Interruptable.add((ISuspendableSchedulableProcess) process);
        } else {
            processQ_NonInterruptable.add((ISuspendableSchedulableProcess) process);
        }
        fireStateChange(processQ_Interruptable.size() + processQ_NonInterruptable.size(), 0);

        scheduleNextEvent();
        process.passivate();
    }

    // returns the remaining demand of the job
    @Override
    public double getRemainingDemand(ISchedulableProcess process) {
        if (!running_processes.containsKey(process)) {

            return 0.0;
        }
        toNow();
        return running_processes.get(process);
    }

    @Override
    public void updateDemand(ISchedulableProcess process, double demand) {
        for (Entry<ISchedulableProcess, Double> e : running_processes.entrySet()) {
            if (e.getKey().equals(process)) {
                e.setValue(demand);
                break;
            }
        }
        scheduleNextEvent();
    }

    @Override
    protected void enqueue(ISchedulableProcess process) {
        // nothing to do
    }

    public void stop() {
        processQ_Interruptable.clear();
        processQ_NonInterruptable.clear();
        running_processes.clear();
    }

    public void suspend() {
        logger.info("Suspending resource. Current state is " + state + " (t=" + currentSimulationTime() + ")");
        state.suspend();
    }

    public void resume() {
        logger.info("Resuming resource. Current state is " + state + " (t=" + currentSimulationTime() + ")");
        state.resume();
    }

    private double currentSimulationTime() {
        return getModel().getSimulationControl().getCurrentSimulationTime();
    }

    public void registerProcess(ISchedulableProcess process) {
        // nothing to do
    }

    public int getQueueLengthFor(SchedulerEntity schedulerEntity) {
        return this.processQ_NonInterruptable.size() + this.processQ_Interruptable.size();
    }

    private void switchState(State state) {
        logger.info("Switching state to " + state.toString() + " (t=" + currentSimulationTime() + ")");
        this.state = state;
    }

    private ISuspendableSchedulableProcess currentStep() {
        // if there is a non-interruptible step in the queue, process it (they are privileged
        // compared to interruptible steps)
        if (!processQ_NonInterruptable.isEmpty()) {
            return processQ_NonInterruptable.peek();
        } else {
            return processQ_Interruptable.peek();
        }
    }
    
    

    public double getRemainingDemand() {
		return remainingDemand;
	}

	private interface State {

        void toNow();

        void scheduleNextEvent();

        void suspend();

        void resume();

    }

    private class RunningState implements State {

        @Override
        public String toString() {
            return "RUNNING";
        }

        /**
         * adjust remaining demand of current step according to passed simulation time
         */
        public void toNow() {
            double now = currentSimulationTime();
            double passed_time = now - lastTime - suspendetTime;

            if (MathTools.less(0, passed_time)) {
                if (currentStep != null) {

                    // get the demand of the first job
                    double demand = running_processes.get(currentStep);
                    demand -= passed_time;
                    SuspendableFCFSResource.this.remainingDemand -= passed_time;
                    
                    // avoid trouble caused by rounding issues
                    demand = MathTools.equalsDouble(demand, 0) ? 0.0 : demand;

                    assert demand >= 0 : "Remaining demand (" + demand + ") smaller than zero! at simulation time: "
                            + now;

                    running_processes.put(currentStep, demand);
                }
            }
            lastTime = now;
            suspendetTime = 0;
        }

        public void scheduleNextEvent() {
            currentStep = currentStep();

            // schedule (updated) processing finished event
            processingFinishedEvent.removeEvent();
            if (currentStep != null) {
                double time = running_processes.get(currentStep);
                processingFinishedEvent.schedule(currentStep, time);
            }

            // cancel suspend event, if it has been scheduled before
            suspendEvent.removeEvent();
        }

        public void suspend() {
            if (processQ_NonInterruptable.isEmpty()) { 
                logger.info("No pending non-interruptable job in queues. Switch to suspended state directly.");
                
                suspendEvent.eventRoutine(SuspendableFCFSResource.this);                
            } else {
                logger.info("Found at least one non-interruptable job. Switch to suspending state.");
                switchState(SUSPENDING_STATE);

                // calculate remaining demand for current job
                toNow();

                SuspendableFCFSResource.this.scheduleNextEvent();
            }

        }

        public void resume() {
            throw new RuntimeException("Tried to resume resource which has not been suspended before at "
                    + currentSimulationTime());
        }

    }

    private class SuspendingState implements State {

        @Override
        public String toString() {
            return "SUSPENDING";
        }

        /**
         * adjust remaining demand of current step according to passed simulation time
         */
        public void toNow() {
            // in suspending state, the current step must be non-interruptable
            if (currentStep != null && !currentStep.isInterruptable()) {
                double now = currentSimulationTime();
                double passed_time = now - lastTime;

                if (MathTools.less(0, passed_time)) {
                    // get the demand of the first job
                    double demand = running_processes.get(currentStep);
                    demand -= passed_time;

                    // avoid trouble caused by rounding issues
                    demand = MathTools.equalsDouble(demand, 0) ? 0.0 : demand;

                    assert demand >= 0 : "Remaining demand (" + demand + ") smaller than zero! at simulation time: "
                            + now;

                    running_processes.put(currentStep, demand);
                }
                lastTime = now;
            }
        }

        public void scheduleNextEvent() {
            currentStep = currentStep();
            if (currentStep == null) {
                // no pending jobs
                processingFinishedEvent.removeEvent();
            } else {
                // check if current job is non-interruptible
                if (!currentStep.isInterruptable()) {
                    // non-interruptible => continue processing of current job

                    // schedule (updated) processing finished event
                    processingFinishedEvent.removeEvent();
                    double time = running_processes.get(currentStep);
                    processingFinishedEvent.schedule(currentStep, time);

                } else {
                    // interruptible => interrupt

                    processingFinishedEvent.removeEvent();
                }

                // schedule (updated) suspend event
                suspendEvent.removeEvent();
                double remainingNonInterruptableDemand = 0;
                for (ISuspendableSchedulableProcess i : processQ_NonInterruptable) {
                    remainingNonInterruptableDemand += getRemainingDemand(i);
                }
                suspendEvent.schedule(SuspendableFCFSResource.this, remainingNonInterruptableDemand);

            }

        }

        @Override
        public void suspend() {
            throw new RuntimeException("Tried to suspend resource which is suspending at the moment");
        }

        @Override
        public void resume() {
            switchState(RUNNING_STATE);
            suspendetTime = 0;

            SuspendableFCFSResource.this.toNow();
            SuspendableFCFSResource.this.scheduleNextEvent();
        }

    }

    private class SuspendedState implements State {

        @Override
        public String toString() {
            return "SUSPENDED";
        }

        public void toNow() {
            logger.info("Called toNow() in suspendet state, which has no effect");
        }

        public void scheduleNextEvent() {
            logger.info("Called scheduleNextEvent() in suspendet state, which has no effect");
        }

        @Override
        public void suspend() {
            throw new RuntimeException("Tried to suspend resource which is already suspended");
        }

        @Override
        public void resume() {
            switchState(RUNNING_STATE);
            suspendetTime = currentSimulationTime() - suspendetAt;

            SuspendableFCFSResource.this.toNow();
            SuspendableFCFSResource.this.scheduleNextEvent();
        }

    }

}
