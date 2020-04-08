package de.uhd.ifi.se.pcm.bppcm.datamodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.datamodel.CollectionDataObject;

public class CollectionDataObjectItemProvider extends CollectionDataObjectItemProviderGen {

	public CollectionDataObjectItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_CollectionDataObject_type") + " \"" + 
				((CollectionDataObject) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
