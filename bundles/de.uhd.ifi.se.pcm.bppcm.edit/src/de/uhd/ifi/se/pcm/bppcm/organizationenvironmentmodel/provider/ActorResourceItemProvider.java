package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class ActorResourceItemProvider extends ActorResourceItemProviderGen {

	public ActorResourceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns ActorResource.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/editor/ActorResource.png"));
	}
	
}
