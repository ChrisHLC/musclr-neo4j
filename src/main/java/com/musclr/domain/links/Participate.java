package com.musclr.domain.links;

import com.musclr.domain.nodes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "PARTICIPATE")
public class Participate {

	@Id
	@GeneratedValue
	private Long id;

	@StartNode
	private User source;

	@EndNode
	private User target;
}
