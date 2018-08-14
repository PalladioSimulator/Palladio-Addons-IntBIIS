/**
 */
package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see de.uhd.ifi.se.pcm.bppcm.bpusagemodel.util.BpusagemodelResourceImpl
 * @generated
 */
public class BpusagemodelResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagemodelResourceFactoryImpl() {
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
		Resource result = new BpusagemodelResourceImpl(uri);
		return result;
	}

} //BpusagemodelResourceFactoryImpl
