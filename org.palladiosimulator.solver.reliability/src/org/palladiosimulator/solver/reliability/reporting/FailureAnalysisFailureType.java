package org.palladiosimulator.solver.reliability.reporting;

/**
 * Enumeration describing the type of failure probabilities that are grouped together (that is,
 * added up) for creating a Markov reporting.
 * 
 * @author Daniel Patejdl
 * 
 */
public enum FailureAnalysisFailureType {
    /**
     * Group together hardware-induced failures.
     */
    HARDWARE_INDUCED,

    /**
     * Group together network-induced failures.
     */
    NETWORK_INDUCED,

    /**
     * Group together software-induced failures.
     */
    SOFTWARE_INDUCED
}
