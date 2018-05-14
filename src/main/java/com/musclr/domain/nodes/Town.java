package com.musclr.domain.nodes;

import com.musclr.domain.links.EventLocation;
import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.UserLocation;
import lombok.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Town extends Node {

	private String group = "towns";

}
