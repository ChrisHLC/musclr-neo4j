package com.musclr.repositories;

import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.Link;
import com.musclr.domain.links.Situated;
import com.musclr.domain.nodes.Event;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Collection;

public interface EventRepository extends NodeRepository<Event, Long> {

	@Query("MATCH (e:Event) RETURN e")
	Collection<Event> getNodes();

	@Query("MATCH (e:Event)-[r:PARTICIPATE|CREATE]-(u:User) RETURN e,r,u")
	Collection<? extends Link> getUsers();
	
	@Query("MATCH (e:Event)-[r:EVENT_LOCATION]-(t:Town) RETURN e,r,t")
	Collection<EventLocation> getTowns();

	@Query("MATCH (e:Event)-[r:SITUATED]-(g:Gym) RETURN e,r,g")
	Collection<Situated> getGyms();
}
