package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class PanelProducto extends JPanel {

    private JLabel label;

    private JLabel imagenLabel;

    private JTextField idField;

    private JComboBox<String> idComboBox;

    private JTextField nombre;

    private JTextField descripcion;

    private JTextField precio;

    private JButton agregarImagen;

    private JButton aceptar;

    private DefaultTableModel defaultTableModel;

    private JTable table;

    private JScrollPane scrollPane;

    private String textoBotonAceptar;

    private final String tipoPanel;

    public PanelProducto(String tipoPanel, String textoBotonAceptar) {
        this.tipoPanel = tipoPanel;
        this.textoBotonAceptar = textoBotonAceptar;
        setLayout(new FlowLayout());
        init();
        setVisible(false);
    }

    public PanelProducto(String tipoPanel) {
        this.tipoPanel = tipoPanel;
        setLayout(new GridLayout());
        init();
        setVisible(false);
    }

    public void init() {
        if (tipoPanel.equals("AGREGAR") || tipoPanel.equals("MODIFICAR") || tipoPanel.equals("ELIMINAR") || tipoPanel.equals("BUSCAR")) {
            JPanel panelFields = new JPanel(new SpringLayout());

            label = new JLabel("ID: ", JLabel.TRAILING);
            panelFields.add(label);

            if (tipoPanel.equals("MODIFICAR") || tipoPanel.equals("BUSCAR") || tipoPanel.equals("ELIMINAR")) {
                idComboBox = new JComboBox<>();
                idComboBox.setActionCommand("PRODUCTO_" + tipoPanel.toUpperCase() + "_COMBOBOX");
                label.setLabelFor(idComboBox);
                panelFields.add(idComboBox);
            } else {
                idField = new JTextField(20);
                label.setLabelFor(idField);
                panelFields.add(idField);
            }

            label = new JLabel("Nombre: ", JLabel.TRAILING);
            panelFields.add(label);

            nombre = new JTextField(20);
            label.setLabelFor(nombre);
            panelFields.add(nombre);

            label = new JLabel("Descripción: ", JLabel.TRAILING);
            panelFields.add(label);

            descripcion = new JTextField(20);
            label.setLabelFor(descripcion);
            panelFields.add(descripcion);

            label = new JLabel("Precio: ", JLabel.TRAILING);
            panelFields.add(label);

            precio = new JTextField(20);
            label.setLabelFor(precio);
            panelFields.add(precio);

            label = new JLabel("Imagen: ", JLabel.TRAILING);
            panelFields.add(label);

            if (tipoPanel.equals("BUSCAR") || tipoPanel.equals("ELIMINAR")) {
                imagenLabel = new JLabel(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                imagenLabel.setLabelFor(agregarImagen);
                panelFields.add(imagenLabel);

                nombre.setEditable(false);
                descripcion.setEditable(false);
                precio.setEditable(false);
            } else {
                agregarImagen = new JButton();
                agregarImagen.setActionCommand("PRODUCTO_IMAGEN_" + tipoPanel.toUpperCase());
                agregarImagen.setBackground(Color.WHITE);
                agregarImagen.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                label.setLabelFor(agregarImagen);
                panelFields.add(agregarImagen);
            }

            label = new JLabel("", JLabel.TRAILING);
            panelFields.add(label);

            if (!tipoPanel.equals("BUSCAR")) {
                aceptar = new JButton(textoBotonAceptar);
                aceptar.setActionCommand("PRODUCTO_" + tipoPanel.toUpperCase() + "_ACEPTAR");
                panelFields.add(aceptar);
                label.setLabelFor(aceptar);
                SpringUtilities.makeCompactGrid(panelFields, 6, 2, 0, 0, 5, 5);
            } else {
                SpringUtilities.makeCompactGrid(panelFields, 5, 2, 0, 0, 5, 5);

            }


            //panelFields.setBounds(0, 20, 250, 230);
            add(panelFields);
        } else if (tipoPanel.equals("LISTADO")) {
            defaultTableModel = new DefaultTableModel(new String[]{"ID", "NOMBRE", "DESCRIPCIÓN", "PRECIO"}, 0);
            table = new JTable(defaultTableModel);
            table.getTableHeader().setReorderingAllowed(false);
            table.setEnabled(false);
            scrollPane = new JScrollPane(table);
            add(scrollPane);
        }
    }

    public JTextField getIdField() {
        return idField;
    }

    public JComboBox<String> getIdComboBox() {
        return idComboBox;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getDescripcion() {
        return descripcion;
    }

    public JTextField getPrecio() {
        return precio;
    }

    public JButton getAgregarImagen() {
        return agregarImagen;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JLabel getImagenLabel() {
        return imagenLabel;
    }
}
