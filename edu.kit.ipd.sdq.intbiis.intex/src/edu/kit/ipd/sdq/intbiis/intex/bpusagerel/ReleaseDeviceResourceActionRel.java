/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release Device Resource Action Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel#getFailureProbability <em>Failure Probability</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage#getReleaseDeviceResourceActionRel()
 * @model
 * @generated
 */
public interface ReleaseDeviceResourceActionRel extends ReleaseDeviceResourceAction {
	/**
	 * Returns the value of the '<em><b>Failure Probability</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Probability</em>' attribute.
	 * @see #setFailureProbability(double)
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage#getReleaseDeviceResourceActionRel_FailureProbability()
	 * @model default="0.0"
	 * @generated
	 */
	double getFailureProbability();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel#getFailureProbability <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Probability</em>' attribute.
	 * @see #getFailureProbability()
	 * @generated
	 */
	void setFailureProbability(double value);

} // ReleaseDeviceResourceActionRel
