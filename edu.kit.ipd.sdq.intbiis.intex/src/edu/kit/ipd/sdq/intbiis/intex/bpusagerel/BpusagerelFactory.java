/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage
 * @generated
 */
public interface BpusagerelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BpusagerelFactory eINSTANCE = edu.kit.ipd.sdq.intbiis.intex.bpusagerel.impl.BpusagerelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Actor Step Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Step Rel</em>'.
	 * @generated
	 */
	ActorStepRel createActorStepRel();

	/**
	 * Returns a new object of class '<em>Release Device Resource Action Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Release Device Resource Action Rel</em>'.
	 * @generated
	 */
	ReleaseDeviceResourceActionRel createReleaseDeviceResourceActionRel();

	/**
	 * Returns a new object of class '<em>Acquire Device Resource Action Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acquire Device Resource Action Rel</em>'.
	 * @generated
	 */
	AcquireDeviceResourceActionRel createAcquireDeviceResourceActionRel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BpusagerelPackage getBpusagerelPackage();

} //BpusagerelFactory
