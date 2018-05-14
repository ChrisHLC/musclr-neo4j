package com.musclr.domain.links;

import org.neo4j.ogm.annotation.RelationshipEntity;

import com.musclr.domain.nodes.Event;
import com.musclr.domain.nodes.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "CREATE")
public class Create extends Link<User, Event>{
	
	private String label = "Create";
}
