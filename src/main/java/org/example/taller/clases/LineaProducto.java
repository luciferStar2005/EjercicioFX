package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class LineaProducto {
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public double calcularSubtotal(){
        return producto.getPrecio() * cantidad;
    }
}
