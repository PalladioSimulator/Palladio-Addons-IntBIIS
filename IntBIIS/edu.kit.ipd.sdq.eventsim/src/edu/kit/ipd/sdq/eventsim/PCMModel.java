package edu.kit.ipd.sdq.eventsim;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * This class encapsulates a PCM model and provides a convenient loading mechanism. A PCM model
 * comprises several partial models:
 * <ul>
 * <li>the allocation model</li>
 * <li>the system model</li>
 * <li>the resource environment model</li>
 * <li>the repository model</li>
 * <li>the usage model</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class PCMModel {

    private final Allocation allocationModel;
    private final Repository repositoryModel;
    private final ResourceEnvironment resourceModel;
    private final System systemModel;
    private final UsageModel usageModel;
    private final ResourceRepository resourceRepository;

    private static enum PCMPartialModel {
        USAGE(UsagemodelPackage.eINSTANCE.getUsageModel()), ALLOCATION(AllocationPackage.eINSTANCE.getAllocation()), SYSTEM(
                SystemPackage.eINSTANCE.getSystem()), RESOURCEENVIRONMENT(ResourceenvironmentPackage.eINSTANCE
                .getResourceEnvironment()), REPOSITORY(RepositoryPackage.eINSTANCE.getRepository()), RESOURCEREPOSITORY(
                ResourcetypePackage.eINSTANCE.getResourceRepository());

        private final EClass eClass;

        PCMPartialModel(final EClass eClass) {
            this.eClass = eClass;
        }

        EClass getEClass() {
            return this.eClass;
        }
    }

    /**
     * Default constructor. This constructor is not intended to be used from outside this class.
     * Instead, the {@code loadFromBundle()} method is supposed to be used.
     */
    protected PCMModel(final Allocation allocationModel, final Repository repositoryModel,
            final ResourceEnvironment resourceModel, final System systemModel, final UsageModel usageModel,
            final ResourceRepository resourceRepository) {
        this.allocationModel = allocationModel;
        this.repositoryModel = repositoryModel;
        this.resourceModel = resourceModel;
        this.systemModel = systemModel;
        this.usageModel = usageModel;
        this.resourceRepository = resourceRepository;
    }

    /**
     * Returns the usage model.
     * 
     * @return the usage model
     */
    public UsageModel getUsageModel() {
        return this.usageModel;
    }

    /**
     * Returns the allocation model.
     * 
     * @return the allocation model
     */
    public Allocation getAllocationModel() {
        return this.allocationModel;
    }

    /**
     * Returns the system model.
     * 
     * @return the system model
     */
    public System getSystemModel() {
        return this.systemModel;
    }

    /**
     * Returns the resource environment model.
     * 
     * @return the resource environment model
     */
    public ResourceEnvironment getResourceEnvironmentModel() {
        return this.resourceModel;
    }

    /**
     * Returns the repository model.
     * 
     * @return the repository model
     */
    public Repository getRepositoryModel() {
        return this.repositoryModel;
    }

    /**
     * Returns the resource repository containing the resource types.
     * 
     * @return the resource repository
     */
    public ResourceRepository getResourceRepository() {
        return this.resourceRepository;
    }

    /**
     * Loads a PCM model that is contained in the specified bundle. The loading procedure requires
     * the location of two model files: the usage model and the allocation model.
     * 
     * @param bundle
     *            the bundle containing the model files that are to be loaded
     * @param usageModelLocation
     *            the location of the usage model file
     * @param allocationModelLocation
     *            the location of the allocation model file
     * @return
     */
    public static PCMModel loadFromBundle(final Bundle bundle, final IPath usageModelLocation,
            final IPath allocationModelLocation) {
        final URI usageUri = relativePathToBundleURI(bundle, usageModelLocation);
        final URI allocationUri = relativePathToBundleURI(bundle, allocationModelLocation);

        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(usageUri, true);
        resourceSet.getResource(allocationUri, true);
        EcoreUtil.resolveAll(resourceSet);

        UsageModel usageModel = null;
        Allocation allocationModel = null;
        Repository repositoryModel = null;
        System systemModel = null;
        ResourceEnvironment resourceModel = null;
        ResourceRepository resourceRepository = null;
        for (final Resource r : resourceSet.getResources()) {
            final EObject o = r.getContents().get(0);
            if (PCMPartialModel.USAGE.getEClass().isInstance(o)) {
                usageModel = (UsageModel) o;
            } else if (PCMPartialModel.ALLOCATION.getEClass().isInstance(o)) {
                allocationModel = (Allocation) o;
            } else if (PCMPartialModel.REPOSITORY.getEClass().isInstance(o)) {
                repositoryModel = (Repository) o;
            } else if (PCMPartialModel.SYSTEM.getEClass().isInstance(o)) {
                systemModel = (System) o;
            } else if (PCMPartialModel.RESOURCEENVIRONMENT.getEClass().isInstance(o)) {
                resourceModel = (ResourceEnvironment) o;
            } else if (PCMPartialModel.RESOURCEREPOSITORY.getEClass().isInstance(o)) {
                resourceRepository = (ResourceRepository) o;
            }
        }

        return new PCMModel(allocationModel, repositoryModel, resourceModel, systemModel, usageModel,
                resourceRepository);
    }

    /**
     * Creates an absolute bundle {@link URI} from the specified relative {@code path}.
     * 
     * @param bundle
     *            the bundle that contains the file specified by {@code path}
     * @param path
     *            the relative path
     * @return the absolute URI of {@code path} pointing to a file in the bundle or null, if there
     *         is no such file in the bundle
     */
    public static URI relativePathToBundleURI(final Bundle bundle, final IPath path) {
        final URL bundleUrl = FileLocator.find(bundle, path, null);
        if (bundleUrl == null) {
            return null;
        }
        final URI bundleUri = URI.createURI(bundleUrl.toExternalForm());
        return bundleUri;
    }

}
