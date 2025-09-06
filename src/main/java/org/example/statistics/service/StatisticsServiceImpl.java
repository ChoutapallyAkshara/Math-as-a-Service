package org.example.statistics.service;

import org.apache.commons.math3.stat.inference.TTest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public Map<String, Double> linearRegression(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        // R² calculation
        double ssTot = 0, ssRes = 0;
        double meanY = sumY / n;
        for (int i = 0; i < n; i++) {
            double yPred = slope * x[i] + intercept;
            ssRes += (y[i] - yPred) * (y[i] - yPred);
            ssTot += (y[i] - meanY) * (y[i] - meanY);
        }
        double r2 = 1 - ssRes / ssTot;

        Map<String, Double> result = new HashMap<>();
        result.put("slope", slope);
        result.put("intercept", intercept);
        result.put("r2", r2);

        return result;
    }

    @Override
    public Map<String, Object> tTest(double[] sample1, double[] sample2) {
        TTest tTest = new TTest();
        double pValue = tTest.tTest(sample1, sample2);
        double tStat = tTest.t(sample1, sample2);

        Map<String, Object> result = new HashMap<>();
        result.put("tStatistic", tStat);
        result.put("pValue", pValue);
        result.put("rejectNull", pValue < 0.05); // significance level = 0.05
        return result;
    }
}

