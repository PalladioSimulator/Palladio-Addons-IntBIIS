package de.uhd.ifi.se.pcm.bppcm.NewEventSimClasses;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourcetype.ResourceType;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import edu.kit.ipd.sdq.eventsim.api.IRequest;
import edu.kit.ipd.sdq.eventsim.api.Procedure;

public interface IActorResource {

	


	void consume(ActorResource specification, IRequest request, double absoluteDemand, int resourceServiceID,
			Procedure onServedCallback);

}
