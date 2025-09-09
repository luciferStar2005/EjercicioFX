package org.example.taller;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.taller.clases.*;
public class CapturaProductoController {

    @FXML
    private TextField idField;
    @FXML
    private TextArea descripcionField;
    @FXML
    private TextField precioField;
    @FXML
    private TextField stockField;
    @FXML
    private Label status;
    @FXML
    private CheckBox chkExento;

    private ProductList productos;

    @FXML
    public void initialize() {
        productos= new ProductList();
    }

    @FXML
    private void capturarProducto() {
        try {
            int id = Integer.parseInt(idField.getText());
            String descripcion = descripcionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());

            Impuesto impuesto = chkExento.isSelected() ? new Exento() : new IVA19();

            Producto producto = new Producto(id, descripcion, precio, stock, impuesto, chkExento.isSelected());
            producto.valid();

            productos.getList().add(producto);

            status.setText("Producto capturado correctamente.");
            status.setVisible(true);
            status.setManaged(true);


        }catch (NumberFormatException e) {
            status.setText("Error en el formato de los campos numéricos.");
            status.setVisible(true);
            status.setManaged(true);
        } catch (IllegalArgumentException e) {
            status.setText(e.getMessage());
            status.setVisible(true);
            status.setManaged(true);
        }
    }

    @FXML
    private void actualizar(){

    }
}
