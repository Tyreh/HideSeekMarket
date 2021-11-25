package co.edu.unbosque.view;


import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DialogRegistro extends JDialog {

    private JLabel enumLabel;

    private JTextField nombresField;

    private JTextField correoField;

    private JTextField apellidosField;

    private JComboBox<Integer> anioNacimientoComboBox;

    private JComboBox<String> mesNacimientoComboBox;

    private JComboBox<Integer> diaNacimientoComboBox;

    private JComboBox<String> generoComboBox;

    private JTextField usuarioField;

    private JTextField claveField;

    private Font font;

    private JButton aceptarButton;

    private ImageIcon fondo;

    private JLabel fondoLabel;

    public DialogRegistro() {
        setLayout(null);
        init();
        setVisible(false);
    }

    public void init() {
        font = new Font("Century Gothic", Font.BOLD, 13);

        enumLabel = new JLabel("Ingrese sus datos personales:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(220, 30, 300, 20);
        add(enumLabel);

        enumLabel = new JLabel("Nombres:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 60, 150, 20);
        add(enumLabel);

        nombresField = new JTextField();
        nombresField.setBounds(220, 60, 250, 20);
        add(nombresField);

        enumLabel = new JLabel("Apellidos:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 90, 150, 20);
        add(enumLabel);

        apellidosField = new JTextField();
        apellidosField.setBounds(220, 90, 250, 20);
        add(apellidosField);

        enumLabel = new JLabel("Correo:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 120, 150, 20);
        add(enumLabel);

        correoField = new JTextField();
        correoField.setBounds(220, 120, 250, 20);
        add(correoField);

        enumLabel = new JLabel("Fecha de nacimiento:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 150, 150, 20);
        add(enumLabel);

        diaNacimientoComboBox = new JComboBox<>();
        AutoCompleteDecorator.decorate(diaNacimientoComboBox);
        diaNacimientoComboBox.setBounds(420, 150, 50, 20);
        add(diaNacimientoComboBox);

        mesNacimientoComboBox = new JComboBox<>();
        AutoCompleteDecorator.decorate(mesNacimientoComboBox);
        mesNacimientoComboBox.setBounds(290, 150, 120, 20);
        mesNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
        add(mesNacimientoComboBox);

        anioNacimientoComboBox = new JComboBox<>();
        AutoCompleteDecorator.decorate(anioNacimientoComboBox);
        anioNacimientoComboBox.setBounds(220, 150, 60, 20);
        anioNacimientoComboBox.setActionCommand("FECHA_NACIMIENTO");
        add(anioNacimientoComboBox);

        enumLabel = new JLabel("Genero:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 180, 150, 20);
        add(enumLabel);

        generoComboBox = new JComboBox<>(new String[]{"Masculino", "Femenino"});
        generoComboBox.setBounds(220, 180, 250, 20);
        add(generoComboBox);

        enumLabel = new JLabel("Ingrese sus datos de ingreso:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(220, 230, 300, 20);
        add(enumLabel);

        enumLabel = new JLabel("Usuario:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 260, 150, 20);
        add(enumLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(220, 260, 250, 20);
        add(usuarioField);

        enumLabel = new JLabel("Contraseña:");
        enumLabel.setForeground(Color.WHITE);
        enumLabel.setFont(font);
        enumLabel.setBounds(60, 290, 150, 20);
        add(enumLabel);

        claveField = new JTextField();
        claveField.setBounds(220, 290, 250, 20);
        add(claveField);

        aceptarButton = new JButton("Registrarse");
        aceptarButton.setBounds(220, 350, 250, 30);
        aceptarButton.setForeground(Color.BLACK);
        aceptarButton.setBackground(new Color(86, 196, 0));
        aceptarButton.setActionCommand("INGRESAR_REGISTRO");
        add(aceptarButton);

        fondo = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondo.png/"))).getImage().getScaledInstance(800,450, Image.SCALE_SMOOTH));
        fondoLabel = new JLabel();
        fondoLabel.setIcon(fondo);
        fondoLabel.setBounds(0,0, 800,450);
        add(fondoLabel);
    }

    public JLabel getEnumLabel() {
        return enumLabel;
    }

    public void setEnumLabel(JLabel enumLabel) {
        this.enumLabel = enumLabel;
    }

    public JTextField getNombresField() {
        return nombresField;
    }

    public void setNombresField(JTextField nombresField) {
        this.nombresField = nombresField;
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public void setCorreoField(JTextField correoField) {
        this.correoField = correoField;
    }

    public JTextField getApellidosField() {
        return apellidosField;
    }

    public void setApellidosField(JTextField apellidosField) {
        this.apellidosField = apellidosField;
    }

    public JComboBox<Integer> getAnioNacimientoComboBox() {
        return anioNacimientoComboBox;
    }

    public void setAnioNacimientoComboBox(JComboBox<Integer> anioNacimientoComboBox) {
        this.anioNacimientoComboBox = anioNacimientoComboBox;
    }

    public JComboBox<String> getMesNacimientoComboBox() {
        return mesNacimientoComboBox;
    }

    public void setMesNacimientoComboBox(JComboBox<String> mesNacimientoComboBox) {
        this.mesNacimientoComboBox = mesNacimientoComboBox;
    }

    public JComboBox<Integer> getDiaNacimientoComboBox() {
        return diaNacimientoComboBox;
    }

    public void setDiaNacimientoComboBox(JComboBox<Integer> diaNacimientoComboBox) {
        this.diaNacimientoComboBox = diaNacimientoComboBox;
    }

    public JComboBox<String> getGeneroComboBox() {
        return generoComboBox;
    }

    public void setGeneroComboBox(JComboBox<String> generoComboBox) {
        this.generoComboBox = generoComboBox;
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public void setUsuarioField(JTextField usuarioField) {
        this.usuarioField = usuarioField;
    }

    public JTextField getClaveField() {
        return claveField;
    }

    public void setClaveField(JTextField claveField) {
        this.claveField = claveField;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void setAceptarButton(JButton aceptarButton) {
        this.aceptarButton = aceptarButton;
    }
}
