package com.musclr.services;

import com.musclr.domain.links.Link;
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

	private final List<String> nodeKeyList = Arrays.asList(ID, LABEL, GROUP);

	private final List<String> linkKeyList = Arrays.asList(SOURCE, TARGET, LABEL);

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getEvents(boolean users, boolean gyms, boolean towns) {
		Collection<Event> nodes = eventRepository.getEvents();
		Collection<Link> links = new ArrayList<>();
		List<Map<String, Object>> nodesJson = new ArrayList<>();
		List<Map<String, Object>> linksJson = new ArrayList<>();

		if (users) {
			links.addAll(eventRepository.getParticipate());
		}
		if (gyms) {
			links.addAll(eventRepository.getSituated());
		}
		if (towns) {
			links.addAll(eventRepository.getEventLocation());
		}

		nodes.forEach(node -> nodesJson.add(map(nodeKeyList, Arrays.asList(node.getId(), node.getLabel(), node.getGroup()))));
		links.forEach(link -> linksJson.add(map(linkKeyList, Arrays.asList(link.getSource().getId(), link.getTarget().getId(), link.getLabel()))));

		return map(elementKeyList, Arrays.asList(nodesJson, linksJson));
	}
}
