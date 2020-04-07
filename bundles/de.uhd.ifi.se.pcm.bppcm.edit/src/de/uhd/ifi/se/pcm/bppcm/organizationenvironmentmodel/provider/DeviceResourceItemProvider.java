package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.DeviceResource;

public class DeviceResourceItemProvider extends DeviceResourceItemProviderGen {

	public DeviceResourceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns DeviceResource.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/editor/DeviceResource-icon.png"));
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
		return getString("_UI_DeviceResource_type") + " \"" + 
				((DeviceResource) object).getEntityName() + "\"";
		// --End manually modified code
	}
	
}
