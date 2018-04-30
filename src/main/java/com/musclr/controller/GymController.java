package com.musclr.controller;

import com.musclr.services.GymService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gyms")
public class GymController {

	private final GymService gymService;

	public GymController(GymService gymService) {
		this.gymService = gymService;
	}

	@GetMapping("")
	public Map<String, Object> getGyms(@RequestParam(value = "Users", required = false) Boolean users,
	                                   @RequestParam(value = "Events", required = false) Boolean events,
	                                   @RequestParam(value = "Towns", required = false) Boolean towns) {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("Users", users == null ? false : users);
		booleanMap.put("Events", events == null ? false : events);
		booleanMap.put("Towns", towns == null ? false : towns);
		return gymService.getGyms(booleanMap);
	}
}
