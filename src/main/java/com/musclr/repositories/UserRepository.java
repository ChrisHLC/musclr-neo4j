package com.musclr.repositories;

import com.musclr.domain.nodes.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

	@Query("MATCH (f:User)-[r:FRIEND|COACH]-(u:User) RETURN f,r,u LIMIT {limit}")
	Collection<User> graph(@Param("limit") int limit);

}
