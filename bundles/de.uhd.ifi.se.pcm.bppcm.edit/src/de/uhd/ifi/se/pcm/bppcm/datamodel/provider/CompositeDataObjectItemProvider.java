package de.uhd.ifi.se.pcm.bppcm.datamodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.datamodel.CompositeDataObject;

public class CompositeDataObjectItemProvider extends CompositeDataObjectItemProviderGen {

	public CompositeDataObjectItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_CompositeDataObject_type") + " \"" + 
				((CompositeDataObject) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
