package org.example.matrix.service;

public interface MatrixService {
    double calculateDeterminant(double[][] matrix);
    double[][][] calculateLU(double[][] matrix);
    double[][][] calculateQR(double[][] matrix);

    double[][] multiply(double[][] a, double[][] b);
    double[][] inverse(double[][] matrix);
    double[][] transpose(double[][] matrix);
}


