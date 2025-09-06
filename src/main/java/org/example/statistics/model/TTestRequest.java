package org.example.statistics.model;

import java.util.List;

public class TTestRequest {
    private List<Double> sample1;
    private List<Double> sample2;

    public List<Double> getSample1() {
        return sample1;
    }
    public void setSample1(List<Double> sample1) {
        this.sample1 = sample1;
    }

    public List<Double> getSample2() {
        return sample2;
    }
    public void setSample2(List<Double> sample2) {
        this.sample2 = sample2;
    }
}

