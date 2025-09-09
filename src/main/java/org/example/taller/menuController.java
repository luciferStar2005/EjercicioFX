package org.example.taller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class menuController {
    @FXML
    StackPane contentPane;

    @FXML
    private void abrirFormulario() {
        loadView("formulario-view.fxml");
    }

    protected void loadView(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            contentPane.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirCapturaProducto() {
        loadView("capturaProducto.fxml");
    }
}