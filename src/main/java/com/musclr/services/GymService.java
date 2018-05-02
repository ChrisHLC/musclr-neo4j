package com.musclr.services;

import com.musclr.repositories.GymRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.musclr.domain.KeysName.*;
import static com.musclr.services.util.Neo4jToD3.getLinkedNodes;

@Service
public class GymService {

	private final GymRepository gymRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, LABEL, GROUP);
	private final List<String> linkKeyList = Collections.singletonList(LABEL);

	public GymService(GymRepository gymRepository) {
		this.gymRepository = gymRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getGyms(Map<String, Boolean> booleanMap) {
		return getLinkedNodes(gymRepository, nodeKeyList, linkKeyList, booleanMap);
	}

}
