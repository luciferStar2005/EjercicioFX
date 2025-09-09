package org.example.taller.clases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class AdminList<t> {
    protected ObservableList<t> list= FXCollections.observableArrayList();

    public void agregar(t item){
        if(item==null) throw new IllegalArgumentException("El item no puede ser nulo");
        if(!list.contains(item)){
            list.add(item);
        }
    }

    public void eliminar(t item) {
        if(item==null) throw new IllegalArgumentException("El item no puede ser nulo");
        list.remove(item);
    }
}
