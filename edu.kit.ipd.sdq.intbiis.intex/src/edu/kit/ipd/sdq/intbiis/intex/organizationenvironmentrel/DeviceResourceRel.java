/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Resource Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttf <em>Mttf</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttr <em>Mttr</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getDeviceResourceRel()
 * @model
 * @generated
 */
public interface DeviceResourceRel extends DeviceResource {
	/**
	 * Returns the value of the '<em><b>Mttf</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mttf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mttf</em>' attribute.
	 * @see #setMttf(double)
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getDeviceResourceRel_Mttf()
	 * @model default="0.0"
	 * @generated
	 */
	double getMttf();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttf <em>Mttf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mttf</em>' attribute.
	 * @see #getMttf()
	 * @generated
	 */
	void setMttf(double value);

	/**
	 * Returns the value of the '<em><b>Mttr</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mttr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mttr</em>' attribute.
	 * @see #setMttr(double)
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getDeviceResourceRel_Mttr()
	 * @model default="0.0"
	 * @generated
	 */
	double getMttr();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttr <em>Mttr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mttr</em>' attribute.
	 * @see #getMttr()
	 * @generated
	 */
	void setMttr(double value);

} // DeviceResourceRel
