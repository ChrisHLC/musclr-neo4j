package com.musclr.services;

import com.musclr.repositories.UserRepository;
import com.musclr.services.util.Neo4jToD3;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.musclr.domain.KeysName.*;
import static com.musclr.services.util.Neo4jToD3.getLinkedNodes;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final List<String> nodeKeyList = Arrays.asList(ID, LABEL, ROLE, LEVEL, GROUP);
	private final List<String> linkKeyList = Collections.singletonList(LABEL);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getUsers(Map<String, Boolean> booleanMap) {
		return getLinkedNodes(userRepository, nodeKeyList, linkKeyList, booleanMap);
	}
}
