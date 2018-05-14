package com.musclr.domain.nodes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Event extends Node {

	private String workout;

	private String group = "events";

}
