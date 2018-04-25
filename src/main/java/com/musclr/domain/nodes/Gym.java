package com.musclr.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.Situated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Gym {

    @Id
    @GeneratedValue
    private Long id;
    private String group;
    private String label;

    @Relationship(type = "GYM_LOCATION")
    private GymLocation gymLocation;

    @Relationship(type = "TRAIN", direction = Relationship.INCOMING)
    private List<User> users = new ArrayList<>();

    @Relationship(type = "SITUATED", direction = Relationship.INCOMING)
    private List<Situated> situateds = new ArrayList<>();

}
