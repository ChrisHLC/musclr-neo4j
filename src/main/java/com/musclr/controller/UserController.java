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

	@GetMapping("/")
	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return userService.graph(limit == null ? 100 : limit);
	}
}
