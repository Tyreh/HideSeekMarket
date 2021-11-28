package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelProducto extends JPanel {

    private JPanel panelFields;

    private JLabel label;

    private JTextField idField;

    private JComboBox<String> idComboBox;

    private JTextField nombreField;

    private JTextField descripcionField;

    private JTextField precioField;

    private JButton imagenButton;

    private JButton agregarProductoButton;

    private final boolean edicionProductos;

    private final String textoBotonAceptar;

    private final String comando;

    public PanelProducto(boolean edicionProductos, String textoBotonAceptar, String comando) {
        this.comando = comando;
        this.textoBotonAceptar = textoBotonAceptar;
        this.edicionProductos = edicionProductos;
        setLayout(null);
        init();
        setVisible(false);
    }

    public void init() {
        panelFields = new JPanel(new SpringLayout());

        label = new JLabel("ID: ", JLabel.TRAILING);
        panelFields.add(label);

        if (edicionProductos) {
            idComboBox = new JComboBox<>();
            label.setLabelFor(idComboBox);
            panelFields.add(idComboBox);
        } else {
            idField = new JTextField(10);
            label.setLabelFor(idField);
            panelFields.add(idField);
        }

        label = new JLabel("Nombre: ", JLabel.TRAILING);
        panelFields.add(label);

        nombreField = new JTextField(10);
        label.setLabelFor(nombreField);
        panelFields.add(nombreField);

        label = new JLabel("Descripción: ", JLabel.TRAILING);
        panelFields.add(label);

        descripcionField = new JTextField(10);
        label.setLabelFor(descripcionField);
        panelFields.add(descripcionField);

        label = new JLabel("Precio: ", JLabel.TRAILING);
        panelFields.add(label);

        precioField = new JTextField(10);
        label.setLabelFor(precioField);
        panelFields.add(precioField);

        label = new JLabel("Imagen: ", JLabel.TRAILING);
        panelFields.add(label);

        imagenButton = new JButton();
        imagenButton.setActionCommand("IMAGEN_PRODUCTO");
        imagenButton.setBackground(Color.WHITE);
        imagenButton.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
        label.setLabelFor(imagenButton);
        panelFields.add(imagenButton);

        label = new JLabel("", JLabel.TRAILING);
        panelFields.add(label);

        agregarProductoButton = new JButton(textoBotonAceptar);
        agregarProductoButton.setActionCommand(comando);
        label.setLabelFor(agregarProductoButton);
        panelFields.add(agregarProductoButton);

        SpringUtilities.makeCompactGrid(panelFields, 6, 2, 0, 0, 5, 5);

        panelFields.setBounds(0, 20, 250, 230);
        add(panelFields);
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public void setNombreField(JTextField nombreField) {
        this.nombreField = nombreField;
    }

    public JTextField getDescripcionField() {
        return descripcionField;
    }

    public void setDescripcionField(JTextField descripcionField) {
        this.descripcionField = descripcionField;
    }

    public JTextField getPrecioField() {
        return precioField;
    }

    public void setPrecioField(JTextField precioField) {
        this.precioField = precioField;
    }

    public JButton getImagenButton() {
        return imagenButton;
    }

    public void setImagenButton(JButton imagenButton) {
        this.imagenButton = imagenButton;
    }

    public JButton getAgregarProductoButton() {
        return agregarProductoButton;
    }

    public void setAgregarProductoButton(JButton agregarProductoButton) {
        this.agregarProductoButton = agregarProductoButton;
    }
}
