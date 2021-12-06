package co.edu.unbosque.view;

import co.edu.unbosque.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaProductos extends JPanel {

    private final ArrayList<Producto> arrayProductos;

    private ArrayList<ProductoManager> productoManagers;

    public ListaProductos(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
        add(init());
        setVisible(true);
    }

    public JPanel init() {
        productoManagers = new ArrayList<>();
        JPanel panel = new JPanel();
        int cantidad = arrayProductos.size();
        panel.setLayout(new GridLayout((cantidad / 3), 4, 20, 20));

        for (Producto productoLista : arrayProductos) {
            ProductoManager producto = new ProductoManager(productoLista, true);
            productoManagers.add(producto);
            panel.add(producto);
        }

        return panel;
    }

    public ArrayList<ProductoManager> getProductoManagers() {
        return productoManagers;
    }
}

