package de.uhd.ifi.se.pcm.bppcm.datamodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.datamodel.InnerDataObjectDeclaration;

public class InnerDataObjectDeclarationItemProvider extends InnerDataObjectDeclarationItemProviderGen {

	public InnerDataObjectDeclarationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		// --Start manually modified code
		InnerDataObjectDeclaration element = (InnerDataObjectDeclaration) object;
		String dataObjectName = element.getDataObject() != null ? 
				element.getDataObject().getEntityName() : "";
		return element.getEntityName() + ": \"" + dataObjectName + "\"";
		// --End manually modified  code
	}
	
}
