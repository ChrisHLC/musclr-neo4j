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
	public Map<String, Object> getUsers(@RequestParam(value = "limit",required = false) Integer limit) {
		return eventService.getEvents(limit == null ? 100 : limit);
	}
}
