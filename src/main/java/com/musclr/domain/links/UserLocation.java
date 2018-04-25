package com.musclr.domain.links;

import com.musclr.domain.nodes.Town;
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
@RelationshipEntity(type = "USER_LOCATION")
public class UserLocation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private User source;

    @EndNode
    private Town target;
}
