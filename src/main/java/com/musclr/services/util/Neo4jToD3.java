package com.musclr.services.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.musclr.domain.KeysName.LINKS;
import static com.musclr.domain.KeysName.NODES;

public class Neo4jToD3 {

	public static final List<String> elementKeyList = Arrays.asList(NODES, LINKS);


	private Neo4jToD3() {

	}

	public static Map<String, Object> map(List<String> key, List<Object> value) {
		Map<String, Object> result = new HashMap<>();
		for (int i = 0; i < key.size(); i++) {
			result.put(key.get(i), value.get(i));
		}
		return result;
	}
}
