
package org.example.matrix.controller;

import org.example.matrix.model.MatrixRequest;
import org.example.matrix.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    @Autowired
    private MatrixService matrixService;

    @PostMapping("/determinant")
    public double getDeterminant(@RequestBody MatrixRequest request) {
        return matrixService.calculateDeterminant(request.getMatrix());
    }

    @PostMapping("/lu")
    public double[][][] getLU(@RequestBody MatrixRequest request) {
        return matrixService.calculateLU(request.getMatrix());
    }

    @PostMapping("/qr")
    public double[][][] getQR(@RequestBody MatrixRequest request) {
        return matrixService.calculateQR(request.getMatrix());
    }

    @PostMapping("/multiply")
    public double[][] multiply(@RequestBody double[][][] matrices) {
        return matrixService.multiply(matrices[0], matrices[1]);
    }

    @PostMapping("/inverse")
    public double[][] inverse(@RequestBody MatrixRequest request) {
        return matrixService.inverse(request.getMatrix());
    }

    @PostMapping("/transpose")
    public double[][] transpose(@RequestBody MatrixRequest request) {
        return matrixService.transpose(request.getMatrix());
    }

    @GetMapping("/ping")
    public String ping() {
        return "Matrix API is running!";
    }
}



