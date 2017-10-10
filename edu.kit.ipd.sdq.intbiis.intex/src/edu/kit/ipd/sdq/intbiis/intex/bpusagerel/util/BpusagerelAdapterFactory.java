/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel.util;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.AcquireDeviceResourceAction;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction;

import de.uka.ipd.sdq.identifier.Identifier;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage
 * @generated
 */
public class BpusagerelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BpusagerelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagerelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BpusagerelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BpusagerelSwitch<Adapter> modelSwitch =
		new BpusagerelSwitch<Adapter>() {
			@Override
			public Adapter caseActorStepRel(ActorStepRel object) {
				return createActorStepRelAdapter();
			}
			@Override
			public Adapter caseReleaseDeviceResourceActionRel(ReleaseDeviceResourceActionRel object) {
				return createReleaseDeviceResourceActionRelAdapter();
			}
			@Override
			public Adapter caseAcquireDeviceResourceActionRel(AcquireDeviceResourceActionRel object) {
				return createAcquireDeviceResourceActionRelAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseAbstractUserAction(AbstractUserAction object) {
				return createAbstractUserActionAdapter();
			}
			@Override
			public Adapter caseActorStep(ActorStep object) {
				return createActorStepAdapter();
			}
			@Override
			public Adapter caseReleaseDeviceResourceAction(ReleaseDeviceResourceAction object) {
				return createReleaseDeviceResourceActionAdapter();
			}
			@Override
			public Adapter caseAcquireDeviceResourceAction(AcquireDeviceResourceAction object) {
				return createAcquireDeviceResourceActionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel <em>Actor Step Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ActorStepRel
	 * @generated
	 */
	public Adapter createActorStepRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel <em>Release Device Resource Action Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.ReleaseDeviceResourceActionRel
	 * @generated
	 */
	public Adapter createReleaseDeviceResourceActionRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel <em>Acquire Device Resource Action Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.AcquireDeviceResourceActionRel
	 * @generated
	 */
	public Adapter createAcquireDeviceResourceActionRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.core.entity.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.core.entity.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.usagemodel.AbstractUserAction <em>Abstract User Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.usagemodel.AbstractUserAction
	 * @generated
	 */
	public Adapter createAbstractUserActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep <em>Actor Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep
	 * @generated
	 */
	public Adapter createActorStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction <em>Release Device Resource Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction
	 * @generated
	 */
	public Adapter createReleaseDeviceResourceActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uhd.ifi.se.pcm.bppcm.bpusagemodel.AcquireDeviceResourceAction <em>Acquire Device Resource Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uhd.ifi.se.pcm.bppcm.bpusagemodel.AcquireDeviceResourceAction
	 * @generated
	 */
	public Adapter createAcquireDeviceResourceActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BpusagerelAdapterFactory
