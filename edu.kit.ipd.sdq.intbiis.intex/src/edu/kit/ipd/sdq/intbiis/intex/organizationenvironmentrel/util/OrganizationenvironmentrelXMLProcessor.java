/**
 */
package edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.util;

import edu.kit.ipd.sdq.intbiis.intex.organizationenvironmentrel.OrganizationenvironmentrelPackage;

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
public class OrganizationenvironmentrelXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationenvironmentrelXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		OrganizationenvironmentrelPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the OrganizationenvironmentrelResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new OrganizationenvironmentrelResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new OrganizationenvironmentrelResourceFactoryImpl());
		}
		return registrations;
	}

} //OrganizationenvironmentrelXMLProcessor
