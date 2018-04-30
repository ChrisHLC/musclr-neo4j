package com.musclr.repositories;

import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.UserLocation;
import com.musclr.domain.nodes.Town;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Collection;

public interface TownRepository extends NodeRepository<Town, Long> {

	@Query("MATCH (t:Town) RETURN t")
	Collection<Town> getNodes();

	@Query("MATCH (t:Town)-[r:USER_LOCATION]-(u:User) RETURN t,r,u")
	Collection<UserLocation> getUsers();

	@Query("MATCH (t:Town)-[r:GYM_LOCATION]-(g:Gym) RETURN t,r,g")
	Collection<GymLocation> getGyms();

	@Query("MATCH (t:Town)-[r:EVENT_LOCATION]-(e:Event) RETURN t,r,e")
	Collection<EventLocation> getEvents();
}
