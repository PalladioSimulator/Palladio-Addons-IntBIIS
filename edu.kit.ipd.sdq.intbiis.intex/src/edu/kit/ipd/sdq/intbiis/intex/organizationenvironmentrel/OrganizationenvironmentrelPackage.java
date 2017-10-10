/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelFactory
 * @model kind="package"
 * @generated
 */
public interface OrganizationenvironmentrelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "organizationenvironmentrel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/PalladioComponentModel/5.1/intex/organizationenvironmentrel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "organizationenvironmentrel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizationenvironmentrelPackage eINSTANCE = edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl <em>Device Resource Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl#getDeviceResourceRel()
	 * @generated
	 */
	int DEVICE_RESOURCE_REL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL__ID = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL__ENTITY_NAME = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL__CAPACITY = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mttf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL__MTTF = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mttr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL__MTTR = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Device Resource Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_REL_FEATURE_COUNT = OrganizationenvironmentmodelPackage.DEVICE_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl <em>Role Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl#getRoleRel()
	 * @generated
	 */
	int ROLE_REL = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL__ID = OrganizationenvironmentmodelPackage.ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL__ENTITY_NAME = OrganizationenvironmentmodelPackage.ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL__ACTORS = OrganizationenvironmentmodelPackage.ROLE__ACTORS;

	/**
	 * The feature id for the '<em><b>Mttf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL__MTTF = OrganizationenvironmentmodelPackage.ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mttrep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL__MTTREP = OrganizationenvironmentmodelPackage.ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REL_FEATURE_COUNT = OrganizationenvironmentmodelPackage.ROLE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel <em>Device Resource Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Resource Rel</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel
	 * @generated
	 */
	EClass getDeviceResourceRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttf <em>Mttf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mttf</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttf()
	 * @see #getDeviceResourceRel()
	 * @generated
	 */
	EAttribute getDeviceResourceRel_Mttf();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttr <em>Mttr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mttr</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel#getMttr()
	 * @see #getDeviceResourceRel()
	 * @generated
	 */
	EAttribute getDeviceResourceRel_Mttr();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel <em>Role Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Rel</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel
	 * @generated
	 */
	EClass getRoleRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttf <em>Mttf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mttf</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttf()
	 * @see #getRoleRel()
	 * @generated
	 */
	EAttribute getRoleRel_Mttf();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttrep <em>Mttrep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mttrep</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel#getMttrep()
	 * @see #getRoleRel()
	 * @generated
	 */
	EAttribute getRoleRel_Mttrep();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OrganizationenvironmentrelFactory getOrganizationenvironmentrelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl <em>Device Resource Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl
		 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl#getDeviceResourceRel()
		 * @generated
		 */
		EClass DEVICE_RESOURCE_REL = eINSTANCE.getDeviceResourceRel();

		/**
		 * The meta object literal for the '<em><b>Mttf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_RESOURCE_REL__MTTF = eINSTANCE.getDeviceResourceRel_Mttf();

		/**
		 * The meta object literal for the '<em><b>Mttr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_RESOURCE_REL__MTTR = eINSTANCE.getDeviceResourceRel_Mttr();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl <em>Role Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl
		 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl#getRoleRel()
		 * @generated
		 */
		EClass ROLE_REL = eINSTANCE.getRoleRel();

		/**
		 * The meta object literal for the '<em><b>Mttf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_REL__MTTF = eINSTANCE.getRoleRel_Mttf();

		/**
		 * The meta object literal for the '<em><b>Mttrep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_REL__MTTREP = eINSTANCE.getRoleRel_Mttrep();

	}

} //OrganizationenvironmentrelPackage
