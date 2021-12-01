package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCliente extends JPanel {

    private JPanel panelFields;

    private JPanel panelFecha;

    private JLabel label;

    private JTextField usuarioField;

    private JComboBox<String> usuarioComboBox;

    private JTextField claveField;

    private JTextField nombresField;

    private JTextField apellidosField;

    private JTextField correoField;

    private JComboBox<String> generoComboBox;

    private JComboBox<Integer> diaNacimientoComboBox;

    private JComboBox<String> mesNacimientoComboBox;

    private JComboBox<Integer> anioNacimientoComboBox;

    private JButton agregarClienteButton;

    private DefaultTableModel defaultTableModel;

    private JTable table;

    private JScrollPane scrollPane;

    private final String tipoPanel;

    private String textoBotonAceptar;

    private String comando;

    public PanelCliente(String tipoPanel, String textoBotonAceptar, String comando) {
        this.textoBotonAceptar = textoBotonAceptar;
        this.tipoPanel = tipoPanel;
        this.comando = comando;
        setLayout(new FlowLayout());
        init();
        setVisible(false);
    }

    public PanelCliente(String tipoPanel) {
        this.tipoPanel = tipoPanel;
        setLayout(new GridLayout());
        init();
        setVisible(false);
    }

    public void init() {
        if (tipoPanel.equals("AGREGAR") || tipoPanel.equals("MODIFICAR")) {
            panelFecha = new JPanel(new GridLayout(1, 3, 3, 0));

            anioNacimientoComboBox = new JComboBox<>();
            anioNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
            panelFecha.add(anioNacimientoComboBox);

            mesNacimientoComboBox = new JComboBox<>();
            mesNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
            panelFecha.add(mesNacimientoComboBox);

            diaNacimientoComboBox = new JComboBox<>();
            panelFecha.add(diaNacimientoComboBox);

            panelFields = new JPanel(new SpringLayout());

            label = new JLabel("Usuario: ", JLabel.TRAILING);
            panelFields.add(label);

            if (tipoPanel.equals("MODIFICAR")) {
                usuarioComboBox = new JComboBox<>();
                usuarioComboBox.setActionCommand("CLIENTE_MODIFICAR_COMBOBOX");
                label.setLabelFor(usuarioComboBox);
                panelFields.add(usuarioComboBox);
            } else {
                usuarioField = new JTextField(10);
                label.setLabelFor(usuarioField);
                panelFields.add(usuarioField);
            }

            label = new JLabel("Clave: ", JLabel.TRAILING);
            panelFields.add(label);

            claveField = new JTextField(10);
            label.setLabelFor(claveField);
            panelFields.add(claveField);

            label = new JLabel("Nombres: ", JLabel.TRAILING);
            panelFields.add(label);

            nombresField = new JTextField(10);
            label.setLabelFor(nombresField);
            panelFields.add(nombresField);

            label = new JLabel("Apellidos: ", JLabel.TRAILING);
            panelFields.add(label);

            apellidosField = new JTextField(10);
            label.setLabelFor(apellidosField);
            panelFields.add(apellidosField);

            label = new JLabel("Correo: ", JLabel.TRAILING);
            panelFields.add(label);

            correoField = new JTextField(10);
            label.setLabelFor(correoField);
            panelFields.add(correoField);

            label = new JLabel("Genero: ", JLabel.TRAILING);
            panelFields.add(label);

            generoComboBox = new JComboBox<>(new String[]{"Masculino", "Femenino"});
            label.setLabelFor(generoComboBox);
            panelFields.add(generoComboBox);

            label = new JLabel("Fecha de nacimiento: ", JLabel.TRAILING);
            panelFields.add(label);

            label.setLabelFor(panelFecha);
            panelFields.add(panelFecha);

            label = new JLabel("", JLabel.TRAILING);
            panelFields.add(label);

            agregarClienteButton = new JButton(textoBotonAceptar);
            agregarClienteButton.setActionCommand(comando);
            label.setLabelFor(agregarClienteButton);
            panelFields.add(agregarClienteButton);

            SpringUtilities.makeCompactGrid(panelFields, 8, 2, 0, 0, 5, 5);

            add(panelFields);
        } else if (tipoPanel.equals("LISTADO")) {
            defaultTableModel = new DefaultTableModel(new String[]{"USUARIO", "NOMBRES", "APELLIDOS", "CORREO", "GENERO", "FECHA DE NACIMIENTO"}, 0);
            table = new JTable(defaultTableModel);
            table.getTableHeader().setReorderingAllowed(false);
            table.setEnabled(false);
            scrollPane = new JScrollPane(table);
            add(scrollPane);
        }
    }

    public JPanel getPanelFields() {
        return panelFields;
    }

    public void setPanelFields(JPanel panelFields) {
        this.panelFields = panelFields;
    }

    public JPanel getPanelFecha() {
        return panelFecha;
    }

    public void setPanelFecha(JPanel panelFecha) {
        this.panelFecha = panelFecha;
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public void setUsuarioField(JTextField usuarioField) {
        this.usuarioField = usuarioField;
    }

    public JComboBox<String> getUsuarioComboBox() {
        return usuarioComboBox;
    }

    public void setUsuarioComboBox(JComboBox<String> usuarioComboBox) {
        this.usuarioComboBox = usuarioComboBox;
    }

    public JTextField getClaveField() {
        return claveField;
    }

    public void setClaveField(JTextField claveField) {
        this.claveField = claveField;
    }

    public JTextField getNombresField() {
        return nombresField;
    }

    public void setNombresField(JTextField nombresField) {
        this.nombresField = nombresField;
    }

    public JTextField getApellidosField() {
        return apellidosField;
    }

    public void setApellidosField(JTextField apellidosField) {
        this.apellidosField = apellidosField;
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public void setCorreoField(JTextField correoField) {
        this.correoField = correoField;
    }

    public JComboBox<String> getGeneroComboBox() {
        return generoComboBox;
    }

    public void setGeneroComboBox(JComboBox<String> generoComboBox) {
        this.generoComboBox = generoComboBox;
    }

    public JComboBox<Integer> getDiaNacimientoComboBox() {
        return diaNacimientoComboBox;
    }

    public void setDiaNacimientoComboBox(JComboBox<Integer> diaNacimientoComboBox) {
        this.diaNacimientoComboBox = diaNacimientoComboBox;
    }

    public JComboBox<String> getMesNacimientoComboBox() {
        return mesNacimientoComboBox;
    }

    public void setMesNacimientoComboBox(JComboBox<String> mesNacimientoComboBox) {
        this.mesNacimientoComboBox = mesNacimientoComboBox;
    }

    public JComboBox<Integer> getAnioNacimientoComboBox() {
        return anioNacimientoComboBox;
    }

    public void setAnioNacimientoComboBox(JComboBox<Integer> anioNacimientoComboBox) {
        this.anioNacimientoComboBox = anioNacimientoComboBox;
    }

    public JButton getAgregarClienteButton() {
        return agregarClienteButton;
    }

    public void setAgregarClienteButton(JButton agregarClienteButton) {
        this.agregarClienteButton = agregarClienteButton;
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
