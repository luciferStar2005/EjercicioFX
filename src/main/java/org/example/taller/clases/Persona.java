package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Persona {
    private long cedula;
    private String nombre;
    private String direccion;
    private String correo;
}
