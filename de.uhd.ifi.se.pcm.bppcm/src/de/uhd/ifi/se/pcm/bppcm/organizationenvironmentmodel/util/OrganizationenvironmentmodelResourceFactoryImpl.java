/**
 */
package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.util.OrganizationenvironmentmodelResourceImpl
 * @generated
 */
public class OrganizationenvironmentmodelResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentmodelResourceFactoryImpl() {
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
		Resource result = new OrganizationenvironmentmodelResourceImpl(uri);
		return result;
	}

} //OrganizationenvironmentmodelResourceFactoryImpl
