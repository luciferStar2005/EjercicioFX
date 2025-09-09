package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    private int id;
    private String descripcion;
    private double precio;
    private int cantidad;
    private Impuesto impuesto;
    private boolean exento;


    public void valid(){
        if(descripcion == null || descripcion.trim().isEmpty() ||
           precio <= 0 ||
           cantidad < 0){
            throw new IllegalArgumentException("Todos los campos son obligatorios y deben ser validos.");
        }
    }
}
