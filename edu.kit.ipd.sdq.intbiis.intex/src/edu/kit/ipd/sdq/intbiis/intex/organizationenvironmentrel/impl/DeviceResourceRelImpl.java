/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.impl.DeviceResourceImpl;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.DeviceResourceRel;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Resource Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl#getMttf <em>Mttf</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.DeviceResourceRelImpl#getMttr <em>Mttr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeviceResourceRelImpl extends DeviceResourceImpl implements DeviceResourceRel {
	/**
	 * The default value of the '{@link #getMttf() <em>Mttf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttf()
	 * @generated
	 * @ordered
	 */
	protected static final double MTTF_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMttf() <em>Mttf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttf()
	 * @generated
	 * @ordered
	 */
	protected double mttf = MTTF_EDEFAULT;

	/**
	 * The default value of the '{@link #getMttr() <em>Mttr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttr()
	 * @generated
	 * @ordered
	 */
	protected static final double MTTR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMttr() <em>Mttr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttr()
	 * @generated
	 * @ordered
	 */
	protected double mttr = MTTR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceResourceRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationenvironmentrelPackage.Literals.DEVICE_RESOURCE_REL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMttf() {
		return mttf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMttf(double newMttf) {
		double oldMttf = mttf;
		mttf = newMttf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTF, oldMttf, mttf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMttr() {
		return mttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMttr(double newMttr) {
		double oldMttr = mttr;
		mttr = newMttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTR, oldMttr, mttr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTF:
				return getMttf();
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTR:
				return getMttr();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTF:
				setMttf((Double)newValue);
				return;
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTR:
				setMttr((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTF:
				setMttf(MTTF_EDEFAULT);
				return;
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTR:
				setMttr(MTTR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTF:
				return mttf != MTTF_EDEFAULT;
			case OrganizationenvironmentrelPackage.DEVICE_RESOURCE_REL__MTTR:
				return mttr != MTTR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mttf: ");
		result.append(mttf);
		result.append(", mttr: ");
		result.append(mttr);
		result.append(')');
		return result.toString();
	}

} //DeviceResourceRelImpl
