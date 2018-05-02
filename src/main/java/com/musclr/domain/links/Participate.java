package com.musclr.domain.links;

import com.musclr.domain.nodes.Event;
import com.musclr.domain.nodes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.RelationshipEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "PARTICIPATE")
public class Participate extends Link<User, Event> {

	private String label = "Participate";
}
