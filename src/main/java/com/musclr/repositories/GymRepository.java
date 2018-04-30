package com.musclr.repositories;

import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.Situated;
import com.musclr.domain.links.Train;
import com.musclr.domain.nodes.Gym;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Collection;

public interface GymRepository extends NodeRepository<Gym, Long> {

	@Query("MATCH (g:Gym) RETURN g")
	Collection<Gym> getNodes();

	@Query("MATCH (g:Gym)-[r:TRAIN]-(u:User) RETURN g,r,u")
	Collection<Train> getUsers();

	@Query("MATCH (g:Gym)-[r:GYM_LOCATION]-(t:Town) RETURN g,r,t")
	Collection<GymLocation> getTowns();

	@Query("MATCH (g:Gym)-[r:SITUATED]-(e:Event) RETURN g,r,e")
	Collection<Situated> getEvents();
}
