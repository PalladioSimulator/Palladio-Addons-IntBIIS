package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.provider;

import java.util.Optional;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role;

public class RoleItemProvider extends RoleItemProviderGen {

	public RoleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Role role = (Role)object;
		String name = Optional.ofNullable(role.getEntityName()).orElse("undefined");
		String id = role.getId();
		String typeString = getString("_UI_Role_type");
		return String.format("%s %s (%s)", typeString, name, id);
	}

}
