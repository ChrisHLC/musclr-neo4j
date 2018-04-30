package com.musclr.services.util;

import com.musclr.domain.links.Link;
import com.musclr.domain.nodes.Node;
import com.musclr.domain.nodes.User;
import com.musclr.repositories.NodeRepository;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static com.musclr.domain.KeysName.*;

public class Neo4jToD3 {

	private static final List<String> elementKeyList = Arrays.asList(NODES, LINKS);

	private Neo4jToD3() {
	}

	public static Map<String, Object> getLinkedNodes(NodeRepository repository, List<String> nodeKeyList, List<String> linkKeyList, Map<String, Boolean> booleanMap) {
		Collection<Node> nodes = repository.getNodes();
		Collection<Link> links = new ArrayList<>();
		List<Map<String, Object>> nodesJson = new ArrayList<>();
		List<Map<String, Object>> linksJson = new ArrayList<>();
		try {
			for (Map.Entry<String, Boolean> entry : booleanMap.entrySet()) {
				if (entry.getValue()) {
					String methodName = "get" + entry.getKey();
					Method method = repository.getClass().getDeclaredMethod(methodName);
					links.addAll((Collection<? extends Link>) method.invoke(repository));
				}
			}
		} catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		nodes.forEach(node -> nodesJson.add(mapNode(nodeKeyList, node)));
		links.forEach(link -> linksJson.add(mapLink(linkKeyList, link)));

		return map(elementKeyList, Arrays.asList(nodesJson, linksJson));
	}

	private static Map<String, Object> map(List<String> key, List<Object> value) {
		Map<String, Object> result = new HashMap<>();
		for (int i = 0; i < key.size(); i++) {
			result.put(key.get(i), value.get(i));
		}
		return result;
	}

	private static Map<String, Object> mapNode(List<String> keys, Node node) {
		Map<String, Object> result = new HashMap<>();
		return reflectionMap(keys, node, result);
	}


	private static Map<String, Object> mapLink(List<String> keys, Link link) {
		Map<String, Object> result = new HashMap<>();
		result.put(SOURCE, link.getSource().getId());
		result.put(TARGET, link.getTarget().getId());
		return reflectionMap(keys, link, result);
	}

	private static Map<String, Object> reflectionMap(List<String> keys, Object o, Map<String, Object> result) {
		try {
			for (String key : keys) {
				String methodName = "get" + StringUtils.capitalize(key);
				Method method = o.getClass().getMethod(methodName);
				result.put(key, method.invoke(o));
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}


}
