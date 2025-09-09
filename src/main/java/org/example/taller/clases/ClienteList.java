package org.example.taller.clases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteList {
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    public void agregarCliente(Cliente cliente) {
        cliente.valid();
        clientes.add(cliente);
    }

}
