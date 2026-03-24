package com.example.parcial;

import java.util.List; 
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/fibwin")
    public RespuestaFibonacci getFibonacci(
            @RequestParam(defaultValue = "10") int n,
            @RequestParam(defaultValue = "3") int k) {

        List<Long> serie = generarFibonacci(n);
        List<Long> ventana = calcularVentana(serie, k);

        String serieStr = joinList(serie);
        String ventanaStr = joinList(ventana);

        return new RespuestaFibonacci(
                "Fibonacci con ventana K=" + k,
                n,
                "serie: " + serieStr + " | ventana: " + ventanaStr
        );
    }

    private List<Long> generarFibonacci(int n) {
        List<Long> serie = new ArrayList<>();
        if (n <= 0) return serie;
        serie.add(0L);
        if (n == 1) return serie;
        serie.add(1L);
        for (int i = 2; i <= n; i++) {
            serie.add(serie.get(i - 1) + serie.get(i - 2));
        }
        return serie;
    }

    private List<Long> calcularVentana(List<Long> serie, int k) {
        List<Long> ventana = new ArrayList<>();
        for (int i = k - 1; i < serie.size(); i++) {
            long suma = 0;
            for (int j = i - k + 1; j <= i; j++) {
                suma += serie.get(j);
            }
            ventana.add(suma);
        }
        return ventana;
    }

    private String joinList(List<Long> lista) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i));
            if (i < lista.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    static class RespuestaFibonacci {
        private String operation;
        private int input;
        private String output;

        public RespuestaFibonacci(String operation, int input, String output) {
            this.operation = operation;
            this.input = input;
            this.output = output;
        }

        public String getOperation() { return operation; }
        public int getInput() { return input; }
        public String getOutput() { return output; }
    }
}