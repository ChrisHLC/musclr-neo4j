package com.musclr.domain.nodes;

import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.Participate;
import com.musclr.domain.links.Situated;
import lombok.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Event extends Node {

	private String group = "events";

	@Relationship(type = "SITUATED")
	private Situated situated;

	@Relationship(type = "EVENT_LOCATION")
	private EventLocation eventLocation;

	@Relationship(type = "PARTICIPATE", direction = Relationship.INCOMING)
	private List<Participate> participates = new ArrayList<>();

}
