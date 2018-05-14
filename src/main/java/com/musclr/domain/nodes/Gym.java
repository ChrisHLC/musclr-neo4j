package com.musclr.domain.nodes;

import com.musclr.domain.links.GymLocation;
import com.musclr.domain.links.Situated;
import com.musclr.domain.links.Train;
import lombok.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Gym extends Node {

	private String group = "gyms";

}
