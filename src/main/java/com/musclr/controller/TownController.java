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
	public Map<String, Object> getTowns(@RequestParam(value = "Users", required = false) String users,
	                                    @RequestParam(value = "Events", required = false) String events,
	                                    @RequestParam(value = "Gyms", required = false) String gyms) {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("Users", Boolean.valueOf(users));
		booleanMap.put("Events", Boolean.valueOf(events));
		booleanMap.put("Gyms", Boolean.valueOf(gyms));
		return townService.getTowns(booleanMap);
	}
}
