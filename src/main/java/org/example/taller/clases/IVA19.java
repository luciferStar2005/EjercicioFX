package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class IVA19 implements Impuesto{
    private static final double IVA = 0.19;
    private LineaProducto producto;


    @Override
    public double calcular(double subtotal) {
        return subtotal*IVA;
    }
}
