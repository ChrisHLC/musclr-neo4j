package com.musclr.repositories;

import com.musclr.domain.links.Train;
import com.musclr.domain.links.UserLocation;
import com.musclr.domain.nodes.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

	@Query("MATCH (u:User) RETURN u")
	Collection<User> getUsers();

	@Query("MATCH (u:User)-[r:FRIEND|COACH]-(f:User) RETURN u,r,f")
	Collection<User> getFriends();

	@Query("MATCH (u:User)-[r:LIVE]-(t:Town) RETURN u,r,t")
	UserLocation getLocation();

	@Query("MATCH (u:User)-[r:PARTICIPATE]-(e:Event) RETURN u,r,e")
	Collection<Train> getTrains();
}
