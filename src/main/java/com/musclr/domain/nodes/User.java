package com.musclr.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musclr.domain.links.*;
import lombok.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Node {

	private String group = "users";

	private String email;

	private String username;

	private String role;

	private String level;

//	@Relationship(type = "FRIEND", direction = Relationship.UNDIRECTED)
//	private List<Friend> friends = new ArrayList<>();
//
//	@Relationship(type = "COACH", direction = Relationship.UNDIRECTED)
//	private List<Coach> coaches = new ArrayList<>();
//
//	@JsonIgnoreProperties
//	@Relationship(type = "PARTICIPATE")
//	private List<Participate> participates = new ArrayList<>();
//
//	@Relationship(type = "LIVE")
//	private List<UserLocation> userLocation;
//
//	@Relationship(type = "TRAIN")
//	private List<Train> trains = new ArrayList<>();
}
