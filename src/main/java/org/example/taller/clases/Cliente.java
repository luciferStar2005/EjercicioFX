package org.example.taller.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
public class Cliente extends Persona{

    public void valid() {
        if (getNombre() == null || getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (!getNombre().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo debe contener letras y espacios.");
        }

        if (getDireccion() == null || getDireccion().trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección es obligatoria.");
        }

        if (getCorreo() == null || getCorreo().trim().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio.");
        }
        if (!getCorreo().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
        }
    }

}
