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

    /*public void init() {
        for (Producto producto : arrayProductos) {
            botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
            //nombreBotones = new JPanel(new GridLayout(1,2));
            info = new JPanel(new GridLayout(2, 1, 0, 0));
            contenido = new JPanel(new BorderLayout());

            agregar = new JButton("ASDA");
            contenido.add(agregar, BorderLayout.SOUTH);

            remover = new JButton();
            remover.setBorderPainted(false);
            remover.setContentAreaFilled(false);
            remover.setOpaque(false);
            remover.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/remover.png/"))).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH)));
            botones.add(remover);


            ArrayList<String> descripcionPartes = new ArrayList<>();

            String descripcion = producto.getLoreProducto();
            char[] ch = new char[descripcion.length()];
            String mensaje = "";
            for (int i = 0; i < descripcion.length(); i++) {
                if (!(mensaje.length() == 20)) {
                    mensaje += descripcion.charAt(i);
                } else {
                    i--;
                    descripcionPartes.add(mensaje);
                    mensaje = "";
                }
            }

            System.out.println(descripcionPartes);
            System.out.println("___________----------------------");

            label = new JLabel();
            label.setIcon(producto.getImagenProducto());
            // label.setBorder(new TitledBorder(producto.getNombreProducto()));
            info.add(label);

            //label = new JLabel("<html><body><p style=\"font-size;6px;\">");
            label = new JLabel("<html><body><h1 style=\"color:black;font-size:13px;\">" + producto.getNombreProducto().toUpperCase() + "</h1><p style=\"font-size;6px;\">");

            label.setVerticalAlignment(JLabel.TOP);
            for (String descripcionParte : descripcionPartes) {
                label.setText(label.getText() + descripcionParte + "<br>");
            }
            label.setText(label.getText() + "</p><p1 style=\"color:black;font-size:5px;\">$ " + producto.getPrecioProducto() + "</body></html>");

*//*            label = new JLabel("<html><body><h1 style=\"color:black;font-size:20px;\">" +
                    producto.getNombreProducto() + "</h1><p style=\"font-size;6px;\">" +
                    producto.getLoreProducto() + "</p></body></html>");*//*
            info.add(label);

*//*            label = new JLabel();
            label.setFont(new Font("Arial", Font.BOLD, 12));
            label.setText("$" + producto.getPrecioProducto());
            info.add(label);*//*


            // contenido.add(label, BorderLayout.NORTH);
            contenido.add(info, BorderLayout.CENTER);
            // contenido.add(agregar, BorderLayout.LINE_START);
            //contenido.add(remover, BorderLayout.LINE_END);
            add(contenido);
        }
    }
}*/

