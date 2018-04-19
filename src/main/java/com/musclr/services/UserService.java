package com.musclr.services;

import com.musclr.domain.User;
import com.musclr.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class UserService {

	private final UserRepository userRepository;

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
		while (result.hasNext()) {
			User user = result.next();
			nodes.add(map("id", user.getId(), "label", user.getUsername()));
			Long source = user.getId();

			for (User friend : user.getFriends()) {
				Long target = friend.getId();
				links.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", links);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}
}
