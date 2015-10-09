/**
 */
package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource#getCapacity <em>Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage#getDeviceResource()
 * @model
 * @generated
 */
public interface DeviceResource extends Entity {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' containment reference.
	 * @see #setCapacity(PCMRandomVariable)
	 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage#getDeviceResource_Capacity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PCMRandomVariable getCapacity();

	/**
	 * Sets the value of the '{@link de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource#getCapacity <em>Capacity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' containment reference.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(PCMRandomVariable value);

} // DeviceResource
