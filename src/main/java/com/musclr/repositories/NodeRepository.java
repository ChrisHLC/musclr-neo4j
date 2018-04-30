package com.musclr.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Collection;

@NoRepositoryBean
public interface NodeRepository<T, ID extends Serializable> extends Neo4jRepository<T, ID> {

	Collection<T> getNodes();
}
