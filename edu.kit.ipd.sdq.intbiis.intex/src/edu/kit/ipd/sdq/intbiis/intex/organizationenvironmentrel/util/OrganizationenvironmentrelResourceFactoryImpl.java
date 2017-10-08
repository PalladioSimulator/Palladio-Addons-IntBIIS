/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.util.OrganizationenvironmentrelResourceImpl
 * @generated
 */
public class OrganizationenvironmentrelResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentrelResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new OrganizationenvironmentrelResourceImpl(uri);
		return result;
	}

} //OrganizationenvironmentrelResourceFactoryImpl
