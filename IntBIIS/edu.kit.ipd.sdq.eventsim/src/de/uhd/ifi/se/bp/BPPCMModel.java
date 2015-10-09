package de.uhd.ifi.se.bp;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationEnvironmentModel;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage;
import edu.kit.ipd.sdq.eventsim.PCMModel;

/**
 * Responsible for loading the organization environment model from bundle
 * 
 * @author Robert Heinrich
 * 
 */
public class BPPCMModel {

    public static OrganizationEnvironmentModel loadFromBundle(final Bundle bundle,
            final IPath businessProcessModelLocation) {

        final URI bpmUri = PCMModel.relativePathToBundleURI(bundle, businessProcessModelLocation);
        
        // the organization environment model is not required in all cases
        // if only IT is simulated, the organization environment model is not required
        if(bpmUri != null){

        	final ResourceSet resourceSet = new ResourceSetImpl();
        	resourceSet.getResource(bpmUri, true);
        	EcoreUtil.resolveAll(resourceSet);

        	OrganizationEnvironmentModel organizationModel = null;

        	for (final Resource r : resourceSet.getResources()) {
        		final EObject o = r.getContents().get(0);
        		if (OrganizationenvironmentmodelPackage.eINSTANCE.getOrganizationEnvironmentModel().isInstance(o)) {
        			organizationModel = (OrganizationEnvironmentModel) o;
        		}
        	}

        	return organizationModel;
    }
  
    
    return null;

    }
}
