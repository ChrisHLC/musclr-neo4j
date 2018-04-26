package com.musclr.services;

import com.musclr.domain.links.Coach;
import com.musclr.domain.links.Friend;
import com.musclr.domain.links.Link;
import com.musclr.domain.nodes.Event;
import com.musclr.domain.nodes.User;
import com.musclr.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.musclr.domain.GroupName.USER;
import static com.musclr.domain.KeysName.*;
import static com.musclr.domain.RelationName.COACH;
import static com.musclr.domain.RelationName.FRIEND;
import static com.musclr.services.util.Neo4jToD3.elementKeyList;
import static com.musclr.services.util.Neo4jToD3.map;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final List<String> elementKeyList = Arrays.asList(NODES, LINKS);
	private final List<String> nodeKeyList = Arrays.asList(ID, USERNAME, ROLE, LEVEL, GROUP);
	private final List<String> linkKeyList = Arrays.asList(SOURCE, TARGET, LABEL, SOURCE_GROUP, TARGET_GROUP);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> getUsers(int limit) {
		Collection<User> result = userRepository.getUsers(limit);
		return toD3Format(result);
	}

	private Map<String, Object> toD3Format(Collection<User> users) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> links = new ArrayList<>();
		users.forEach(user -> {
			nodes.add(map(nodeKeyList, Arrays.asList(user.getId(), user.getUsername(), user.getRole(), user.getLevel(), USER)));
			Long source = user.getId();

			for (Friend friend : user.getFriends()) {
				Long target = friend.getTarget().getId();
				links.add(map(linkKeyList, Arrays.asList(source, target, FRIEND, USER, USER)));
			}

			for (Coach coach : user.getCoaches()) {
				Long target = coach.getTarget().getId();
				links.add(map(linkKeyList, Arrays.asList(source, target, COACH, USER, USER)));
			}
		});
		return map(elementKeyList, Arrays.asList(nodes, links));
	}

	public Map<String,Object> getUsers(boolean events, boolean gyms, boolean towns) {
		Collection<Event> nodes = userRepository.getUsers();
		Collection<Link> links = new ArrayList<>();
		List<Map<String, Object>> nodesJson = new ArrayList<>();
		List<Map<String, Object>> linksJson = new ArrayList<>();

		if (events) {
			links.addAll(userRepository.get());
		}
		if (gyms) {
			links.addAll(userRepository.getSituated());
		}
		if (towns) {
			links.addAll(userRepository.getEventLocation());
		}

		nodes.forEach(node -> nodesJson.add(map(nodeKeyList, Arrays.asList(node.getId(), node.getLabel(), node.getGroup()))));
		links.forEach(link -> linksJson.add(map(linkKeyList, Arrays.asList(link.getSource().getId(), link.getTarget().getId(), link.getLabel()))));

		return map(elementKeyList, Arrays.asList(nodesJson, linksJson));
		
	}
}
