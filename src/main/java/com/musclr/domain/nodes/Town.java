package com.musclr.domain.nodes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Town extends Node {

	private String group = "towns";

}
