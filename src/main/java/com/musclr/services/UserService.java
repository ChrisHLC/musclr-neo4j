package com.musclr.services;

import com.musclr.domain.links.Coach;
import com.musclr.domain.links.Friend;
import com.musclr.domain.nodes.User;
import com.musclr.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.musclr.domain.KeysName.*;


@Service
public class UserService {

	private final UserRepository userRepository;
	private final List<String> elementKeyList = Arrays.asList(NODES, LINKS);
	private final List<String> nodeKeyList = Arrays.asList(ID, USERNAME, ROLE, LEVEL);
	private final List<String> linkKeyList = Arrays.asList(SOURCE, TARGET, LABEL);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public Map<String, Object> graph(int limit) {
		Collection<User> result = userRepository.graph(limit);
		return toD3Format(result);
	}

	private Map<String, Object> toD3Format(Collection<User> users) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> links = new ArrayList<>();
		Iterator<User> result = users.iterator();
		result.forEachRemaining(user -> {
			nodes.add(map(nodeKeyList, Arrays.asList(user.getId(), user.getUsername(), user.getRole(), user.getLevel())));
			Long source = user.getId();

			for (Friend friend : user.getFriends()) {
				Long target = friend.getTarget().getId();
				links.add(map(linkKeyList, Arrays.asList(source, target, "Friend")));
			}

			for (Coach coach : user.getCoaches()) {
				Long target = coach.getTarget().getId();
				links.add(map(linkKeyList, Arrays.asList(source, target, "Coach")));
			}
		});
		return map(elementKeyList, Arrays.asList(nodes, links));
	}

	private Map<String, Object> map(List<String> key, List<Object> value) {
		Map<String, Object> result = new HashMap<>();
		for (int i = 0; i < key.size(); i++) {
			result.put(key.get(i), value.get(i));
		}
		return result;
	}
}
