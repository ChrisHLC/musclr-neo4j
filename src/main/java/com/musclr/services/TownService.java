package com.musclr.services;

import com.musclr.repositories.TownRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.musclr.domain.KeysName.*;
import static com.musclr.services.util.Neo4jToD3.getLinkedNodes;

@Service
public class TownService {

	private final TownRepository townRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, LABEL, GROUP);
	private final List<String> linkKeyList = Collections.singletonList(LABEL);

	public TownService(TownRepository townRepository) {
		this.townRepository = townRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getTowns(Map<String, Boolean> booleanMap) {
		return getLinkedNodes(townRepository, nodeKeyList, linkKeyList, booleanMap);
	}
}
