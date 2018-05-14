package com.musclr.domain.links;

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
@RelationshipEntity(type = "FRIEND")
public class Friend extends Link<User, User> {

	private String label = "Friend";

	@Override
	public boolean getDirected() {
		return false;
	}
}
