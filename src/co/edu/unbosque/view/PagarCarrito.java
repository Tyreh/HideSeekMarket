package co.edu.unbosque.view;

import co.edu.unbosque.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PagarCarrito extends JDialog {

    private JLabel productosEnCarrito;

    private JLabel label;

    private JLabel total;

    private JTextField nombre;

    private JTextField tarjeta;

    private JTextField hastaMesCombo;

    private JTextField hastaAnioCombo;

    private JPasswordField cvv;

    private JButton pagar;

    private final ArrayList<Producto> arrayProductos;

    private ArrayList<ProductoManager> enCarritoArray;

    private JTable table;

    private DefaultTableModel defaultTableModel;

    private JScrollPane scrollPane;

    public PagarCarrito(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
        //setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        init();
        setVisible(false);
    }

    public void init2() {
        productosEnCarrito = new JLabel("Tienes 0 productos en el carrito");
        productosEnCarrito.setBounds(0,0,200,20);
        add(productosEnCarrito);
    }

    public void init() {
        //add(header(), BorderLayout.PAGE_START);
        //JScrollPane scrollPane = new JScrollPane(carritoPanel());
        //add(centroPanel(), BorderLayout.LINE_START);
        //add(scrollPane, BorderLayout.LINE_END);
        //add(pagoPanel(), BorderLayout.PAGE_END);

        add(header(), BorderLayout.NORTH);
        add(centroPanel(), BorderLayout.SOUTH);

/*        pagar = new JButton();
        pagar.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/pagar.png/"))).getImage().getScaledInstance(150,50, Image.SCALE_SMOOTH)));
        add(pagar, BorderLayout.PAGE_END);*/
    }

    public JPanel header() {
        JPanel panel = new JPanel(new BorderLayout());

        productosEnCarrito = new JLabel("Tienes 0 productos en el carrito");
        panel.add(productosEnCarrito, BorderLayout.PAGE_START);

/*        defaultTableModel = new DefaultTableModel(new String[]{""}, 0);
        table = new JTable();
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane);*/

        return panel;
    }

    public JPanel centroPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setOpaque(false);

        JPanel infoPanel = new JPanel(new BorderLayout());

        JPanel panelFields = new JPanel(new SpringLayout());
        panelFields.setOpaque(false);

        label = new JLabel("Nombre: ");
        panelFields.add(label);

        nombre = new JTextField(15);
        nombre.setToolTipText("Debe ingresar el nombre del comprador, no el del propietario de la tarjeta.");
        label.setLabelFor(nombre);
        panelFields.add(nombre);

        label = new JLabel("Número de tarjeta: ");
        panelFields.add(label);

        tarjeta = new JTextField(15);
        label.setLabelFor(tarjeta);
        panelFields.add(tarjeta);

        label = new JLabel("Hasta (MM / AAAA): ");
        panelFields.add(label);

        JPanel hastaPanel = seguridadPanel();
        label.setLabelFor(hastaPanel);
        panelFields.add(hastaPanel);

        label = new JLabel("CVV: ");
        panelFields.add(label);

        cvv = new JPasswordField(15);
        cvv.setToolTipText("Por su seguridad, este campo está siendo censurado.");
        label.setLabelFor(cvv);
        panelFields.add(cvv);

        label = new JLabel();
        panelFields.add(label);

        pagar = new JButton();
        label.setLabelFor(pagar);
        pagar.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/pagar.png/"))).getImage().getScaledInstance(150,40, Image.SCALE_SMOOTH)));
        pagar.setBorderPainted(false);
        pagar.setContentAreaFilled(false);
        pagar.setOpaque(false);
        infoPanel.add(pagar, BorderLayout.PAGE_END);

        SpringUtilities.makeCompactGrid(panelFields, 4, 2, 0, 0, 5, 5);

        infoPanel.add(panelFields, BorderLayout.CENTER);

        panel.add(infoPanel);

        return panel;
    }

    public JPanel seguridadPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setOpaque(false);
        JPanel panelFecha = new JPanel(new GridLayout(1, 2, 3, 3));
        panelFecha.setOpaque(false);

        hastaMesCombo = new JTextField();
        panelFecha.add(hastaMesCombo);

        hastaAnioCombo = new JTextField();
        panelFecha.add(hastaAnioCombo);

        JPanel cvv = new JPanel(new SpringLayout());

        label = new JLabel("CVV: ");
        cvv.add(label);

        this.cvv = new JPasswordField();
        this.cvv.setToolTipText("Por su seguridad, este campo está siendo censurado.");
        label.setLabelFor(this.cvv);
        cvv.add(this.cvv);

        SpringUtilities.makeCompactGrid(cvv, 1, 2, 0, 0, 5, 5);

        panel.add(panelFecha);
        //panel.add(cvv);


        return panel;
    }

/*
    public JPanel carritoPanel() {
        enCarritoArray = new ArrayList<>();
        JPanel panel = new JPanel();
        int cantidad = arrayProductos.size();
        panel.setLayout(new GridLayout(cantidad, 1, 20, 20));
        for (Producto productoLista : arrayProductos) {
            ProductoManager producto = new ProductoManager(productoLista, false);
            enCarritoArray.add(producto);
            panel.add(producto);
        }

        return panel;
    }
*/

    public JPanel pagoPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
        panel.setOpaque(false);
        JPanel botones = new JPanel(new GridLayout(1, 2, 3, 3));
        botones.setOpaque(false);

        pagar = new JButton("PAGAR");
        pagar.setActionCommand("CARRITO_PAGAR");
        botones.add(pagar);

        total = new JLabel("$ ");
        total.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(total);
        panel.add(botones);

        return panel;
    }
}
