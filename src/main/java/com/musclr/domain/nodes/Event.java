package com.musclr.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.Participate;
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
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String group;
    private String workout;

    @Relationship(type = "SITUATED")
    private Situated situated;

    @Relationship(type = "EVENT_LOCATION")
    private EventLocation eventLocation;

    @Relationship(type = "PARTICIPATE", direction = Relationship.INCOMING)
    private List<Participate> participates = new ArrayList<>();


}
