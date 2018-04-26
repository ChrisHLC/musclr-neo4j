package com.musclr.controller;

import com.musclr.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping("")
	public Map<String, Object> getEvents(@RequestParam(value = "users", required = false) Boolean users,
	                                     @RequestParam(value = "gyms", required = false) Boolean gyms,
	                                     @RequestParam(value = "towns", required = false) Boolean towns) {
		return eventService.getEvents(users == null ? false : users, gyms == null ? false : gyms, towns == null ? false : towns);
	}
}
