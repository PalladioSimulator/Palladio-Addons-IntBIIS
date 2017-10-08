/**
 */
package edu.kit.ipd.sdq.intbiis.intex.bpusagerel.util;

import edu.kit.ipd.sdq.intbiis.intex.bpusagerel.BpusagerelPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BpusagerelXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpusagerelXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		BpusagerelPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the BpusagerelResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new BpusagerelResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new BpusagerelResourceFactoryImpl());
		}
		return registrations;
	}

} //BpusagerelXMLProcessor
