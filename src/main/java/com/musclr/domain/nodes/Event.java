package com.musclr.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

	private String workout;

	private String group = "events";

//	@Relationship(type = "SITUATED")
//	private List<Situated> situated;
//
//	@Relationship(type = "EVENT_LOCATION")
//	private List<EventLocation> eventLocation;
//
//	@Relationship(type = "PARTICIPATE")
//	private List<Participate> participates = new ArrayList<>();

}
