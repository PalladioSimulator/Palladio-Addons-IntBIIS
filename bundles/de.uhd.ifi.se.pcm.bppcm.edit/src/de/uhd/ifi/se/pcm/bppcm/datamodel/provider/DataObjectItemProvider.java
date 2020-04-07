package de.uhd.ifi.se.pcm.bppcm.datamodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.datamodel.DataObject;

public class DataObjectItemProvider extends DataObjectItemProviderGen {

	public DataObjectItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_DataObject_type") + " \"" + ((DataObject<?>) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
