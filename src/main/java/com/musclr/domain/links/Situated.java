package com.musclr.domain.links;

import com.musclr.domain.nodes.Event;
import com.musclr.domain.nodes.Gym;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.RelationshipEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "SITUATED")
public class Situated extends Link<Event, Gym> {

	private String label = "Situated";
}
