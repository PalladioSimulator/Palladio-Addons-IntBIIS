package intex.solver.bp2markov;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.reliability.MarkovFailureType;

public class MarkovBusinessProcessFailureType extends MarkovFailureType {
	
	/**
     * A default id for new BP failure type.
     */
    private static String BP_ID = "Business process failure";

    /**
     * A default name for new BP failure type.
     */
    private static String BP_NAME = "Business process failure";
    
    public static MarkovBusinessProcessFailureType createBpFailureType(AbstractUserAction action) {
    	return new MarkovBusinessProcessFailureType(action);
    }
        
     //////

  
    
    
	private final AbstractUserAction source;

	public MarkovBusinessProcessFailureType(AbstractUserAction source) {
		this.source = source;
	}

	public AbstractUserAction getSource() {
		return source;
	}
}
