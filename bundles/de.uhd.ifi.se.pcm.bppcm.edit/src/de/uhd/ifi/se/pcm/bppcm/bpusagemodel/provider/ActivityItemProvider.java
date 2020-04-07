package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;

public class ActivityItemProvider extends ActivityItemProviderGen {

	public ActivityItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_Activity_type") + " \"" +
				((Activity) object).getEntityName() + "\"";
		// --End manually modified code
	}

}
