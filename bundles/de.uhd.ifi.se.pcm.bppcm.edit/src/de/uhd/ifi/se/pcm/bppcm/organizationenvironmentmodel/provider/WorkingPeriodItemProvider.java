package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class WorkingPeriodItemProvider extends WorkingPeriodItemProviderGen {

	public WorkingPeriodItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns WorkingPeriod.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/editor/WorkingPeriod.png"));
	}
	
}
