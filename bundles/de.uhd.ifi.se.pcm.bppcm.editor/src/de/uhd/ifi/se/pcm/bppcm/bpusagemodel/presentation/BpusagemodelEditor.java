package de.uhd.ifi.se.pcm.bppcm.bpusagemodel.presentation;

import java.util.Arrays;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.palladiosimulator.pcm.allocation.provider.AllocationItemProviderAdapterFactory;
import org.palladiosimulator.pcm.core.composition.provider.CompositionItemProviderAdapterFactory;
import org.palladiosimulator.pcm.core.entity.provider.EntityItemProviderAdapterFactory;
import org.palladiosimulator.pcm.core.provider.CoreItemProviderAdapterFactory;
import org.palladiosimulator.pcm.parameter.provider.ParameterItemProviderAdapterFactory;
import org.palladiosimulator.pcm.protocol.provider.ProtocolItemProviderAdapterFactory;
import org.palladiosimulator.pcm.provider.PcmItemProviderAdapterFactory;
import org.palladiosimulator.pcm.qosannotations.provider.QosannotationsItemProviderAdapterFactory;
import org.palladiosimulator.pcm.qosannotations.qos_performance.provider.QosPerformanceItemProviderAdapterFactory;
import org.palladiosimulator.pcm.qosannotations.qos_reliability.provider.QosReliabilityItemProviderAdapterFactory;
import org.palladiosimulator.pcm.reliability.provider.ReliabilityItemProviderAdapterFactory;
import org.palladiosimulator.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory;
import org.palladiosimulator.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory;
import org.palladiosimulator.pcm.seff.provider.SeffItemProviderAdapterFactory;
import org.palladiosimulator.pcm.seff.seff_performance.provider.SeffPerformanceItemProviderAdapterFactory;
import org.palladiosimulator.pcm.seff.seff_reliability.provider.SeffReliabilityItemProviderAdapterFactory;
import org.palladiosimulator.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory;
import org.palladiosimulator.pcm.system.provider.SystemItemProviderAdapterFactory;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider.BpusagemodelItemProviderAdapterFactory;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider.BpusagemodelRepositoryItemProviderAdapterFactory;
import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.provider.EnhancedUsagemodelItemProviderAdapterFactory;
import de.uhd.ifi.se.pcm.bppcm.datamodel.provider.DatamodelItemProviderAdapterFactory;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.provider.OrganizationenvironmentmodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;
import de.uka.ipd.sdq.probfunction.provider.ProbfunctionItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.provider.StoexItemProviderAdapterFactory;
import de.uka.ipd.sdq.units.provider.UnitsItemProviderAdapterFactory;

public class BpusagemodelEditor extends BpusagemodelEditorGen {

	/**
	 * This sets up the editing domain for the model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new BpusagemodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new OrganizationenvironmentmodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new DatamodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new IdentifierItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new PcmItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EntityItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CompositionItemProviderAdapterFactory());
		// --Start manually modified code
		adapterFactory.addAdapterFactory(new EnhancedUsagemodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new BpusagemodelRepositoryItemProviderAdapterFactory());
		// --End manually modified code
		adapterFactory.addAdapterFactory(new ResourcetypeItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ProtocolItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ParameterItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReliabilityItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffPerformanceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffReliabilityItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new QosannotationsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new QosPerformanceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new QosReliabilityItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SystemItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ResourceenvironmentItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new AllocationItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SubsystemItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ProbfunctionItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new StoexItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new UnitsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);

								  // Try to select the affected objects.
								  //
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
									  setSelectionToViewer(mostRecentCommand.getAffectedObjects());
								  }
								  for (Iterator<PropertySheetPage> i = propertySheetPages.iterator(); i.hasNext(); ) {
									  PropertySheetPage propertySheetPage = i.next();
									  if (propertySheetPage.getControl().isDisposed()) {
										  i.remove();
									  }
									  else {
										  propertySheetPage.refresh();
									  }
								  }
							  }
						  });
				 }
			 });

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
	
	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		Exception exception = null;
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}
		
		// --Start manually added code
		// Try to load some resources that can be referenced from the bpusagemodel
		String folderPath = resourceURI.trimSegments(1).toPlatformString(false);
		IResource containerResource = ResourcesPlugin.getWorkspace().getRoot().findMember(folderPath);
		Collection<String> fileExtensionsToLoad = Arrays.asList("datamodel", "organizationenvironmentmodel");
		
		if (containerResource instanceof IContainer) {
			try {
				for (IResource member : ((IContainer)containerResource).members()) {
					if (member instanceof IFile && fileExtensionsToLoad.contains(
							member.getFileExtension())) {
						URI URIToLoad = URI.createPlatformResourceURI(member.getFullPath().toString(), false);
						try {
							resource = editingDomain.getResourceSet().getResource(URIToLoad, true);
						} catch (Exception e) {
							exception = e;
							resource = editingDomain.getResourceSet().getResource(URIToLoad, false);
						}
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		// --End manually added code

		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  analyzeResourceProblems(resource, exception));
		}
		editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	}
	
}
