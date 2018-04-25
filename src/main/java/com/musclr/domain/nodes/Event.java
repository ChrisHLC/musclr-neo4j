package com.musclr.domain.nodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Event {

	@Id
	@GeneratedValue
	private Long id;
	private String group;
	private String workout;

}
