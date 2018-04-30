package com.musclr.repositories;

import com.musclr.domain.links.Link;
import com.musclr.domain.links.Participate;
import com.musclr.domain.links.Train;
import com.musclr.domain.links.UserLocation;
import com.musclr.domain.nodes.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends NodeRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getNodes();

    @Query("MATCH (u:User)-[r:FRIEND|COACH]-(f:User) RETURN u,r,f")
    Collection<? extends Link> getFriends();

    @Query("MATCH (u:User)-[r:USER_LOCATION]-(t:Town) RETURN u,r,t")
    Collection<UserLocation> getTowns();

    @Query("MATCH (u:User)-[r:PARTICIPATE]-(e:Event) RETURN u,r,e")
    Collection<Participate> getEvents();

    @Query("MATCH (u:User)-[r:TRAIN]-(g:Gym) RETURN u,r,g")
    Collection<Train> getGyms();
}
