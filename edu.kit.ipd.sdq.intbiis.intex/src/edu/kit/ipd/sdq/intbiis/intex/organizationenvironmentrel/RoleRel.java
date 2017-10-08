/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttf <em>Mttf</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttrep <em>Mttrep</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getRoleRel()
 * @model
 * @generated
 */
public interface RoleRel extends Role {
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
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getRoleRel_Mttf()
	 * @model default="0.0"
	 * @generated
	 */
	double getMttf();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttf <em>Mttf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mttf</em>' attribute.
	 * @see #getMttf()
	 * @generated
	 */
	void setMttf(double value);

	/**
	 * Returns the value of the '<em><b>Mttrep</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mttrep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mttrep</em>' attribute.
	 * @see #setMttrep(double)
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#getRoleRel_Mttrep()
	 * @model default="0.0"
	 * @generated
	 */
	double getMttrep();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttrep <em>Mttrep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mttrep</em>' attribute.
	 * @see #getMttrep()
	 * @generated
	 */
	void setMttrep(double value);

} // RoleRel
