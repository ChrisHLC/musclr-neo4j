package com.musclr.controller;

import com.musclr.services.TownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/towns")
public class TownController {

	private final TownService townService;

	public TownController(TownService townService) {
		this.townService = townService;
	}

	@GetMapping("")
	public Map<String, Object> getTowns(@RequestParam(value = "Users", required = false) Boolean users,
	                                    @RequestParam(value = "Events", required = false) Boolean events,
	                                    @RequestParam(value = "Gyms", required = false) Boolean gyms) {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("Users", users == null ? false : users);
		booleanMap.put("Events", events == null ? false : events);
		booleanMap.put("Gyms", gyms == null ? false : gyms);
		return townService.getTowns(booleanMap);
	}
}
