/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.BpusagemodelPackage;

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
 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelFactory
 * @model kind="package"
 * @generated
 */
public interface BpusagerelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bpusagerel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/PalladioComponentModel/5.1/intex/bpusagerel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bpusagerel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BpusagerelPackage eINSTANCE = edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ActorStepRelImpl <em>Actor Step Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ActorStepRelImpl
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getActorStepRel()
	 * @generated
	 */
	int ACTOR_STEP_REL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__ID = BpusagemodelPackage.ACTOR_STEP__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__ENTITY_NAME = BpusagemodelPackage.ACTOR_STEP__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__SUCCESSOR = BpusagemodelPackage.ACTOR_STEP__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__PREDECESSOR = BpusagemodelPackage.ACTOR_STEP__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Scenario Behaviour Abstract User Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION = BpusagemodelPackage.ACTOR_STEP__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION;

	/**
	 * The feature id for the '<em><b>Processing Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__PROCESSING_TIME = BpusagemodelPackage.ACTOR_STEP__PROCESSING_TIME;

	/**
	 * The feature id for the '<em><b>Resting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__RESTING_TIME = BpusagemodelPackage.ACTOR_STEP__RESTING_TIME;

	/**
	 * The feature id for the '<em><b>Responsible Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__RESPONSIBLE_ROLE = BpusagemodelPackage.ACTOR_STEP__RESPONSIBLE_ROLE;

	/**
	 * The feature id for the '<em><b>Continuously Performed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__CONTINUOUSLY_PERFORMED = BpusagemodelPackage.ACTOR_STEP__CONTINUOUSLY_PERFORMED;

	/**
	 * The feature id for the '<em><b>Interruptable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__INTERRUPTABLE = BpusagemodelPackage.ACTOR_STEP__INTERRUPTABLE;

	/**
	 * The feature id for the '<em><b>Output Data Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__OUTPUT_DATA_OBJECTS = BpusagemodelPackage.ACTOR_STEP__OUTPUT_DATA_OBJECTS;

	/**
	 * The feature id for the '<em><b>Input Data Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__INPUT_DATA_OBJECTS = BpusagemodelPackage.ACTOR_STEP__INPUT_DATA_OBJECTS;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL__FAILURE_PROBABILITY = BpusagemodelPackage.ACTOR_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor Step Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_REL_FEATURE_COUNT = BpusagemodelPackage.ACTOR_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ReleaseDeviceResourceActionRelImpl <em>Release Device Resource Action Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ReleaseDeviceResourceActionRelImpl
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getReleaseDeviceResourceActionRel()
	 * @generated
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__ID = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__ENTITY_NAME = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__SUCCESSOR = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__PREDECESSOR = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Scenario Behaviour Abstract User Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION;

	/**
	 * The feature id for the '<em><b>Passiveresource Release Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__PASSIVERESOURCE_RELEASE_ACTION = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION__PASSIVERESOURCE_RELEASE_ACTION;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Release Device Resource Action Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_DEVICE_RESOURCE_ACTION_REL_FEATURE_COUNT = BpusagemodelPackage.RELEASE_DEVICE_RESOURCE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.AcquireDeviceResourceActionRelImpl <em>Acquire Device Resource Action Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.AcquireDeviceResourceActionRelImpl
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getAcquireDeviceResourceActionRel()
	 * @generated
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__ID = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__ENTITY_NAME = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__SUCCESSOR = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__PREDECESSOR = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Scenario Behaviour Abstract User Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION;

	/**
	 * The feature id for the '<em><b>Passiveresource Acquire Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__PASSIVERESOURCE_ACQUIRE_ACTION = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__TIMEOUT = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__TIMEOUT;

	/**
	 * The feature id for the '<em><b>Timeout Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__TIMEOUT_VALUE = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION__TIMEOUT_VALUE;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Acquire Device Resource Action Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_DEVICE_RESOURCE_ACTION_REL_FEATURE_COUNT = BpusagemodelPackage.ACQUIRE_DEVICE_RESOURCE_ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel <em>Actor Step Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Step Rel</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel
	 * @generated
	 */
	EClass getActorStepRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel#getFailureProbability()
	 * @see #getActorStepRel()
	 * @generated
	 */
	EAttribute getActorStepRel_FailureProbability();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel <em>Release Device Resource Action Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release Device Resource Action Rel</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel
	 * @generated
	 */
	EClass getReleaseDeviceResourceActionRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel#getFailureProbability()
	 * @see #getReleaseDeviceResourceActionRel()
	 * @generated
	 */
	EAttribute getReleaseDeviceResourceActionRel_FailureProbability();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel <em>Acquire Device Resource Action Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acquire Device Resource Action Rel</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel
	 * @generated
	 */
	EClass getAcquireDeviceResourceActionRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel#getFailureProbability()
	 * @see #getAcquireDeviceResourceActionRel()
	 * @generated
	 */
	EAttribute getAcquireDeviceResourceActionRel_FailureProbability();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BpusagerelFactory getBpusagerelFactory();

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
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ActorStepRelImpl <em>Actor Step Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ActorStepRelImpl
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getActorStepRel()
		 * @generated
		 */
		EClass ACTOR_STEP_REL = eINSTANCE.getActorStepRel();

		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_STEP_REL__FAILURE_PROBABILITY = eINSTANCE.getActorStepRel_FailureProbability();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ReleaseDeviceResourceActionRelImpl <em>Release Device Resource Action Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.ReleaseDeviceResourceActionRelImpl
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getReleaseDeviceResourceActionRel()
		 * @generated
		 */
		EClass RELEASE_DEVICE_RESOURCE_ACTION_REL = eINSTANCE.getReleaseDeviceResourceActionRel();

		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY = eINSTANCE.getReleaseDeviceResourceActionRel_FailureProbability();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.AcquireDeviceResourceActionRelImpl <em>Acquire Device Resource Action Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.AcquireDeviceResourceActionRelImpl
		 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelPackageImpl#getAcquireDeviceResourceActionRel()
		 * @generated
		 */
		EClass ACQUIRE_DEVICE_RESOURCE_ACTION_REL = eINSTANCE.getAcquireDeviceResourceActionRel();

		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACQUIRE_DEVICE_RESOURCE_ACTION_REL__FAILURE_PROBABILITY = eINSTANCE.getAcquireDeviceResourceActionRel_FailureProbability();

	}

} //BpusagerelPackage
