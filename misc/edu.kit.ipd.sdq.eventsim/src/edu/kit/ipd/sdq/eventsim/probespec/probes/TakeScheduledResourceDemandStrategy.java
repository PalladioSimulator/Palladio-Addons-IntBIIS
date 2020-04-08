package edu.kit.ipd.sdq.eventsim.probespec.probes;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import edu.kit.ipd.sdq.eventsim.entities.SimActiveResource;

/**
 * ProbeStrategy which is able to measure the demanded time of a {@link SimActiveResource}. The unit
 * is assumed to be {@link SI#SECOND}.
 * 
 * @author Philipp Merkle
 * 
 */
public class TakeScheduledResourceDemandStrategy implements IProbeStrategy {

    /**
     * {@inheritDoc}
     * 
     * @param o
     *            expects a {@link Double} that represents the demand
     */
    @Override
    public ProbeSample<Double, Duration> takeSample(String probeId, Object... o) {
        Double demand = null;
        if (o.length >= 1 && o[0] instanceof Double) {
            demand = (Double) o[0];
        } else {
            throw new IllegalArgumentException("Expected an argument of type " + Double.class.getSimpleName() + ".");
        }

        // Here it is assumed that the simulation time's unit is SI.SECOND
        Measure<Double, Duration> demandMeasure = Measure.valueOf(demand, SI.SECOND);
        ProbeSample<Double, Duration> sample = new ProbeSample<Double, Duration>(demandMeasure, probeId,
                ProbeType.RESOURCE_DEMAND);

        return sample;
    }

}
