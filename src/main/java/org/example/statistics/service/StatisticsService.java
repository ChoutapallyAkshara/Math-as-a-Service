package org.example.statistics.service;

import java.util.Map;

public interface StatisticsService {
    Map<String, Double> linearRegression(double[] x, double[] y);
    Map<String, Object> tTest(double[] sample1, double[] sample2);
}

