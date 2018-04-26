package com.musclr.domain.links;

import com.musclr.domain.nodes.Event;
import com.musclr.domain.nodes.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.RelationshipEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "EVENT_LOCATION")
public class EventLocation extends Link<Event, Town> {

	private String label = "Event";
}
