/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage
 * @generated
 */
public interface OrganizationenvironmentrelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizationenvironmentrelFactory eINSTANCE = edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Device Resource Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Resource Rel</em>'.
	 * @generated
	 */
	DeviceResourceRel createDeviceResourceRel();

	/**
	 * Returns a new object of class '<em>Role Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Rel</em>'.
	 * @generated
	 */
	RoleRel createRoleRel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OrganizationenvironmentrelPackage getOrganizationenvironmentrelPackage();

} //OrganizationenvironmentrelFactory
