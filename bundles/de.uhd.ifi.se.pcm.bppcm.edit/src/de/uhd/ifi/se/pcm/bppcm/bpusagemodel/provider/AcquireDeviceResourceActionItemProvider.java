package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.AcquireDeviceResourceAction;

public class AcquireDeviceResourceActionItemProvider extends AcquireDeviceResourceActionItemProviderGen {

	public AcquireDeviceResourceActionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		// --Start manually modified code
		return getString("_UI_AcquireDeviceResourceAction_type") + " \"" 
				+ ((AcquireDeviceResourceAction) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
