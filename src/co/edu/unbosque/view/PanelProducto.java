package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    private DefaultTableModel defaultTableModel;

    private JTable table;

    private JScrollPane scrollPane;

    private String textoBotonAceptar;

    private String comando;

    private final String tipoPanel;

    public PanelProducto(String tipoPanel, String textoBotonAceptar, String comando) {
        this.tipoPanel = tipoPanel;
        this.comando = comando;
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
        if (tipoPanel.equals("AGREGAR") || tipoPanel.equals("MODIFICAR")) {
            panelFields = new JPanel(new SpringLayout());

            label = new JLabel("ID: ", JLabel.TRAILING);
            panelFields.add(label);

            if (tipoPanel.equals("MODIFICAR")) {
                idComboBox = new JComboBox<>();
                idComboBox.setActionCommand("PRODUCTO_MODIFICAR_COMBOBOX");
                label.setLabelFor(idComboBox);
                panelFields.add(idComboBox);
            } else {
                idField = new JTextField(20);
                label.setLabelFor(idField);
                panelFields.add(idField);
            }

            label = new JLabel("Nombre: ", JLabel.TRAILING);
            panelFields.add(label);

            nombreField = new JTextField(20);
            label.setLabelFor(nombreField);
            panelFields.add(nombreField);

            label = new JLabel("Descripción: ", JLabel.TRAILING);
            panelFields.add(label);

            descripcionField = new JTextField(20);
            label.setLabelFor(descripcionField);
            panelFields.add(descripcionField);

            label = new JLabel("Precio: ", JLabel.TRAILING);
            panelFields.add(label);

            precioField = new JTextField(20);
            label.setLabelFor(precioField);
            panelFields.add(precioField);

            label = new JLabel("Imagen: ", JLabel.TRAILING);
            panelFields.add(label);

            imagenButton = new JButton();
            imagenButton.setActionCommand("IMAGEN_PRODUCTO_" + tipoPanel.toUpperCase());
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

    public JComboBox<String> getIdComboBox() {
        return idComboBox;
    }

    public void setIdComboBox(JComboBox<String> idComboBox) {
        this.idComboBox = idComboBox;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}
