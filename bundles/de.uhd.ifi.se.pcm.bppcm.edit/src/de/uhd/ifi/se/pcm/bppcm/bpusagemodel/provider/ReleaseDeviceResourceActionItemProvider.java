package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ReleaseDeviceResourceAction;

public class ReleaseDeviceResourceActionItemProvider extends ReleaseDeviceResourceActionItemProviderGen {

	public ReleaseDeviceResourceActionItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_ReleaseDeviceResourceAction_type") + " \"" 
				+ ((ReleaseDeviceResourceAction) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
