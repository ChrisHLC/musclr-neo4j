package com.musclr.domain.links;

import com.musclr.domain.nodes.Node;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class Link<S extends Node, T extends Node> {

	@Id
	@GeneratedValue
	private Long id;

	@StartNode
	private S source;

	@EndNode
	private T target;

	public String getLabel(){
		return null;
	}
}
