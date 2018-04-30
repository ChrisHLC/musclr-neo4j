package com.musclr.controller;

import com.musclr.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public Map<String, Object> getUsers(@RequestParam(value = "Events", required = false) String events,
	                                    @RequestParam(value = "Gyms", required = false) String gyms,
	                                    @RequestParam(value = "Towns", required = false) String towns) {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("Friends", true);
		booleanMap.put("Events", Boolean.valueOf(events));
		booleanMap.put("Gyms", Boolean.valueOf(gyms));
		booleanMap.put("Towns", Boolean.valueOf(towns));
		return userService.getUsers(booleanMap);
	}
}
