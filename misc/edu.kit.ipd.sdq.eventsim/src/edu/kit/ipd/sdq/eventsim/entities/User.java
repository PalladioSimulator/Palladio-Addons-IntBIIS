package edu.kit.ipd.sdq.eventsim.entities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.debug.DebugEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.scheduler.IProcessListener;
import edu.kit.ipd.sdq.eventsim.entities.scheduler.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.workload.IWorkloadGenerator;

/**
 * This entity represents a user of the system under simulation. Users issue system calls while
 * traversing a usage scenario. They are spawned by a {@link IWorkloadGenerator}.
 * 
 * @author Philipp Merkle
 * 
 * @see EventSimEntity
 */
public class User extends EventSimEntity {

    private static final Logger logger = Logger.getLogger(User.class);

    /** the usage scenario that is to be simulated by this User */
    private final UsageScenario scenario;
    
    /**
     * the simulated process is used to schedule resource requests issued by this Request on an
     * active or passive resource.
     */
    private SimulatedProcess simulatedProcess;

    /**
     * the activation event encapsulates the bahaviour that is to be performed when this Request is
     * activated after it has been passivated before (see also: activate and passivate methods).
     */
    private AbstractSimEventDelegator<User> activationEvent;
    
    /**
     * the request context is a unique identifier for this user, which is required for the Probe
     * Specification.
     */
    
    /**
     *  the resting time of a certain actor step. i.e. the time the process instance rests after processing the actor step
     */
    private double restingTime;
    
    private final RequestContext requestContext;

    /**
     * Constructs a new User that is supposed to traverse the specified usage scenario.
     * 
     * @param model
     *            the simulation model
     * @param scenario
     *            the usage scenario
     */
    public User(final EventSimModel model, final UsageScenario scenario) {
        super(model, "User");
        this.scenario = scenario;

        // set the request context of this user. As this entity's ID is unique, we can use it to
        // construct the request context
        this.requestContext = new RequestContext(Long.toString(this.getEntityId()));

        // install debug listener, if debugging is enabled
        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }
    
    /**
     * Returns the simulated process that is used to schedule resource requests issued by this
     * Request on an active or passive resource.
     * 
     * @return the simulated process
     */
    public SimulatedProcess getSimulatedProcess() {
        if (this.simulatedProcess == null) {
            this.simulatedProcess = this.createSimulatedProcess();
        }
        return this.simulatedProcess;
    }
    
    protected SimulatedProcess createSimulatedProcess() {
        // initialise the simulated process by specifying its ID and a handler that reacts when the
        // process gets activated by the scheduler
        SimulatedProcess process = new SimulatedProcess(this, Long.toString(this.getEntityId()),
                new ProcessActivatedHandler());

        // add a handler that reacts when this Request has finished its execution and informs the
        // simulated process about that.
        this.addEntityListener(new RequestFinishedHandler(process));

        return process;
    }

    /**
     * Returns the usage scenario that is to be executed by this User.
     * 
     * @return the usage scenario
     */
    public UsageScenario getUsageScenario() {
        return this.scenario;
    }

    /**
     * Returns the RequestContext required by the Probe Specification to identify this User.
     * 
     * @return a unique identifier, encapsulated in a RequestContext, for this User
     */
    public RequestContext getRequestContext() {
        return this.requestContext;
    }

    /**
     * Call this method when the simulated process (see: {@code getSimulatedProcess()} method) has
     * been scheduled on a resource and waits for being serviced. The specified activationEvent will
     * be scheduled as soon as the simulated process has been activated.
     * 
     * @param activationEvent
     *            the event that is to be scheduled when the simulated process has been activated
     * @param restingTime 
     * 			  the resting time after processing an actor step
     * @param transportTime
     * 			  the transport time from one actor step to the other 
     */
    public void passivate(AbstractSimEventDelegator<User> activationEvent, double restingTime) {
        assert (activationEvent != null) : "The argument activationEvent may not be null";
        this.activationEvent = activationEvent;
        this.restingTime = restingTime;
    }

    /**
     * Activates this Request by scheduling the activationEvent passed to the {@code passivate}
     * method. The Request must have been passivated before.
     * 
     * @see #passivate(AbstractSimEventDelegator)
     */
    protected void activate() {
        if (this.activationEvent == null) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Tried to activate request " + this.getName() + ", but there is no activation event.");
            return;
        }

        // schedule the activation event...
        this.activationEvent.schedule(this, restingTime);

        // ...and clear the event thereafter
        this.activationEvent = null;
    }
    
    /**
     * This handler reacts when the Request has been finished and informs the simulated process
     * about that.
     * 
     * @author Philipp Merkle
     * 
     */
    private static final class RequestFinishedHandler implements IEntityListener {

        private SimulatedProcess process;

        public RequestFinishedHandler(SimulatedProcess process) {
            this.process = process;
        }

        @Override
        public void leftSystem() {
            this.process.setFinished();
        }

        @Override
        public void enteredSystem() {
            // nothing to do
        }

    }

    /**
     * This handler reacts when the simulated process is being activated.
     * 
     * @author Philipp Merkle
     * 
     */
    private final class ProcessActivatedHandler implements IProcessListener {

        @Override
        public void passivated() {
            // nothing to do
        }

        @Override
        public void activated() {
            User.this.activate();
        }
    }
    
}
