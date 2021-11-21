package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelUsuario panelUsuario;

    public VentanaPrincipal() {
        setTitle("Proyecto");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        init();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void init() {
        panelUsuario = new PanelUsuario();
        panelUsuario.setBounds(0,0,750,350);
        getContentPane().add(panelUsuario);
    }

    public PanelUsuario getPanelUsuario() {
        return panelUsuario;
    }

    public void setPanelUsuario(PanelUsuario panelUsuario) {
        this.panelUsuario = panelUsuario;
    }
}
