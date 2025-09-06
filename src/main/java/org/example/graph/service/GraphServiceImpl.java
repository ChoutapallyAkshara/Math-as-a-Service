package org.example.graph.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphServiceImpl implements GraphService {

    @Override
    public Map<String, Object> findConnectedComponents(Map<String, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> groups = new ArrayList<>();

        for (String key : graph.keySet()) {
            int node = Integer.parseInt(key);
            if (!visited.contains(node)) {
                List<Integer> component = new ArrayList<>();
                dfs(node, graph, visited, component);
                groups.add(component);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("components", groups.size());
        result.put("groups", groups);
        return result;
    }

    private void dfs(int node, Map<String, List<Integer>> graph,
                     Set<Integer> visited, List<Integer> component) {
        visited.add(node);
        component.add(node);
        for (int neighbor : graph.getOrDefault(String.valueOf(node), Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    @Override
    public Map<String, Integer> greedyColoring(Map<String, List<Integer>> graph) {
        Map<Integer, Integer> color = new HashMap<>();

        for (String key : graph.keySet()) {
            int node = Integer.parseInt(key);

            // Find colors used by neighbors
            Set<Integer> usedColors = new HashSet<>();
            for (int neighbor : graph.getOrDefault(key, Collections.emptyList())) {
                if (color.containsKey(neighbor)) {
                    usedColors.add(color.get(neighbor));
                }
            }

            // Assign smallest available color
            int assignedColor = 1;
            while (usedColors.contains(assignedColor)) {
                assignedColor++;
            }
            color.put(node, assignedColor);
        }

        // Convert back to string keys
        Map<String, Integer> result = new HashMap<>();
        color.forEach((k, v) -> result.put(String.valueOf(k), v));
        return result;
    }
}

