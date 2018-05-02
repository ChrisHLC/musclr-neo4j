package com.musclr.domain.links;

import com.musclr.domain.nodes.Gym;
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
@RelationshipEntity(type = "TRAIN")
public class Train extends Link<User, Gym> {

	private String label = "Train";
}
