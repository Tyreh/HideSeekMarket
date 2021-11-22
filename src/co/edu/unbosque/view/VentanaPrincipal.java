package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

//    private PanelUsuario panelUsuario;

    private DialogUsuario dialogUsuario;

    private PanelPrincipal panelPrincipal;

    private Mensajes mensajes;

    public VentanaPrincipal() {
        setTitle("Proyecto");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        init();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void init() {
        dialogUsuario = new DialogUsuario();
        dialogUsuario.setBounds(0,0,800,390);

        panelPrincipal = new PanelPrincipal();
        panelPrincipal.setBounds(0,0,1000,700);
        getContentPane().add(panelPrincipal);

        mensajes = new Mensajes();
    }

    public DialogUsuario getDialogUsuario() {
        return dialogUsuario;
    }

    public void setDialogUsuario(DialogUsuario dialogUsuario) {
        this.dialogUsuario = dialogUsuario;
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public Mensajes getMensajes() {
        return mensajes;
    }

    public void setMensajes(Mensajes mensajes) {
        this.mensajes = mensajes;
    }
}
