package org.example.matrix.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixServiceImplTest {

    private MatrixServiceImpl matrixService;

    @BeforeEach
    void setUp() {
        matrixService = new MatrixServiceImpl();
    }

    @Test
    void testDeterminant() {
        double[][] matrix = {{2, 3}, {1, 4}};
        double det = matrixService.calculateDeterminant(matrix);
        assertEquals(5.0, det, 1e-6);
    }

    @Test
    void testLU() {
        double[][] matrix = {{2, 3}, {1, 4}};
        double[][][] lu = matrixService.calculateLU(matrix);
        assertEquals(2, lu.length);  // L and U
        assertEquals(2, lu[0].length); // matrix dimension
    }

    @Test
    void testQR() {
        double[][] matrix = {{2, 3}, {1, 4}};
        double[][][] qr = matrixService.calculateQR(matrix);
        assertEquals(2, qr.length);  // Q and R
    }

    @Test
    void testMultiply() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};
        double[][] result = matrixService.multiply(a, b);

        assertArrayEquals(new double[]{19, 22}, result[0], 1e-6);
        assertArrayEquals(new double[]{43, 50}, result[1], 1e-6);
    }

    @Test
    void testInverse() {
        double[][] matrix = {{4, 7}, {2, 6}};
        double[][] inv = matrixService.inverse(matrix);

        // Multiply matrix * inverse = Identity
        double[][] identity = matrixService.multiply(matrix, inv);

        assertEquals(1.0, identity[0][0], 1e-6);
        assertEquals(0.0, identity[0][1], 1e-6);
        assertEquals(0.0, identity[1][0], 1e-6);
        assertEquals(1.0, identity[1][1], 1e-6);
    }

    @Test
    void testTranspose() {
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        double[][] transposed = matrixService.transpose(matrix);

        assertArrayEquals(new double[]{1, 4}, transposed[0], 1e-6);
        assertArrayEquals(new double[]{2, 5}, transposed[1], 1e-6);
        assertArrayEquals(new double[]{3, 6}, transposed[2], 1e-6);
    }
}

