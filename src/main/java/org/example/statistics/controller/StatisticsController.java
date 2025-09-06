package org.example.statistics.controller;

import org.example.statistics.model.RegressionRequest;
import org.example.statistics.model.TTestRequest;
import org.example.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/regression")
    public Map<String, Double> linearRegression(@RequestBody RegressionRequest request) {
        double[] x = request.getX().stream().mapToDouble(Double::doubleValue).toArray();
        double[] y = request.getY().stream().mapToDouble(Double::doubleValue).toArray();
        return statisticsService.linearRegression(x, y);
    }

    @PostMapping("/t-test")
    public Map<String, Object> tTest(@RequestBody TTestRequest request) {
        double[] sample1 = request.getSample1().stream().mapToDouble(Double::doubleValue).toArray();
        double[] sample2 = request.getSample2().stream().mapToDouble(Double::doubleValue).toArray();
        return statisticsService.tTest(sample1, sample2);
    }
}
