package org.example.taller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.taller.clases.Cliente;

public class FormularioController {
    @FXML private Label status;
    @FXML private Label numero;
    @FXML private Label campo1;
    @FXML private Label campo2;
    @FXML private Label campo3;
    @FXML private TextField id;
    @FXML private TextField nombreField;
    @FXML private TextField direccionField;
    @FXML private TextField correoField;

    private Cliente cliente;

    @FXML
    protected void ingresar() {
        try{
            long cedula = Long.parseLong(id.getText());
            String nombre=nombreField.getText();
            String direccion=direccionField.getText();
            String correo=correoField.getText();

            Cliente cliente = new Cliente(cedula, nombre, direccion, correo);
            cliente.valid();

            status.setText("se agrego correctamente");
            status.setVisible(true);
            status.setManaged(true);
            numero.setVisible(false);
            numero.setManaged(false);
            campo1.setVisible(false);
            campo1.setManaged(false);
            campo2.setVisible(false);
            campo2.setManaged(false);
            campo3.setVisible(false);
            campo3.setManaged(false);

        } catch (NumberFormatException e) {
            numero.setVisible(true);
            numero.setManaged(true);
            numero.setText("error: debe ser un numero");
        }catch(IllegalArgumentException e) {
            if (nombreField.getText() == null || nombreField.getText().trim().isEmpty()) {
                mostrarErrorCampo(nombreField, campo1, e.getMessage());
            } else if (direccionField.getText() == null || direccionField.getText().trim().isEmpty()) {
                mostrarErrorCampo(direccionField, campo2, e.getMessage());
            } else if (correoField.getText() == null || correoField.getText().trim().isEmpty()) {
                mostrarErrorCampo(correoField, campo3, e.getMessage());
            }
        }
    }

    private void mostrarErrorCampo(TextField campo, Label label, String mensaje) {
        label.setVisible(true);
        label.setManaged(true);
        label.setText(mensaje);
        campo.requestFocus();
    }

}
