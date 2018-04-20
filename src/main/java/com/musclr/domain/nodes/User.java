package com.musclr.domain.nodes;

import com.musclr.domain.links.Friend;
import com.musclr.domain.links.Coach;
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
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String username;
	private String role;
	private String level;

	@Relationship(type = "FRIEND")
	private List<Friend> friends = new ArrayList<>();

	@Relationship(type = "COACH")
	private List<Coach> coaches = new ArrayList<>();
}