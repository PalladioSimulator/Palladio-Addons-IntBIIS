/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationenvironmentrelFactoryImpl extends EFactoryImpl implements OrganizationenvironmentrelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OrganizationenvironmentrelFactory init() {
		try {
			OrganizationenvironmentrelFactory theOrganizationenvironmentrelFactory = (OrganizationenvironmentrelFactory)EPackage.Registry.INSTANCE.getEFactory(OrganizationenvironmentrelPackage.eNS_URI);
			if (theOrganizationenvironmentrelFactory != null) {
				return theOrganizationenvironmentrelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OrganizationenvironmentrelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentrelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL: return createDeviceResourceRel();
			case OrganizationenvironmentrelPackage.ROLE_REL: return createRoleRel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceResourceRel createDeviceResourceRel() {
		DeviceResourceRelImpl deviceResourceRel = new DeviceResourceRelImpl();
		return deviceResourceRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleRel createRoleRel() {
		RoleRelImpl roleRel = new RoleRelImpl();
		return roleRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentrelPackage getOrganizationenvironmentrelPackage() {
		return (OrganizationenvironmentrelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OrganizationenvironmentrelPackage getPackage() {
		return OrganizationenvironmentrelPackage.eINSTANCE;
	}

} //OrganizationenvironmentrelFactoryImpl
