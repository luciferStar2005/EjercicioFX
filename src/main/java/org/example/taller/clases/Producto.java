package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private int id;
    private String descripcion;
    private double precio;
    private int cantidad;


    public void valid(){
        if(descripcion == null || descripcion.trim().isEmpty() ||
           precio <= 0 ||
           cantidad < 0){
            throw new IllegalArgumentException("Todos los campos son obligatorios y deben ser validos.");
        }
    }
}
