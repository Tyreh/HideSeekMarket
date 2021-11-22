package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private JLabel auxLabel;

    private JTextField usuarioField;

    private JTextField claveField;

    private JButton iniciarSesionButton;

    private JButton registrarseButton;

    private Font font;

    public PanelPrincipal() {
        setLayout(null);
        init();
        setVisible(true);
    }

    public void init() {
        font = new Font("Tahoma", Font.BOLD, 14);

        auxLabel = new JLabel("Usuario:");
        auxLabel.setFont(font);
        auxLabel.setBounds(660, 20, 100, 20);
        add(auxLabel);

        usuarioField = new JTextField();
        usuarioField.setFont(font);
        usuarioField.setBounds(780, 20, 180, 20);
        add(usuarioField);

        auxLabel = new JLabel("Contraseña:");
        auxLabel.setFont(font);
        auxLabel.setBounds(660, 45, 100, 20);
        add(auxLabel);

        claveField = new JTextField();
        claveField.setFont(font);
        claveField.setBounds(780, 45, 180, 20);
        add(claveField);

        registrarseButton = new JButton("Registrarse");
        registrarseButton.setBounds(660, 70, 110, 20);
        registrarseButton.setActionCommand("REGISTRARSE");
        add(registrarseButton);

        iniciarSesionButton = new JButton("Iniciar sesión");
        iniciarSesionButton.setBounds(780, 70, 180, 20);
        iniciarSesionButton.setActionCommand("INICIAR_SESION");
        add(iniciarSesionButton);
    }

    public JLabel getAuxLabel() {
        return auxLabel;
    }

    public void setAuxLabel(JLabel auxLabel) {
        this.auxLabel = auxLabel;
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

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public void setIniciarSesionButton(JButton iniciarSesionButton) {
        this.iniciarSesionButton = iniciarSesionButton;
    }

    public JButton getRegistrarseButton() {
        return registrarseButton;
    }

    public void setRegistrarseButton(JButton registrarseButton) {
        this.registrarseButton = registrarseButton;
    }
}
