package org.example.graph.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphServiceImplTest {

    private GraphServiceImpl graphService;

    @BeforeEach
    void setUp() {
        graphService = new GraphServiceImpl();
    }

    @Test
    void testConnectedComponentsTwoGroups() {
        Map<String, List<Integer>> graph = new HashMap<>();
        graph.put("0", Arrays.asList(1));
        graph.put("1", Arrays.asList(0, 2));
        graph.put("2", Arrays.asList(1));
        graph.put("3", Arrays.asList(4));
        graph.put("4", Arrays.asList(3));

        Map<String, Object> result = graphService.findConnectedComponents(graph);

        assertEquals(2, result.get("components"));
        List<List<Integer>> groups = (List<List<Integer>>) result.get("groups");
        assertEquals(2, groups.size());
    }

    @Test
    void testConnectedComponentsSingleGroup() {
        Map<String, List<Integer>> graph = new HashMap<>();
        graph.put("0", Arrays.asList(1));
        graph.put("1", Arrays.asList(0, 2));
        graph.put("2", Arrays.asList(1));

        Map<String, Object> result = graphService.findConnectedComponents(graph);

        assertEquals(1, result.get("components"));
    }

    @Test
    void testGraphColoringTriangle() {
        Map<String, List<Integer>> graph = new HashMap<>();
        graph.put("0", Arrays.asList(1, 2));
        graph.put("1", Arrays.asList(0, 2));
        graph.put("2", Arrays.asList(0, 1));

        Map<String, Integer> colors = graphService.greedyColoring(graph);

        assertEquals(3, new HashSet<>(colors.values()).size()); // needs 3 colors
    }

    @Test
    void testGraphColoringSquare() {
        Map<String, List<Integer>> graph = new HashMap<>();
        graph.put("0", Arrays.asList(1, 3));
        graph.put("1", Arrays.asList(0, 2));
        graph.put("2", Arrays.asList(1, 3));
        graph.put("3", Arrays.asList(0, 2));

        Map<String, Integer> colors = graphService.greedyColoring(graph);

        assertTrue(colors.get("0") != colors.get("1"));
        assertTrue(colors.get("1") != colors.get("2"));
        assertTrue(colors.get("2") != colors.get("3"));
        assertTrue(colors.get("3") != colors.get("0"));
        assertEquals(2, new HashSet<>(colors.values()).size()); // 2 colors enough for square
    }
}

