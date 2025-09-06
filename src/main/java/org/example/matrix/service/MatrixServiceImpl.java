package org.example.matrix.service;

import org.apache.commons.math3.linear.*;
import org.springframework.stereotype.Service;

@Service
public class MatrixServiceImpl implements MatrixService {

    @Override
    public double calculateDeterminant(double[][] matrix) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        return new LUDecomposition(realMatrix).getDeterminant();
    }

    @Override
    public double[][][] calculateLU(double[][] matrix) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        LUDecomposition lu = new LUDecomposition(realMatrix);
        return new double[][][]{lu.getL().getData(), lu.getU().getData()};
    }

    @Override
    public double[][][] calculateQR(double[][] matrix) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        QRDecomposition qr = new QRDecomposition(realMatrix);
        return new double[][][]{qr.getQ().getData(), qr.getR().getData()};
    }

    @Override
    public double[][] multiply(double[][] a, double[][] b) {
        RealMatrix m1 = MatrixUtils.createRealMatrix(a);
        RealMatrix m2 = MatrixUtils.createRealMatrix(b);
        return m1.multiply(m2).getData();
    }

    @Override
    public double[][] inverse(double[][] matrix) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        return new LUDecomposition(realMatrix).getSolver().getInverse().getData();
    }

    @Override
    public double[][] transpose(double[][] matrix) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        return realMatrix.transpose().getData();
    }
}


