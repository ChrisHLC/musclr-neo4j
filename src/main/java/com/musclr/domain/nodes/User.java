package com.musclr.domain.nodes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Node {

	private String group = "users";

	private String email;

	private String username;

	private String role;

	private String level;

}
