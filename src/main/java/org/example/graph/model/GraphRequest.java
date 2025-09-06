package org.example.graph.model;

import java.util.List;
import java.util.Map;

public class GraphRequest {
    private Map<String, List<Integer>> graph;

    public Map<String, List<Integer>> getGraph() {
        return graph;
    }

    public void setGraph(Map<String, List<Integer>> graph) {
        this.graph = graph;
    }
}

