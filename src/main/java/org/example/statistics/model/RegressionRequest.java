package org.example.statistics.model;

import java.util.List;

public class RegressionRequest {
    private List<Double> x;
    private List<Double> y;

    public List<Double> getX() {
        return x;
    }
    public void setX(List<Double> x) {
        this.x = x;
    }

    public List<Double> getY() {
        return y;
    }
    public void setY(List<Double> y) {
        this.y = y;
    }
}
