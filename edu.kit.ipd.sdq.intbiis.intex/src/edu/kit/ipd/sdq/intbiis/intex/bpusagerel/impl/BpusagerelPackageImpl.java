/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.BpusagemodelPackage;

import de.uhd.ifi.se.pcm.bppcm.datamodel.DatamodelPackage;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelFactory;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage;
import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.OrganizationenvironmentrelPackageImpl;

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
public class BpusagerelPackageImpl extends EPackageImpl implements BpusagerelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorStepRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass releaseDeviceResourceActionRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acquireDeviceResourceActionRelEClass = null;

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
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BpusagerelPackageImpl() {
		super(eNS_URI, BpusagerelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BpusagerelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BpusagerelPackage init() {
		if (isInited) return (BpusagerelPackage)EPackage.Registry.INSTANCE.getEPackage(BpusagerelPackage.eNS_URI);

		// Obtain or create and register package
		BpusagerelPackageImpl theBpusagerelPackage = (BpusagerelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BpusagerelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BpusagerelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BpusagemodelPackage.eINSTANCE.eClass();
		OrganizationenvironmentmodelPackage.eINSTANCE.eClass();
		DatamodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		OrganizationenvironmentrelPackageImpl theOrganizationenvironmentrelPackage = (OrganizationenvironmentrelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OrganizationenvironmentrelPackage.eNS_URI) instanceof OrganizationenvironmentrelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OrganizationenvironmentrelPackage.eNS_URI) : OrganizationenvironmentrelPackage.eINSTANCE);

		// Create package meta-data objects
		theBpusagerelPackage.createPackageContents();
		theOrganizationenvironmentrelPackage.createPackageContents();

		// Initialize created meta-data
		theBpusagerelPackage.initializePackageContents();
		theOrganizationenvironmentrelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBpusagerelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BpusagerelPackage.eNS_URI, theBpusagerelPackage);
		return theBpusagerelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorStepRel() {
		return actorStepRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorStepRel_FailureProbability() {
		return (EAttribute)actorStepRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReleaseDeviceResourceActionRel() {
		return releaseDeviceResourceActionRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReleaseDeviceResourceActionRel_FailureProbability() {
		return (EAttribute)releaseDeviceResourceActionRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAcquireDeviceResourceActionRel() {
		return acquireDeviceResourceActionRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAcquireDeviceResourceActionRel_FailureProbability() {
		return (EAttribute)acquireDeviceResourceActionRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagerelFactory getBpusagerelFactory() {
		return (BpusagerelFactory)getEFactoryInstance();
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
		actorStepRelEClass = createEClass(ACTOR_STEP_REL);
		createEAttribute(actorStepRelEClass, ACTOR_STEP_REL__FAILURE_PROBABILITY);

		releaseDeviceResourceActionRelEClass = createEClass(RELEASE_DEVICE_RESOURCE_ACTION_REL);
		createEAttribute(releaseDeviceResourceActionRelEClass, RELEASE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY);

		acquireDeviceResourceActionRelEClass = createEClass(ACQUIRE_DEVICE_RESOURCE_ACTION_REL);
		createEAttribute(acquireDeviceResourceActionRelEClass, ACQUIRE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY);
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
		BpusagemodelPackage theBpusagemodelPackage = (BpusagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(BpusagemodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actorStepRelEClass.getESuperTypes().add(theBpusagemodelPackage.getActorStep());
		releaseDeviceResourceActionRelEClass.getESuperTypes().add(theBpusagemodelPackage.getReleaseDeviceResourceAction());
		acquireDeviceResourceActionRelEClass.getESuperTypes().add(theBpusagemodelPackage.getAcquireDeviceResourceAction());

		// Initialize classes and features; add operations and parameters
		initEClass(actorStepRelEClass, ActorStepRel.class, "ActorStepRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActorStepRel_FailureProbability(), ecorePackage.getEDouble(), "failureProbability", "0.0", 0, 1, ActorStepRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(releaseDeviceResourceActionRelEClass, ReleaseDeviceResourceActionRel.class, "ReleaseDeviceResourceActionRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReleaseDeviceResourceActionRel_FailureProbability(), ecorePackage.getEDouble(), "failureProbability", "0.0", 0, 1, ReleaseDeviceResourceActionRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(acquireDeviceResourceActionRelEClass, AcquireDeviceResourceActionRel.class, "AcquireDeviceResourceActionRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAcquireDeviceResourceActionRel_FailureProbability(), ecorePackage.getEDouble(), "failureProbability", "0.0", 0, 1, AcquireDeviceResourceActionRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BpusagerelPackageImpl
