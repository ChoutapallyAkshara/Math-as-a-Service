package org.example.graph.service;

import java.util.List;
import java.util.Map;

public interface GraphService {
    Map<String, Object> findConnectedComponents(Map<String, List<Integer>> graph);
    Map<String, Integer> greedyColoring(Map<String, List<Integer>> graph);
}

