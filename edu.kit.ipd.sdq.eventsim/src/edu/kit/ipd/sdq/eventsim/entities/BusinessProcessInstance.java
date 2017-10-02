package edu.kit.ipd.sdq.eventsim.entities;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;

/**
 * The business process instance is the representation of a single enactment of the business process
 * 
 * @author Robert Heinrich
 *
 */
public class BusinessProcessInstance extends User {

    /**
     *  the resting time of a certain actor step. i.e. the time the process instance rests after processing the actor step
     */
    private double restingTime;
    
    public BusinessProcessInstance(EventSimModel model, UsageScenario scenario) {
        super(model, scenario);
    }
    
    public void passivate(AbstractSimEventDelegator<User> activationEvent, double restingTime) {
        super.passivate(activationEvent, restingTime);
        this.restingTime = restingTime;
    }

}
