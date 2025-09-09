package org.example.taller.clases;

public class Exento implements Impuesto {
    @Override
    public double calcular(double subtotal) {
        return 0;
    }
}
