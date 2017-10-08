/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.*;

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
public class BpusagerelFactoryImpl extends EFactoryImpl implements BpusagerelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BpusagerelFactory init() {
		try {
			BpusagerelFactory theBpusagerelFactory = (BpusagerelFactory)EPackage.Registry.INSTANCE.getEFactory(BpusagerelPackage.eNS_URI);
			if (theBpusagerelFactory != null) {
				return theBpusagerelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BpusagerelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagerelFactoryImpl() {
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
			case BpusagerelPackage.ACTOR_STEP_REL: return createActorStepRel();
			case BpusagerelPackage.RELEASE_DEVICE_RESOURCE_ACTION_REL: return createReleaseDeviceResourceActionRel();
			case BpusagerelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION_REL: return createAcquireDeviceResourceActionRel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorStepRel createActorStepRel() {
		ActorStepRelImpl actorStepRel = new ActorStepRelImpl();
		return actorStepRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseDeviceResourceActionRel createReleaseDeviceResourceActionRel() {
		ReleaseDeviceResourceActionRelImpl releaseDeviceResourceActionRel = new ReleaseDeviceResourceActionRelImpl();
		return releaseDeviceResourceActionRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcquireDeviceResourceActionRel createAcquireDeviceResourceActionRel() {
		AcquireDeviceResourceActionRelImpl acquireDeviceResourceActionRel = new AcquireDeviceResourceActionRelImpl();
		return acquireDeviceResourceActionRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagerelPackage getBpusagerelPackage() {
		return (BpusagerelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BpusagerelPackage getPackage() {
		return BpusagerelPackage.eINSTANCE;
	}

} //BpusagerelFactoryImpl
