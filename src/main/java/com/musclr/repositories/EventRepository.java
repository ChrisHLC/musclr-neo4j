package com.musclr.repositories;

import com.musclr.domain.nodes.Event;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EventRepository extends Neo4jRepository<Event, Long> {

	@Query("MATCH (e:Event)-[r:PARTICIPATE]-(u:User) RETURN e,r,u LIMIT {limit}")
	Collection<Event> getEvents(@Param("limit") int limit);

}
