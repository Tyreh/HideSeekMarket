package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelPareja extends JPanel {

    private JPanel panelFields;

    private JPanel panelFecha;

    private JLabel label;

    private JTextField idPareja;

    private JComboBox<String> idParejaCombo;

    private JTextField nombres;

    private JTextField apellidos;

    private JTextField saldo;

    private JTextField generoField;

    private JTextField fechaNacimientoField;

    private JComboBox<String> generoCombo;

    private JComboBox<Integer> diaNacimientoComboBox;

    private JComboBox<String> mesNacimientoComboBox;

    private JComboBox<Integer> anioNacimientoComboBox;

    private JButton aceptar;

    private DefaultTableModel defaultTableModel;

    private JTable table;

    private JScrollPane scrollPane;

    private final String tipoPanel;

/*    public PanelPareja(String tipoPanel, String textoBotonAceptar) {
        this.textoBotonAceptar = textoBotonAceptar;
        this.tipoPanel = tipoPanel;
        setLayout(new FlowLayout());
        init();
        setVisible(false);
    }*/

    public PanelPareja(String tipoPanel) {
        this.tipoPanel = tipoPanel;
        if (tipoPanel.equalsIgnoreCase("LISTADO")) {
            setLayout(new GridLayout());
        } else {
            setLayout(new FlowLayout());
        }
        init();
        setVisible(false);
    }

    public void init() {
        if (tipoPanel.equalsIgnoreCase("AGREGAR") || tipoPanel.equalsIgnoreCase("MODIFICAR") || tipoPanel.equalsIgnoreCase("ELIMINAR") || tipoPanel.equalsIgnoreCase("BUSCAR")) {
            panelFields = new JPanel(new SpringLayout());

            label = new JLabel("ID: ", JLabel.TRAILING);
            panelFields.add(label);

            if (!tipoPanel.equalsIgnoreCase("AGREGAR")) {
                idParejaCombo = new JComboBox<>();
                idParejaCombo.setActionCommand("PAREJA_" + tipoPanel.toUpperCase() + "_COMBOBOX");
                label.setLabelFor(idParejaCombo);
                panelFields.add(idParejaCombo);
            } else {
                idPareja = new JTextField(20);
                label.setLabelFor(idPareja);
                panelFields.add(idPareja);
            }


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

            label = new JLabel("Saldo: ", JLabel.TRAILING);
            panelFields.add(label);

            saldo = new JTextField(20);
            label.setLabelFor(saldo);
            panelFields.add(saldo);


            if (tipoPanel.equalsIgnoreCase("BUSCAR") || tipoPanel.equalsIgnoreCase("ELIMINAR")) {
                label = new JLabel("Genero: ", JLabel.TRAILING);
                panelFields.add(label);

                generoField = new JTextField(20);
                label.setLabelFor(generoField);
                panelFields.add(generoField);

                label = new JLabel("Fecha de nacimiento: ", JLabel.TRAILING);
                panelFields.add(label);

                fechaNacimientoField = new JTextField(20);
                label.setLabelFor(fechaNacimientoField);
                panelFields.add(fechaNacimientoField);

                nombres.setEditable(false);
                apellidos.setEditable(false);
                generoField.setEditable(false);
                fechaNacimientoField.setEditable(false);
                saldo.setEditable(false);

                label = new JLabel("", JLabel.TRAILING);
                panelFields.add(label);
            } else {
                panelFecha = new JPanel(new GridLayout(1, 3, 3, 0));

                anioNacimientoComboBox = new JComboBox<>();
                anioNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
                panelFecha.add(anioNacimientoComboBox);

                mesNacimientoComboBox = new JComboBox<>();
                mesNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
                panelFecha.add(mesNacimientoComboBox);

                diaNacimientoComboBox = new JComboBox<>();
                panelFecha.add(diaNacimientoComboBox);

                label = new JLabel("Genero: ", JLabel.TRAILING);
                panelFields.add(label);

                generoCombo = new JComboBox<>(new String[]{"MASCULINO", "FEMENINO"});
                label.setLabelFor(generoCombo);
                panelFields.add(generoCombo);

                label = new JLabel("Fecha de nacimiento: ", JLabel.TRAILING);
                panelFields.add(label);

                label.setLabelFor(panelFecha);
                panelFields.add(panelFecha);

                label = new JLabel("", JLabel.TRAILING);
                panelFields.add(label);
            }

            if (!tipoPanel.equalsIgnoreCase("BUSCAR")) {
                aceptar = new JButton(tipoPanel + " pareja");
                aceptar.setActionCommand("PAREJA_" + tipoPanel.toUpperCase() + "_ACEPTAR");
                label.setLabelFor(aceptar);
                panelFields.add(aceptar);
                SpringUtilities.makeCompactGrid(panelFields, 7, 2, 0, 0, 5, 5);
            } else {
                SpringUtilities.makeCompactGrid(panelFields, 6, 2, 0, 0, 5, 5);
            }

            add(panelFields);
        } else if (tipoPanel.equalsIgnoreCase("LISTADO")) {
            defaultTableModel = new DefaultTableModel(new String[]{"ID", "NOMBRES", "APELLIDOS", "GENERO", "FECHA DE NACIMIENTO", "SALDO"}, 0);
            table = new JTable(defaultTableModel);
            table.getTableHeader().setReorderingAllowed(false);
            table.setEnabled(false);
            scrollPane = new JScrollPane(table);
            add(scrollPane);
        }
    }

    public JTextField getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(JTextField idPareja) {
        this.idPareja = idPareja;
    }

    public JComboBox<String> getIdParejaCombo() {
        return idParejaCombo;
    }

    public void setIdParejaCombo(JComboBox<String> idParejaCombo) {
        this.idParejaCombo = idParejaCombo;
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

    public JComboBox<String> getGeneroCombo() {
        return generoCombo;
    }

    public void setGeneroCombo(JComboBox<String> generoCombo) {
        this.generoCombo = generoCombo;
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

    public JTextField getSaldo() {
        return saldo;
    }

    public void setSaldo(JTextField saldo) {
        this.saldo = saldo;
    }

    public JTextField getGeneroField() {
        return generoField;
    }

    public JTextField getFechaNacimientoField() {
        return fechaNacimientoField;
    }
}
