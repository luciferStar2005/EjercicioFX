package org.example.taller.clases;



public class ProductList extends AdminList<Producto> {

    public Producto buscarPorCodigo(int codigo) {
        for (Producto producto : list) {
            if (producto.getId()==codigo) {
                return producto;
            }
        }
        return null;
    }
}
