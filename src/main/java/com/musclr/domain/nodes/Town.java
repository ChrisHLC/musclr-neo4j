package com.musclr.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.UserLocation;
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
public class Town {

    @Id
    @GeneratedValue
    private Long id;
    private String group;
    private String label;

    @Relationship(type = "EVENT_LOCATION", direction = Relationship.INCOMING)
    private List<EventLocation> eventLocations = new ArrayList<>();

    @Relationship(type = "GYM_LOCATION", direction = Relationship.INCOMING)
    private List<GymLocation> gymLocations = new ArrayList<>();

    @Relationship(type = "USER_LOCATION", direction = Relationship.INCOMING)
    private List<UserLocation> userLocations = new ArrayList<>();
}
