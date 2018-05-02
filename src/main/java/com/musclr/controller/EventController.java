package com.musclr.controller;

import com.musclr.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping("")
	public Map<String, Object> getEvents(@RequestParam(value = "Users", required = false) String users,
	                                     @RequestParam(value = "Gyms", required = false) String gyms,
	                                     @RequestParam(value = "Towns", required = false) String towns) {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("Users", Boolean.valueOf(users));
		booleanMap.put("Gyms", Boolean.valueOf(gyms));
		booleanMap.put("Towns", Boolean.valueOf(towns));
		return eventService.getEvents(booleanMap);
	}
}
