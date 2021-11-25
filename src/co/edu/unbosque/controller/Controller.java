package co.edu.unbosque.controller;

import co.edu.unbosque.model.Dto;
import co.edu.unbosque.model.GeneradorTarjetas;
import co.edu.unbosque.view.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Objects;

public class Controller implements ActionListener {

    private final VentanaPrincipal ventanaPrincipal;

    private final Dto dto;

    private final GeneradorTarjetas generadorTarjetas;

    public Controller() {
        dto = new Dto();
        generadorTarjetas = new GeneradorTarjetas(dto);
        ventanaPrincipal = new VentanaPrincipal();
        listeners();
    }

    public void listeners() {
        ventanaPrincipal.getPanelPrincipal().getIniciarSesionButton().addActionListener(this);
        ventanaPrincipal.getPanelPrincipal().getRegistrarseButton().addActionListener(this);
        ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getDialogRegistro().getAceptarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println(comando);

        switch (comando) {
            case "INICIAR_SESION":
                iniciarSesion();
                break;
            case "REGISTRARSE":
                formatoFecha();
                ventanaPrincipal.getDialogRegistro().setVisible(true);
                break;
            case "FECHA_NACIMIENTO":
                JComboBox<Integer> diaComboBox = ventanaPrincipal.getDialogRegistro().getDiaNacimientoComboBox();
                String mes = (String) ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().getSelectedItem();
                JComboBox<Integer> anioComboBox = ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox();

                try {
                    assert mes != null;
                    calcularDias(mes, diaComboBox, anioComboBox);
                } catch (NullPointerException ex) {
                    ventanaPrincipal.getDialogRegistro().setVisible(false);
                }
                break;
            case "INGRESAR_REGISTRO":
                registro();
                break;
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
        String nombres = ventanaPrincipal.getDialogRegistro().getNombresField().getText();
        String apellidos = ventanaPrincipal.getDialogRegistro().getApellidosField().getText();
        String correo = ventanaPrincipal.getDialogRegistro().getCorreoField().getText();
        Integer anioNacimiento = (Integer) ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox().getSelectedItem();
        String mesNacimiento = (String) ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().getSelectedItem();
        Integer diaNacimiento = (Integer) ventanaPrincipal.getDialogRegistro().getDiaNacimientoComboBox().getSelectedItem();
        String genero = (String) ventanaPrincipal.getDialogRegistro().getGeneroComboBox().getSelectedItem();
        String usuario = ventanaPrincipal.getDialogRegistro().getUsuarioField().getText();
        String clave = ventanaPrincipal.getDialogRegistro().getClaveField().getText();

        if (!nombres.equals("") && !apellidos.equals("") && !usuario.equals("") && !clave.equals("") && !correo.equals("")) {
            if (!correo.contains("@")) {
                ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nEl correo ingresado no es válido.");
            } else {
                String fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
                long saldo = 20000000;

                String binTarjeta = generadorTarjetas.generarBin();
                int mesCaducidad = generadorTarjetas.generarMesCaducidad();
                int anioCaducidad = generadorTarjetas.generarAnioCaducidad();
                int codigoTarjeta = generadorTarjetas.generarCodigo();

                dto.getDao().agregarCliente(dto.getArrayClientes(), dto.getFile(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, null, binTarjeta, mesCaducidad, anioCaducidad, codigoTarjeta);
                ventanaPrincipal.getMensajes().mostrarInfo("¡Bienvenido, su registro ha sido exitoso!\nEn unos minutos recibirá un correo de confirmación.");
                ventanaPrincipal.getDialogRegistro().setVisible(false);
            }
        }
    }

    public void formatoFecha() {
        ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox().removeAllItems();
        ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().removeAllItems();

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("El anio actual es: " + anioActual);

        String[] mesesArray = DateFormatSymbols.getInstance().getMonths();
        for (String mes : mesesArray) {
            if (!mes.equals("")) {
                ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().addItem(mes.toUpperCase());
            }
        }

        for (int i = anioActual; i >= (anioActual - 120); i--) {
            ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox().addItem(i);
        }
        System.out.println("Se agrego un rango desde " + (anioActual - 120) + " hasta " + anioActual + " para los anios.");
    }

    public void calcularDias(String campoMes, JComboBox<Integer> diaComboBox, JComboBox<Integer> anioComboBox) {
        diaComboBox.removeAllItems();
        switch (campoMes) {
            case "ENERO":
            case "MARZO":
            case "MAYO":
            case "JULIO":
            case "AGOSTO":
            case "OCTUBRE":
            case "DICIEMBRE":
                for (int i = 1; i <= 31; i++) {
                    diaComboBox.addItem(i);
                }
                break;
            case "ABRIL":
            case "JUNIO":
            case "SEPTIEMBRE":
            case "NOVIEMBRE":
                for (int i = 1; i <= 30; i++) {
                    diaComboBox.addItem(i);
                }
                break;
            case "FEBRERO":
                for (int i = 1; i <= 28; i++) {
                    diaComboBox.addItem(i);
                }

                int anioSeleccionado = (int) Objects.requireNonNull(anioComboBox.getSelectedItem());
                if (anioSeleccionado % 4 == 0) {
                    diaComboBox.addItem(29);
                }
                break;
        }
    }
}
