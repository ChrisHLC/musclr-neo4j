package com.musclr.controller;

import com.musclr.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public Map<String, Object> getUsers(@RequestParam(value = "events", required = false) Boolean events,
	                                    @RequestParam(value = "gyms", required = false) Boolean gyms,
	                                    @RequestParam(value = "towns", required = false) Boolean towns) {
		return userService.getUsers(events == null ? false : events, gyms == null ? false : gyms, towns == null ? false : towns);
	}
}
