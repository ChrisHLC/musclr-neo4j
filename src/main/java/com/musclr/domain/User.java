package com.musclr.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String username;

	@Relationship(type = "FRIEND")
	private List<User> friends = new ArrayList<>();

	public User() {
	}

	public User(Long id, String email, String username, List<User> friends) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.friends = friends;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
}
