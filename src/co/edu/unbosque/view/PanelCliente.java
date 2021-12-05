package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCliente extends JPanel {

    private JPanel panelFields;

    private JPanel panelFecha;

    private JLabel label;

    private JTextField usuario;

    private JComboBox<String> usuarioCombo;

    private JPasswordField clave;

    private JTextField nombres;

    private JTextField apellidos;

    private JTextField correo;

    private JComboBox<String> genero;

    private JComboBox<Integer> diaNacimientoComboBox;

    private JComboBox<String> mesNacimientoComboBox;

    private JComboBox<Integer> anioNacimientoComboBox;

    private JButton aceptar;

    private DefaultTableModel defaultTableModel;

    private JTable table;

    private JScrollPane scrollPane;

    private final String tipoPanel;

    private String textoBotonAceptar;

    public PanelCliente(String tipoPanel, String textoBotonAceptar) {
        this.textoBotonAceptar = textoBotonAceptar;
        this.tipoPanel = tipoPanel;
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
        if (tipoPanel.equals("AGREGAR") || tipoPanel.equals("MODIFICAR") || tipoPanel.equals("ELIMINAR") || tipoPanel.equals("BUSCAR")) {
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

            if (!tipoPanel.equals("AGREGAR")) {
                usuarioCombo = new JComboBox<>();
                usuarioCombo.setActionCommand("CLIENTE_" + tipoPanel.toUpperCase() + "_COMBOBOX");
                label.setLabelFor(usuarioCombo);
                panelFields.add(usuarioCombo);
            } else {
                usuario = new JTextField(20);
                label.setLabelFor(usuario);
                panelFields.add(usuario);
            }

            label = new JLabel("Clave: ", JLabel.TRAILING);
            panelFields.add(label);

            clave = new JPasswordField(20);
            label.setLabelFor(clave);
            panelFields.add(clave);

            label = new JLabel("Nombres: ", JLabel.TRAILING);
            panelFields.add(label);

            nombres = new JTextField(20);
            label.setLabelFor(nombres);
            panelFields.add(nombres);

            label = new JLabel("Apellidos: ", JLabel.TRAILING);
            panelFields.add(label);

            apellidos = new JTextField(20);
            label.setLabelFor(apellidos);
            panelFields.add(apellidos);

            label = new JLabel("Correo: ", JLabel.TRAILING);
            panelFields.add(label);

            correo = new JTextField(20);
            label.setLabelFor(correo);
            panelFields.add(correo);

            label = new JLabel("Genero: ", JLabel.TRAILING);
            panelFields.add(label);

            genero = new JComboBox<>(new String[]{"MASCULINO", "FEMENINO"});
            label.setLabelFor(genero);
            panelFields.add(genero);

            label = new JLabel("Fecha de nacimiento: ", JLabel.TRAILING);
            panelFields.add(label);

            label.setLabelFor(panelFecha);
            panelFields.add(panelFecha);

            label = new JLabel("", JLabel.TRAILING);
            panelFields.add(label);

            if (tipoPanel.equals("BUSCAR") || tipoPanel.equals("ELIMINAR")) {
                clave.setEditable(false);
                nombres.setEditable(false);
                apellidos.setEditable(false);
                correo.setEditable(false);
                genero.setEditable(false);
                diaNacimientoComboBox.setEditable(false);
                mesNacimientoComboBox.setEditable(false);
                anioNacimientoComboBox.setEditable(false);
            }

            if (!tipoPanel.equals("BUSCAR")) {
                aceptar = new JButton(textoBotonAceptar);
                aceptar.setActionCommand("CLIENTE_" + tipoPanel.toUpperCase() + "_ACEPTAR");
                label.setLabelFor(aceptar);
                panelFields.add(aceptar);
                SpringUtilities.makeCompactGrid(panelFields, 8, 2, 0, 0, 5, 5);
            } else {
                SpringUtilities.makeCompactGrid(panelFields, 7, 2, 0, 0, 5, 5);
            }

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

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JComboBox<String> getUsuarioCombo() {
        return usuarioCombo;
    }

    public void setUsuarioCombo(JComboBox<String> usuarioCombo) {
        this.usuarioCombo = usuarioCombo;
    }

    public JTextField getClave() {
        return clave;
    }

    public void setClave(JPasswordField clave) {
        this.clave = clave;
    }

    public JTextField getNombres() {
        return nombres;
    }

    public void setNombres(JTextField nombres) {
        this.nombres = nombres;
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public void setApellidos(JTextField apellidos) {
        this.apellidos = apellidos;
    }

    public JTextField getCorreo() {
        return correo;
    }

    public void setCorreo(JTextField correo) {
        this.correo = correo;
    }

    public JComboBox<String> getGenero() {
        return genero;
    }

    public void setGenero(JComboBox<String> genero) {
        this.genero = genero;
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

    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
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
