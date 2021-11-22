package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Dto;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;

    private Dto dto;

    public Controller() {
        dto = new Dto();
        ventanaPrincipal = new VentanaPrincipal();
        listeners();
    }

    public void listeners() {
        ventanaPrincipal.getPanelPrincipal().getIniciarSesionButton().addActionListener(this);
        ventanaPrincipal.getPanelPrincipal().getRegistrarseButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("INICIAR_SESION")) {
            iniciarSesion();
        } else if (comando.equals("REGISTRARSE")) {
            registro();
        }
    }

    public void iniciarSesion() {
        String usuario = ventanaPrincipal.getPanelPrincipal().getUsuarioField().getText();
        String clave = ventanaPrincipal.getPanelPrincipal().getClaveField().getText();

        if (usuario.equals("") || clave.equals("")) {
            ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nDebe ingresar su usuario y contraseña para poder iniciar sesión.");
        } else {
            if (dto.getDao().buscarCliente(dto.getArrayClientes(), usuario) != null) {
                if (dto.getDao().buscarCliente(dto.getArrayClientes(), usuario).getClave().equals(clave)) {
                    ventanaPrincipal.getDialogUsuario().setVisible(true);
                } else {
                    ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nLa contraseña ingresada es incorrecta, inténtelo de nuevo.");
                }
            } else {
                ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nEl usuario ingresado no está registrado.");
            }
        }
    }

    public void registro() {
        ventanaPrincipal.getDialogRegistro().setVisible(true);
    }
}
