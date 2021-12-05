package co.edu.unbosque.view;

import co.edu.unbosque.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ProductoManager extends JPanel {

    private JLabel imagen;

    private JButton agregar;

    private JButton remover;

    private Producto producto;

    private JLabel label;

    private boolean permitirAgregar;

    public ProductoManager(Producto producto, boolean permitirAgregar) {
        this.permitirAgregar = permitirAgregar;
        this.producto = producto;
        setLayout(new BorderLayout());
        setVisible(true);
        init();
    }

    public void init() {
        imagen = new JLabel(producto.getImagenProducto());
        add(imagen, BorderLayout.NORTH);

        ArrayList<String> descripcionPartes = new ArrayList<>();

        String descripcionArray = producto.getLoreProducto();
        String mensaje = "";
        for (int i = 0; i < descripcionArray.length(); i++) {
            if (!(mensaje.length() == 20)) {
                mensaje += descripcionArray.charAt(i);
            } else {
                i--;
                descripcionPartes.add(mensaje);
                mensaje = "";
            }
        }

        label = new JLabel("<html><body><h1 style=\"color:black;font-size:13px;\">" + producto.getNombreProducto().toUpperCase() + "</h1><p style=\"font-size;6px;\">");
        label.setVerticalAlignment(JLabel.TOP);
        //label.setHorizontalAlignment(JLabel.LEFT);
        for (String descripcionParte : descripcionPartes) {
            label.setText(label.getText() + descripcionParte + "<br>");
        }
        label.setText(label.getText() + "</p><p1 style=\"color:black;font-size:5px;\">$ " + producto.getPrecioProducto() + "</body></html>");
        add(label, BorderLayout.CENTER);

        JPanel botones = new JPanel(new GridLayout(1, 2, -30, 0));

        if (permitirAgregar) {
            agregar = new JButton();
            agregar.setActionCommand("AGREGAR_PRODUCTO_" + producto.getIdProducto());
            //agregar.setContentAreaFilled(false);
            //agregar.setBorderPainted(false);
            agregar.setHorizontalTextPosition(SwingConstants.LEFT);
            //agregar.setOpaque(false);
            agregar.setPressedIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/agregado.png/"))).getImage().getScaledInstance(60, 25, Image.SCALE_SMOOTH)));
            agregar.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/agregar.png/"))).getImage().getScaledInstance(70, 25, Image.SCALE_SMOOTH)));
            agregar.setMargin(new Insets(0, 0, 0, 0));
            botones.add(agregar);
        }

        remover = new JButton();
        remover.setActionCommand("REMOVER_PRODUCTO_" + producto.getIdProducto());
/*        remover.setContentAreaFilled(false);
        remover.setBorderPainted(false);
        remover.setOpaque(false);*/
        remover.setPressedIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/removido.png/"))).getImage().getScaledInstance((producto.getImagenProducto().getIconWidth() / 3), 25, Image.SCALE_SMOOTH)));
        remover.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/remover.png/"))).getImage().getScaledInstance((producto.getImagenProducto().getIconWidth() / 3), 25, Image.SCALE_SMOOTH)));
        botones.add(remover);

        add(botones, BorderLayout.SOUTH);
    }

    public JButton getAgregar() {
        return agregar;
    }

    public JButton getRemover() {
        return remover;
    }
}
