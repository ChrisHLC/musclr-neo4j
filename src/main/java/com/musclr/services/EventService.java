package com.musclr.services;

import com.musclr.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.musclr.domain.KeysName.*;
import static com.musclr.services.util.Neo4jToD3.getLinkedNodes;

@Service
public class EventService {

	private final EventRepository eventRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, LABEL, GROUP);
	private final List<String> linkKeyList = Arrays.asList(LABEL, DIRECTED);

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getEvents(Map<String, Boolean> booleanMap) {
		return getLinkedNodes(eventRepository, nodeKeyList, linkKeyList, booleanMap);
	}

}
