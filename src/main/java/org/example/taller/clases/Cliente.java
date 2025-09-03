package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
public class Cliente extends Persona{
    private long cedula;
    private String nombre;
    private String direccion;
    private String correo;

    public void valid() {
        if (nombre == null || nombre.trim().isEmpty() ||
                direccion == null || direccion.trim().isEmpty() ||
                correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo debe contener letras y espacios.");
        }
        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
        }
    }

}
