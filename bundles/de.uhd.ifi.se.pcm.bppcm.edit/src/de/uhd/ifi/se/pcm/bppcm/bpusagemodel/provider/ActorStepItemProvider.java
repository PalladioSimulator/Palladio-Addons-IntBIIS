package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;

public class ActorStepItemProvider extends ActorStepItemProviderGen {

	public ActorStepItemProvider(AdapterFactory adapterFactory) {
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
		return getString("_UI_ActorStep_type") + " \"" + ((ActorStep) object).getEntityName() + "\"";
		// --End manually modified code
	}

}
