package org.example.graph.controller;

import org.example.graph.model.GraphRequest;
import org.example.graph.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/graph")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @PostMapping("/connected-components")
    public Map<String, Object> getConnectedComponents(@RequestBody GraphRequest request) {
        return graphService.findConnectedComponents(request.getGraph());
    }

    @PostMapping("/coloring")
    public Map<String, Integer> getGraphColoring(@RequestBody GraphRequest request) {
        return graphService.greedyColoring(request.getGraph());
    }
}

