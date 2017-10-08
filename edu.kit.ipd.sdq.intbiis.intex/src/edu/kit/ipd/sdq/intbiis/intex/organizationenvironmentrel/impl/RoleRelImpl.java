/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.impl.RoleImpl;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage;
import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.RoleRel;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl#getMttf <em>Mttf</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.impl.RoleRelImpl#getMttrep <em>Mttrep</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleRelImpl extends RoleImpl implements RoleRel {
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
	 * The default value of the '{@link #getMttrep() <em>Mttrep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttrep()
	 * @generated
	 * @ordered
	 */
	protected static final double MTTREP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMttrep() <em>Mttrep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMttrep()
	 * @generated
	 * @ordered
	 */
	protected double mttrep = MTTREP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationenvironmentrelPackage.Literals.ROLE_REL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationenvironmentrelPackage.ROLE_REL__MTTF, oldMttf, mttf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMttrep() {
		return mttrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMttrep(double newMttrep) {
		double oldMttrep = mttrep;
		mttrep = newMttrep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationenvironmentrelPackage.ROLE_REL__MTTREP, oldMttrep, mttrep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTF:
				return getMttf();
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTREP:
				return getMttrep();
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
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTF:
				setMttf((Double)newValue);
				return;
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTREP:
				setMttrep((Double)newValue);
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
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTF:
				setMttf(MTTF_EDEFAULT);
				return;
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTREP:
				setMttrep(MTTREP_EDEFAULT);
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
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTF:
				return mttf != MTTF_EDEFAULT;
			case OrganizationenvironmentrelPackage.ROLE_REL__MTTREP:
				return mttrep != MTTREP_EDEFAULT;
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
		result.append(", mttrep: ");
		result.append(mttrep);
		result.append(')');
		return result.toString();
	}

} //RoleRelImpl
