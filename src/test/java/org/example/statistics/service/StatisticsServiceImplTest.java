package org.example.statistics.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceImplTest {

    private StatisticsServiceImpl statisticsService;

    @BeforeEach
    void setUp() {
        statisticsService = new StatisticsServiceImpl();
    }

    @Test
    void testTTestRejectNull() {
        double[] sample1 = {2.3, 2.5, 2.8, 3.0, 3.2};
        double[] sample2 = {3.1, 3.4, 3.5, 3.8, 4.0};

        Map<String, Object> result = statisticsService.tTest(sample1, sample2);

        assertTrue((double) result.get("pValue") < 0.05);
        assertEquals(true, result.get("rejectNull"));
    }

    @Test
    void testTTestFailToRejectNull() {
        double[] sample1 = {2.0, 2.1, 2.2, 2.3};
        double[] sample2 = {2.05, 2.15, 2.25, 2.35};

        Map<String, Object> result = statisticsService.tTest(sample1, sample2);

        assertNotNull(result.get("pValue"));
        assertTrue((double) result.get("pValue") > 0.05);
        assertEquals(false, result.get("rejectNull"));
    }
}


