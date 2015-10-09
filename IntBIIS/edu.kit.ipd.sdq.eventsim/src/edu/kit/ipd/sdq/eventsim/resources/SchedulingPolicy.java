package edu.kit.ipd.sdq.eventsim.resources;

import java.util.Arrays;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;

public abstract class SchedulingPolicy {

    private static final Logger logger = Logger.getLogger(SchedulingPolicy.class);
    
    public static final SchedulingPolicy FCFS = new SchedulingPolicy("FCFS", "First-Come First-Served") {
        // no abstract methods need to be implemented
    };

    public static final SchedulingPolicy PROCESSOR_SHARING = new SchedulingPolicy("ProcessorSharing",
            "Processor Sharing") {
        // no abstract methods need to be implemented
    };

    public static final SchedulingPolicy DELAY = new SchedulingPolicy("Delay", "Delay") {
        // no abstract methods need to be implemented
    };

    private static SchedulingPolicy[] policies = { FCFS, PROCESSOR_SHARING, DELAY };

    private final String id;

    private final String name;

    public SchedulingPolicy(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SchedulingPolicy getPolicyForId(String id) {
        for (SchedulingPolicy p : policies) {
            if (p.id.equalsIgnoreCase(id)) {
                return p;
            }
        }
        throw new EventSimException("Could not find SchedulingPolicy for id " + id);
    }

    public static void registerSchedulingPolicy(SchedulingPolicy policy) {
        assert (policy != null);

        // check if the policy has been registered already
        for (SchedulingPolicy p : policies) {
            if (p.equals(policy)) {
                // policy is already registered, it makes no sense to add it twice
                logger.warn("Tried to register scheduling policy " + policy + ", which has already been registered.");
                return;
            }
        }
        
        // add passed policy
        policies = Arrays.copyOf(policies, policies.length + 1);
        policies[policies.length - 1] = policy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
