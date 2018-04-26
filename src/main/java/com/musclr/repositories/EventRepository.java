package com.musclr.repositories;

import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.Participate;
import com.musclr.domain.links.Situated;
import com.musclr.domain.nodes.Event;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface EventRepository extends Neo4jRepository<Event, Long> {

	@Query("MATCH (e:Event) RETURN e")
	Collection<Event> getEvents();

	@Query("MATCH (e:Event)-[r:PARTICIPATE]-(u:User) RETURN e,r,u")
	Collection<Participate> getParticipate();

	@Query("MATCH (e:Event)-[r:EVENT_LOCATION]-(t:Town) RETURN e,r,t")
	Collection<EventLocation> getEventLocation();

	@Query("MATCH (e:Event)-[r:SITUATED]-(g:Gym) RETURN e,r,g")
	Collection<Situated> getSituated();
}
