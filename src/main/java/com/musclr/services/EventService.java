package com.musclr.services;

import com.musclr.domain.nodes.Event;
import com.musclr.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.musclr.domain.GroupName.EVENT;
import static com.musclr.domain.GroupName.USER;
import static com.musclr.domain.KeysName.*;
import static com.musclr.domain.RelationName.PARTICIPATE;
import static com.musclr.services.util.Neo4jToD3.elementKeyList;
import static com.musclr.services.util.Neo4jToD3.map;

@Service
public class EventService {

	private final EventRepository eventRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, WORKOUT, GROUP);
	private final List<String> linkKeyList = Arrays.asList(SOURCE, TARGET, LABEL, SOURCE_GROUP, TARGET_GROUP);

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
		events.forEach(event -> {
			nodes.add(map(nodeKeyList, Arrays.asList(event.getId(), event.getWorkout(), EVENT)));
			Long target = event.getId();

			event.getParticipates().forEach(participant -> {
				Long source = participant.getSource().getId();
				links.add(map(linkKeyList, Arrays.asList(source, target, PARTICIPATE, USER, EVENT)));
			});
		});
		return map(elementKeyList, Arrays.asList(nodes, links));
	}

}
