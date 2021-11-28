package co.edu.unbosque.view;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private DialogUsuario dialogUsuario;

    private DialogRegistro dialogRegistro;

    private PanelAdmin panelAdmin;

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

        dialogRegistro = new DialogRegistro();
        dialogRegistro.setBounds(140, 10, 560, 450);

        panelAdmin = new PanelAdmin();
        panelAdmin.setBounds(0,0,600,500);
        getContentPane().add(panelAdmin);

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

    public DialogRegistro getDialogRegistro() {
        return dialogRegistro;
    }

    public void setDialogRegistro(DialogRegistro dialogRegistro) {
        this.dialogRegistro = dialogRegistro;
    }

    public PanelAdmin getPanelAdmin() {
        return panelAdmin;
    }

    public void setPanelAdmin(PanelAdmin panelAdmin) {
        this.panelAdmin = panelAdmin;
    }
}
