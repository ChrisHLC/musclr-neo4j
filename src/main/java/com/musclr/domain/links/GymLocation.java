package com.musclr.domain.links;

import com.musclr.domain.nodes.Gym;
import com.musclr.domain.nodes.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "GYM_LOCATION")
public class GymLocation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Gym source;

    @EndNode
    private Town target;
}
