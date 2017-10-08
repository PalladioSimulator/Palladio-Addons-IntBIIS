/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.BpusagemodelPackage;

import de.uhd.ifi.se.pcm.bppcm.datamodel.DatamodelPackage;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelFactory;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationenvironmentrelPackageImpl extends EPackageImpl implements OrganizationenvironmentrelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceResourceRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleRelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OrganizationenvironmentrelPackageImpl() {
		super(eNS_URI, OrganizationenvironmentrelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OrganizationenvironmentrelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OrganizationenvironmentrelPackage init() {
		if (isInited) return (OrganizationenvironmentrelPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationenvironmentrelPackage.eNS_URI);

		// Obtain or create and register package
		OrganizationenvironmentrelPackageImpl theOrganizationenvironmentrelPackage = (OrganizationenvironmentrelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OrganizationenvironmentrelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OrganizationenvironmentrelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BpusagemodelPackage.eINSTANCE.eClass();
		OrganizationenvironmentmodelPackage.eINSTANCE.eClass();
		DatamodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		BpusagerelPackageImpl theBpusagerelPackage = (BpusagerelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpusagerelPackage.eNS_URI) instanceof BpusagerelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpusagerelPackage.eNS_URI) : BpusagerelPackage.eINSTANCE);

		// Create package meta-data objects
		theOrganizationenvironmentrelPackage.createPackageContents();
		theBpusagerelPackage.createPackageContents();

		// Initialize created meta-data
		theOrganizationenvironmentrelPackage.initializePackageContents();
		theBpusagerelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOrganizationenvironmentrelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OrganizationenvironmentrelPackage.eNS_URI, theOrganizationenvironmentrelPackage);
		return theOrganizationenvironmentrelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceResourceRel() {
		return deviceResourceRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceResourceRel_Mttf() {
		return (EAttribute)deviceResourceRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceResourceRel_Mttr() {
		return (EAttribute)deviceResourceRelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleRel() {
		return roleRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleRel_Mttf() {
		return (EAttribute)roleRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleRel_Mttrep() {
		return (EAttribute)roleRelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentrelFactory getOrganizationenvironmentrelFactory() {
		return (OrganizationenvironmentrelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deviceResourceRelEClass = createEClass(DEVICE_RESOURCE_REL);
		createEAttribute(deviceResourceRelEClass, DEVICE_RESOURCE_REL__MTTF);
		createEAttribute(deviceResourceRelEClass, DEVICE_RESOURCE_REL__MTTR);

		roleRelEClass = createEClass(ROLE_REL);
		createEAttribute(roleRelEClass, ROLE_REL__MTTF);
		createEAttribute(roleRelEClass, ROLE_REL__MTTREP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OrganizationenvironmentmodelPackage theOrganizationenvironmentmodelPackage = (OrganizationenvironmentmodelPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationenvironmentmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deviceResourceRelEClass.getESuperTypes().add(theOrganizationenvironmentmodelPackage.getDeviceResource());
		roleRelEClass.getESuperTypes().add(theOrganizationenvironmentmodelPackage.getRole());

		// Initialize classes and features; add operations and parameters
		initEClass(deviceResourceRelEClass, DeviceResourceRel.class, "DeviceResourceRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeviceResourceRel_Mttf(), ecorePackage.getEDouble(), "mttf", "0.0", 0, 1, DeviceResourceRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeviceResourceRel_Mttr(), ecorePackage.getEDouble(), "mttr", "0.0", 0, 1, DeviceResourceRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleRelEClass, RoleRel.class, "RoleRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoleRel_Mttf(), ecorePackage.getEDouble(), "mttf", "0.0", 0, 1, RoleRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoleRel_Mttrep(), ecorePackage.getEDouble(), "mttrep", "0.0", 0, 1, RoleRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OrganizationenvironmentrelPackageImpl
