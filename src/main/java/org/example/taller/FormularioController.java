package org.example.taller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.taller.clases.Cliente;
import org.example.taller.clases.ClienteList;

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

    private ClienteList clienteList;
    private Cliente cliente;

    @FXML
    protected void ingresar() {
        try {
            long cedula = Long.parseLong(id.getText());
            String nombre = nombreField.getText();
            String direccion = direccionField.getText();
            String correo = correoField.getText();

            Cliente cliente = Cliente.builder()
                    .cedula(cedula)
                    .nombre(nombre)
                    .direccion(direccion)
                    .correo(correo)
                    .build();

            this.cliente = cliente;
            this.cliente.valid();

            if (clienteList == null) {
                clienteList = new ClienteList();
            }

            clienteList.agregarCliente(cliente);

            for (Cliente c : clienteList.getClientes()) {
                System.out.println(c.getCedula() + " " + c.getNombre() + " " + c.getDireccion() + " " + c.getCorreo());
            }

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
        } catch (IllegalArgumentException e) {
            String msg = e.getMessage();

            if (msg.contains("nombre")) {
                mostrarErrorCampo(nombreField, campo1, msg);
            } else if (msg.contains("dirección")) {
                mostrarErrorCampo(direccionField, campo2, msg);
            } else if (msg.contains("correo")) {
                mostrarErrorCampo(correoField, campo3, msg);
            } else {
                numero.setVisible(true);
                numero.setManaged(true);
                numero.setText(msg);
            }
        }
    }

    private void mostrarErrorCampo(TextField campo,Label label, String mensaje) {
        label.setVisible(true);
        label.setManaged(true);
        label.setText(mensaje);
        campo.requestFocus();
    }
}
