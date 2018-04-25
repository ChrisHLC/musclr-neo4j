package com.musclr.services;

import com.musclr.domain.nodes.Event;
import com.musclr.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.musclr.domain.KeysName.*;
import static com.musclr.services.util.Neo4jToD3.elementKeyList;
import static com.musclr.services.util.Neo4jToD3.map;

@Service
public class EventService {

	private final EventRepository eventRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, WORKOUT);

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}


	@Transactional(readOnly = true)
	public Map<String, Object> getEvents(int limit) {
		Collection<Event> result = eventRepository.getEvents(limit);
		return toD3Format(result);
	}

	private Map<String, Object> toD3Format(Collection<Event> events) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> links = new ArrayList<>();
		Iterator<Event> result = events.iterator();
		result.forEachRemaining(event -> {
			nodes.add(map(nodeKeyList, Arrays.asList(event.getId(), event.getWorkout())));
		});
		return map(elementKeyList, Arrays.asList(nodes, links));
	}

}
