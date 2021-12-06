package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.ProductoManager;
import co.edu.unbosque.view.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class Controller implements ActionListener {

    private final VentanaPrincipal ventana;

    private final Dto dto;

    private ImageIcon imageAux;

    private String usuarioSesion = "";


    int anioActual;

    public Controller() {
        dto = new Dto();
        ventana = new VentanaPrincipal(dto.getArrayProductos());
        listeners();
        formatoFecha();
    }

    public void listeners() {
        ventana.getPanelPrincipal().getIniciarSesion().addActionListener(this);
        ventana.getPanelPrincipal().getRegistrarse().addActionListener(this);

        /*ventana.getDialogRegistro().getMesNacimientoComboBox().addActionListener(this);
        ventana.getDialogRegistro().getAnioNacimientoComboBox().addActionListener(this);
        ventana.getDialogRegistro().getAceptarButton().addActionListener(this);*/

        ventana.getPanelPrincipal().getPanelAdminGestion().getClientes().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getProductos().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getTiendas().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getReportes().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getRegresar().addActionListener(this);

        ventana.getPanelPrincipal().getAccionesCliente().getAgregarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesCliente().getBuscarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesCliente().getModificarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesCliente().getEliminarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesCliente().getMostrarTodosButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesCliente().getRegresarButton().addActionListener(this);

        ventana.getPanelPrincipal().getAccionesProducto().getAgregarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesProducto().getBuscarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesProducto().getModificarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesProducto().getEliminarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesProducto().getMostrarTodosButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesProducto().getRegresarButton().addActionListener(this);

        ventana.getPanelPrincipal().getAccionesTienda().getAgregarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesTienda().getBuscarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesTienda().getModificarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesTienda().getEliminarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesTienda().getMostrarTodosButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesTienda().getRegresarButton().addActionListener(this);

        ventana.getPanelPrincipal().getAccionesUsuario().getAgregarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getBuscarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getModificarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getEliminarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getMostrarTodosButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getRegresarButton().addActionListener(this);
        ventana.getPanelPrincipal().getAccionesUsuario().getTarjetaButton().addActionListener(this);

        ventana.getPanelAdmin().getAgregarTienda().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getBuscarTienda().getIdComboBox().addActionListener(this);
        ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().addActionListener(this);

        ventana.getPanelAdmin().getEliminarTienda().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getModificarTienda().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getModificarTienda().getIdComboBox().addActionListener(this);

        ventana.getPanelAdmin().getAgregarPareja().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getBuscarPareja().getIdParejaCombo().addActionListener(this);
        ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().addActionListener(this);

        ventana.getPanelAdmin().getEliminarPareja().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getModificarPareja().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().addActionListener(this);

        ventana.getPanelAdmin().getAgregarProducto().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getAgregarProducto().getAgregarImagen().addActionListener(this);

        ventana.getPanelAdmin().getBuscarProducto().getIdComboBox().addActionListener(this);
        ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().addActionListener(this);

        ventana.getPanelAdmin().getEliminarProducto().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getModificarProducto().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getModificarProducto().getAgregarImagen().addActionListener(this);
        ventana.getPanelAdmin().getModificarProducto().getIdComboBox().addActionListener(this);

        ventana.getPanelAdmin().getAgregarCliente().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().addActionListener(this);
        ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().addActionListener(this);

        ventana.getPanelAdmin().getModificarCliente().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().addActionListener(this);
        ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().addActionListener(this);
        ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().addActionListener(this);

        ventana.getPanelAdmin().getBuscarCliente().getUsuarioCombo().addActionListener(this);
        ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().addActionListener(this);

        ventana.getPanelAdmin().getEliminarCliente().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getAgregarPareja().getAnioNacimientoComboBox().addActionListener(this);
        ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().addActionListener(this);

        ventana.getPanelAdmin().getModificarPareja().getAnioNacimientoComboBox().addActionListener(this);
        ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().addActionListener(this);

        for (ProductoManager panel : ventana.getListaProductos().getProductoManagers()) {
            panel.getAgregar().addActionListener(this);
            panel.getRemover().addActionListener(this);
        }

        ventana.getPanelPrincipal().getPagar().addActionListener(this);
        ventana.getPagarCarrito().getPagar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println(comando);

        visibilidadOpcionesAdmin(comando);

        if (comando.equals("REGRESAR_PANEL_ADMIN") || comando.equals("REGRESAR_PANEL_PAREJA")) {
            ventana.add(ventana.getScrollProductos(), BorderLayout.CENTER);
            ventana.getScrollProductos().setVisible(true);
            ventana.getPanelPrincipal().getAccionesUsuario().setVisible(false);
            ventana.getPanelPrincipal().getPanelCarrito().setVisible(true);
            ventana.getPanelPrincipal().getPanelSesion().setVisible(true);
            ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(false);
            ventana.getPanelAdmin().setVisible(false);
            ventana.remove(ventana.getPanelAdmin());
            ventana.setSize(1200, 800);
            ventana.setLocationRelativeTo(null);
        } else if (comando.contains("PRINCIPAL")) {
            String clave;

            switch (comando) {
                case "PRINCIPAL_REGISTRARSE":
                    break;
                case "PRINCIPAL_INICIAR_SESION":
                    usuarioSesion = ventana.getPanelPrincipal().getUsuario().getText();
                    clave = ventana.getPanelPrincipal().getClave().getText();

                    if (usuarioSesion.equals("") || clave.equals("")) {
                        ventana.getMensajes().mostrarError("Debe llenar ambos campos para poder iniciar sesión.");
                    } else {
                        Cliente cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuarioSesion);

                        if (usuarioSesion.equalsIgnoreCase("A") && clave.equalsIgnoreCase("A")) {
                            ventana.remove(ventana.getScrollProductos());
                            ventana.add(ventana.getPanelAdmin(), BorderLayout.CENTER);
                            ventana.getPanelAdmin().setVisible(true);
                            ventana.getPanelPrincipal().getPanelCarrito().setVisible(false);
                            ventana.getPanelPrincipal().getPanelSesion().setVisible(false);
                            ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(true);
                            ventana.setSize(900, 500);
                            ventana.setLocationRelativeTo(null);
                        } else if (cliente != null) {
                            if (cliente.getClave().equals(clave)) {
                                ventana.remove(ventana.getScrollProductos());
                                ventana.add(ventana.getPanelAdmin(), BorderLayout.CENTER);
                                ventana.getPanelAdmin().setVisible(true);
                                ventana.getPanelPrincipal().getPanelCarrito().setVisible(false);
                                ventana.getPanelPrincipal().getPanelSesion().setVisible(false);
                                ventana.getPanelPrincipal().add(ventana.getPanelPrincipal().getAccionesUsuario()).setVisible(true);
                                ventana.setSize(900, 500);
                            } else {
                                ventana.getMensajes().mostrarError("El usuario o la clave es incorrecta.");
                            }
                        } else {
                            ventana.getMensajes().mostrarError("El usuario o la clave es incorrecta.");
                        }
                    }
                    break;
                case "PRINCIPAL_PAGAR":
                    long total = 0;
                    for (Producto productos : dto.getArrayProductosCarrito()) {
                        total += productos.getPrecioProducto();
                    }

                    ventana.getPagarCarrito().getTotal().setText("TOTAL = $ " + total);
                    ventana.getPagarCarrito().getProductosEnCarrito().setText("Tienes " + dto.getArrayProductosCarrito().size() + " productos en el carrito");

                    if (dto.getArrayProductosCarrito().size() > 0) {
/*                        ventana.remove(ventana.getScrollProductos());
                        ventana.setSize(600,300);
                        ventana.add(ventana.getPagarCarrito(), BorderLayout.CENTER);*/
                        ventana.getPagarCarrito().setVisible(true);
                        ventana.getPagarCarrito().setLocationRelativeTo(null);
                    } else {
                        ventana.getMensajes().mostrarError("El carrito no puede estar vacío.");
                    }
                    break;
            }
        }

        if (comando.equals("FECHA_NACIMIENTO")) {
            try {
                calcularDias((String) Objects.requireNonNull(ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().getSelectedItem()), ventana.getPanelAdmin().getAgregarCliente().getDiaNacimientoComboBox(), ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox());
                calcularDias((String) Objects.requireNonNull(ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().getSelectedItem()), ventana.getPanelAdmin().getModificarCliente().getDiaNacimientoComboBox(), ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox());
                calcularDias((String) Objects.requireNonNull(ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().getSelectedItem()), ventana.getPanelAdmin().getAgregarPareja().getDiaNacimientoComboBox(), ventana.getPanelAdmin().getAgregarPareja().getAnioNacimientoComboBox());
                calcularDias((String) Objects.requireNonNull(ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().getSelectedItem()), ventana.getPanelAdmin().getModificarPareja().getDiaNacimientoComboBox(), ventana.getPanelAdmin().getModificarPareja().getAnioNacimientoComboBox());
            } catch (NullPointerException ex) {
                ventana.getPanelAdmin().getAgregarCliente().setVisible(false);
                ventana.getPanelAdmin().getModificarCliente().setVisible(false);
            }
        }


/*        switch (comando) {
            case "INICIAR_SESION":
                usuario = ventana.getPanelPrincipal().getUsuario().getText();
                clave = ventana.getPanelPrincipal().getClave().getText();

                if (usuario.equals("") || clave.equals("")) {
                    ventana.getMensajes().mostrarError("Estimado Cliente:\nDebe ingresar su usuario y contraseña para poder iniciar sesión.");
                } else if (usuario.equals("A") && clave.equals("A")) {
                    ventana.getPanelAdmin().setVisible(true);
                    ventana.getPanelPrincipal().setVisible(false);
                } else {
                    if (dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario) != null) {
                        if (dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario).getClave().equals(clave)) {
                            //ventana.getDialogUsuario().setVisible(true);
                        } else {
                            ventana.getMensajes().mostrarError("Estimado Cliente:\nLa contraseña ingresada es incorrecta, inténtelo de nuevo.");
                        }
                    } else {
                        ventana.getMensajes().mostrarError("Estimado Cliente:\nEl usuario ingresado no está registrado.");
                    }
                }
                break;
            case "REGISTRARSE":
*//*                ventana.getDialogRegistro().setVisible(true);
                ventana.getDialogRegistro().setLocationRelativeTo(null);*//*
                break;
            case "FECHA_NACIMIENTO":
                JComboBox<Integer> agregarDiaComboBox = ventana.getPanelAdmin().getAgregarCliente().getDiaNacimientoComboBox();
                String agregarMesComboBox = (String) ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().getSelectedItem();
                JComboBox<Integer> agregarAnioComboBox = ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox();

                JComboBox<Integer> modificarDiaComboBox = ventana.getPanelAdmin().getModificarCliente().getDiaNacimientoComboBox();
                String modificarMesComboBox = (String) ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().getSelectedItem();
                JComboBox<Integer> modificarAnioComboBox = ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox();

                try {
                    assert agregarMesComboBox != null;
                    assert modificarMesComboBox != null;
                    calcularDias(agregarMesComboBox, agregarDiaComboBox, agregarAnioComboBox);
                    calcularDias(modificarMesComboBox, modificarDiaComboBox, modificarAnioComboBox);
                } catch (NullPointerException ex) {
                    ventana.getPanelAdmin().getAgregarCliente().setVisible(false);
                    ventana.getPanelAdmin().getModificarCliente().setVisible(false);
                }
                break;
            case "INGRESAR_REGISTRO":
                nombres = ventana.getPanelAdmin().getAgregarCliente().getNombres().getText();
                apellidos = ventana.getPanelAdmin().getAgregarCliente().getApellidos().getText();
                correo = ventana.getPanelAdmin().getAgregarCliente().getCorreo().getText();
                anioNacimiento = (Integer) ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().getSelectedItem();
                mesNacimiento = (String) ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().getSelectedItem();
                diaNacimiento = (Integer) ventana.getPanelAdmin().getAgregarCliente().getDiaNacimientoComboBox().getSelectedItem();
                genero = (String) ventana.getPanelAdmin().getAgregarCliente().getGenero().getSelectedItem();
                usuario = ventana.getPanelAdmin().getAgregarCliente().getUsuario().getText();
                clave = ventana.getPanelAdmin().getAgregarCliente().getClave().getText();

                if (!nombres.equals("") && !apellidos.equals("") && !usuario.equals("") && !clave.equals("") && !correo.equals("")) {
                    if (!correo.contains("@")) {
                        ventana.getMensajes().mostrarError("Estimado Cliente:\nEl correo ingresado no es válido.");
                    } else {
                        String fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
                        long saldo = 20000000;

                        String binTarjeta = generadorTarjetas.generarBin();
                        int mesCaducidad = generadorTarjetas.generarMesCaducidad();
                        int anioCaducidad = generadorTarjetas.generarAnioCaducidad();
                        int codigoTarjeta = generadorTarjetas.generarCodigo();

                        if (dto.getDaoCliente().agregarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, null, binTarjeta, mesCaducidad, anioCaducidad, codigoTarjeta)) {
                            ventana.getMensajes().mostrarInfo("¡Bienvenido, su registro ha sido exitoso!\nEn unos minutos recibirá un correo de confirmación.");
                        } else {
                            ventana.getMensajes().mostrarError("Ya existe un cliente con este nombre de usuario.");
                        }
                    }
                }
                break;

            case "ELIMINAR_TIENDA":
                try {
                    busqueda = ventana.getMensajes().pedirDatoString("Ingrese la ID de la tienda que desea eliminar: ");
                    if (!(busqueda == null)) {
                        if (!busqueda.equals("")) {
                            if (dto.getDaoTienda().eliminarTienda(dto.getArrayTiendas(), dto.getFileClientes(), Integer.parseInt(busqueda))) {
                                ventana.getMensajes().mostrarInfo("La tienda con ID" + (char) 34 + busqueda + (char) 34 + " ha sido eliminada correctamente.");
                            } else {
                                ventana.getMensajes().mostrarError("No se encontró a ninguna tienda con la id " + (char) 34 + busqueda + (char) 34 + ".");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    ventana.getMensajes().mostrarError("Recuerde que la ID solo debe contener números.");
                }
                break;
        }*/
        if (comando.contains("CLIENTE")) {
            String usuario;
            String clave;
            String nombres;
            String apellidos;
            String correo;
            String genero;
            String anioNacimiento;
            String mesNacimiento;
            String diaNacimiento;
            String fechaNacimiento;
            int saldo = 20000000;
            ArrayList<Pareja> parejas = new ArrayList<>();
            String binTarjeta;
            int codigoTarjeta;
            Cliente cliente;

            switch (comando) {
                case "LISTADO_CLIENTE":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoCliente());

                    ventana.getPanelAdmin().getListadoCliente().getDefaultTableModel().setRowCount(0);
                    for (Cliente clientes : dto.getArrayClientes()) {
                        usuario = clientes.getUsuario();
                        nombres = clientes.getNombres();
                        apellidos = clientes.getApellidos();
                        correo = clientes.getCorreo();
                        genero = clientes.getGenero();
                        fechaNacimiento = clientes.getFechaNacimiento();
                        ventana.getPanelAdmin().getListadoCliente().getDefaultTableModel().addRow(new String[]{usuario, nombres, apellidos, correo, genero, fechaNacimiento});
                    }
                    break;
                case "CLIENTE_AGREGAR_ACEPTAR":
                    usuario = ventana.getPanelAdmin().getAgregarCliente().getUsuario().getText();
                    clave = ventana.getPanelAdmin().getAgregarCliente().getClave().getText();
                    nombres = ventana.getPanelAdmin().getAgregarCliente().getNombres().getText();
                    apellidos = ventana.getPanelAdmin().getAgregarCliente().getApellidos().getText();
                    correo = ventana.getPanelAdmin().getAgregarCliente().getCorreo().getText();
                    genero = (String) ventana.getPanelAdmin().getAgregarCliente().getGenero().getSelectedItem();
                    anioNacimiento = String.valueOf(ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().getSelectedItem());
                    mesNacimiento = (String) ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().getSelectedItem();
                    diaNacimiento = String.valueOf(ventana.getPanelAdmin().getAgregarCliente().getDiaNacimientoComboBox().getSelectedItem());
                    fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
                    binTarjeta = dto.generarBin();
                    codigoTarjeta = dto.generarCodigo();

                    if (clave.length() > 5) {
                        if (correo.contains("@")) {
                            assert anioNacimiento != null;
                            if (anioActual - Integer.parseInt(anioNacimiento) >= 18) {
                                if (dto.getDaoCliente().agregarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, parejas, binTarjeta, codigoTarjeta)) {
                                    ventana.getMensajes().mostrarInfo("¡Su registro ha sido exitoso!\nEn unos minutos recibirá un correo de confirmación.");
                                } else {
                                    ventana.getMensajes().mostrarInfo("Ya existe un cliente con este usuario.");
                                }
                            } else {
                                ventana.getMensajes().mostrarError("Debe ser mayor de edad para poder registrarse en el sistema.");
                            }
                        } else {
                            ventana.getMensajes().mostrarError("El correo ingresado no es válido.");
                        }
                    } else {
                        ventana.getMensajes().mostrarError("La clave ingresada es demasiado corta.");
                    }
                    break;
                case "MODIFICAR_CLIENTE":
                    ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().removeAllItems();
                    for (Cliente clientes : dto.getArrayClientes()) {
                        usuario = clientes.getUsuario();
                        ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().addItem(usuario);
                    }
                case "CLIENTE_MODIFICAR_COMBOBOX":
                    usuario = (String) ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().getSelectedItem();

                    if (usuario != null) {
                        if (!usuario.equals("")) {
                            try {
                                cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);
                                ventana.getPanelAdmin().getModificarCliente().getClave().setText(cliente.getClave());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Este cliente ya no existe.");
                                ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().removeItem(usuario);
                                usuario = (String) ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().getSelectedItem();
                            } finally {
                                cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);
                                ventana.getPanelAdmin().getModificarCliente().getClave().setText(cliente.getClave());
                                ventana.getPanelAdmin().getModificarCliente().getNombres().setText(cliente.getNombres());
                                ventana.getPanelAdmin().getModificarCliente().getApellidos().setText(cliente.getApellidos());
                                ventana.getPanelAdmin().getModificarCliente().getCorreo().setText(cliente.getCorreo());
                            }
                        }
                    } else {
                        ventana.getPanelAdmin().getModificarCliente().getClave().setText("");
                        ventana.getPanelAdmin().getModificarCliente().getNombres().setText("");
                        ventana.getPanelAdmin().getModificarCliente().getApellidos().setText("");
                        ventana.getPanelAdmin().getModificarCliente().getCorreo().setText("");
                    }
                    break;
                case "CLIENTE_MODIFICAR_ACEPTAR":
                    usuario = (String) ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().getSelectedItem();
                    clave = ventana.getPanelAdmin().getModificarCliente().getClave().getText();
                    nombres = ventana.getPanelAdmin().getModificarCliente().getNombres().getText();
                    apellidos = ventana.getPanelAdmin().getModificarCliente().getApellidos().getText();
                    correo = ventana.getPanelAdmin().getModificarCliente().getCorreo().getText();
                    genero = (String) ventana.getPanelAdmin().getModificarCliente().getGenero().getSelectedItem();
                    anioNacimiento = String.valueOf(ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().getSelectedItem());
                    mesNacimiento = (String) ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().getSelectedItem();
                    diaNacimiento = String.valueOf(ventana.getPanelAdmin().getModificarCliente().getDiaNacimientoComboBox().getSelectedItem());
                    fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;

                    cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);

                    if (clave.length() > 5) {
                        if (correo.contains("@")) {
                            assert anioNacimiento != null;
                            if ((anioActual - Integer.parseInt(anioNacimiento)) >= 18) {
                                if (dto.getDaoCliente().modificarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, cliente.getSaldo(), cliente.getCodigoTarjeta())) {
                                    ventana.getMensajes().mostrarInfo("El usuario ha sido modificado correctamente.");
                                } else {
                                    ventana.getMensajes().mostrarInfo("El usuario especificado no existe.");
                                }
                            } else {
                                ventana.getMensajes().mostrarError("Debe ser mayor de edad para poder registrarse en el sistema.");
                            }
                        } else {
                            ventana.getMensajes().mostrarError("El correo ingresado no es válido.");
                        }
                    } else {
                        ventana.getMensajes().mostrarError("La clave ingresada es demasiado corta.");
                    }
                    break;
                case "ELIMINAR_CLIENTE":
                    ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().removeAllItems();
                    for (Cliente clientes : dto.getArrayClientes()) {
                        usuario = clientes.getUsuario();
                        ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().addItem(usuario);
                    }
                    break;
                case "CLIENTE_ELIMINAR_COMBOBOX":
                    usuario = (String) ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().getSelectedItem();

                    if (usuario != null) {
                        if (!usuario.equals("")) {
                            cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);
                            ventana.getPanelAdmin().getEliminarCliente().getClave().setText(cliente.getClave());
                            ventana.getPanelAdmin().getEliminarCliente().getNombres().setText(cliente.getNombres());
                            ventana.getPanelAdmin().getEliminarCliente().getApellidos().setText(cliente.getApellidos());
                            ventana.getPanelAdmin().getEliminarCliente().getCorreo().setText(cliente.getCorreo());
                            ventana.getPanelAdmin().getEliminarCliente().getGeneroField().setText(cliente.getGenero());
                            ventana.getPanelAdmin().getEliminarCliente().getFechaNacimientoField().setText(cliente.getFechaNacimiento());
                        }
                    } else {
                        ventana.getPanelAdmin().getEliminarCliente().getClave().setText("");
                        ventana.getPanelAdmin().getEliminarCliente().getNombres().setText("");
                        ventana.getPanelAdmin().getEliminarCliente().getApellidos().setText("");
                        ventana.getPanelAdmin().getEliminarCliente().getCorreo().setText("");
                        ventana.getPanelAdmin().getEliminarCliente().getGeneroField().setText("");
                        ventana.getPanelAdmin().getEliminarCliente().getFechaNacimientoField().setText("");
                    }
                    break;
                case "BUSCAR_CLIENTE":
                    ventana.getPanelAdmin().getBuscarCliente().getUsuarioCombo().removeAllItems();
                    for (Cliente clientes : dto.getArrayClientes()) {
                        usuario = clientes.getUsuario();
                        ventana.getPanelAdmin().getBuscarCliente().getUsuarioCombo().addItem(usuario);
                    }
                    break;
                case "CLIENTE_BUSCAR_COMBOBOX":
                    usuario = (String) ventana.getPanelAdmin().getBuscarCliente().getUsuarioCombo().getSelectedItem();

                    if (usuario != null) {
                        if (!usuario.equals("")) {
                            cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);
                            ventana.getPanelAdmin().getBuscarCliente().getClave().setText(cliente.getClave());
                            ventana.getPanelAdmin().getBuscarCliente().getNombres().setText(cliente.getNombres());
                            ventana.getPanelAdmin().getBuscarCliente().getApellidos().setText(cliente.getApellidos());
                            ventana.getPanelAdmin().getBuscarCliente().getCorreo().setText(cliente.getCorreo());
                            ventana.getPanelAdmin().getBuscarCliente().getGeneroField().setText(cliente.getGenero());
                            ventana.getPanelAdmin().getBuscarCliente().getFechaNacimientoField().setText(cliente.getFechaNacimiento());
                        }
                    } else {
                        ventana.getPanelAdmin().getBuscarCliente().getClave().setText("");
                        ventana.getPanelAdmin().getBuscarCliente().getNombres().setText("");
                        ventana.getPanelAdmin().getBuscarCliente().getApellidos().setText("");
                        ventana.getPanelAdmin().getBuscarCliente().getCorreo().setText("");
                        ventana.getPanelAdmin().getBuscarCliente().getGeneroField().setText("");
                        ventana.getPanelAdmin().getBuscarCliente().getFechaNacimientoField().setText("");
                    }
                    break;
                case "CLIENTE_ELIMINAR_ACEPTAR":
                    usuario = (String) ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().getSelectedItem();

                    if (usuario != null) {
                        if (!usuario.equals("")) {
                            if (dto.getDaoCliente().eliminarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario)) {
                                ventana.getMensajes().mostrarInfo("El usuario ha sido eliminado correctamente.");
                                ventana.getPanelAdmin().getEliminarCliente().getUsuarioCombo().removeItem(usuario);
                            } else {
                                ventana.getMensajes().mostrarError("Este usuario ya no existe.");
                            }
                        }
                    }
                    break;
            }
        } else if (comando.contains("TIENDA")) {
            String idTienda;
            String ciudad;
            String direccion;
            Tienda tienda;

            switch (comando) {
                case "LISTADO_TIENDA":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoTienda());

                    ventana.getPanelAdmin().getListadoTienda().getDefaultTableModel().setRowCount(0);
                    for (Tienda tiendas : dto.getArrayTiendas()) {
                        idTienda = String.valueOf(tiendas.getIdTienda());
                        ciudad = tiendas.getCiudadTienda();
                        direccion = tiendas.getDireccionTienda();
                        ventana.getPanelAdmin().getListadoTienda().getDefaultTableModel().addRow(new String[]{idTienda, ciudad, direccion});
                    }
                    break;
                case "TIENDA_AGREGAR_ACEPTAR":
                    try {
                        idTienda = ventana.getPanelAdmin().getAgregarTienda().getIdField().getText();
                        ciudad = ventana.getPanelAdmin().getAgregarTienda().getCiudad().getText();
                        direccion = ventana.getPanelAdmin().getAgregarTienda().getDireccion().getText();

                        if (!ciudad.equals("") || !direccion.equals("")) {
                            if (dto.getDaoTienda().agregarTienda(dto.getArrayTiendas(), dto.getFileTiendas(), Integer.parseInt(idTienda), ciudad, direccion)) {
                                ventana.getMensajes().mostrarInfo("La tienda ha sido agregada correctamente.");
                            } else {
                                ventana.getMensajes().mostrarError("Ya existe una tienda con esta ID.");
                            }
                        } else {
                            ventana.getMensajes().mostrarError("Por favor complete todos los campos.");
                        }
                    } catch (NumberFormatException ex) {
                        ventana.getMensajes().mostrarError("Recuerde que el campo de ID debe contener únicamente valores numéricos.");
                    }
                    break;
                case "MODIFICAR_TIENDA":
                    ventana.getPanelAdmin().getModificarTienda().getIdComboBox().removeAllItems();
                    for (Tienda tiendas : dto.getArrayTiendas()) {
                        idTienda = String.valueOf(tiendas.getIdTienda());
                        ventana.getPanelAdmin().getModificarTienda().getIdComboBox().addItem(idTienda);
                    }
                case "TIENDA_MODIFICAR_COMBOBOX":
                    idTienda = (String) ventana.getPanelAdmin().getModificarTienda().getIdComboBox().getSelectedItem();

                    if (idTienda != null) {
                        if (!idTienda.equals("")) {
                            try {
                                tienda = dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(idTienda));
                                ventana.getPanelAdmin().getModificarTienda().getCiudad().setText(tienda.getCiudadTienda());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Este producto ya no existe.");
                                ventana.getPanelAdmin().getModificarTienda().getIdComboBox().removeItem(idTienda);
                                idTienda = (String) ventana.getPanelAdmin().getModificarTienda().getIdComboBox().getSelectedItem();
                            } finally {
                                tienda = dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(idTienda));
                                ventana.getPanelAdmin().getModificarTienda().getCiudad().setText(tienda.getCiudadTienda());
                                ventana.getPanelAdmin().getModificarTienda().getDireccion().setText(tienda.getDireccionTienda());
                            }
                        }
                    } else {
                        ventana.getPanelAdmin().getModificarTienda().getCiudad().setText("");
                        ventana.getPanelAdmin().getModificarTienda().getDireccion().setText("");
                    }
                    break;
                case "TIENDA_MODIFICAR_ACEPTAR":
                    idTienda = (String) ventana.getPanelAdmin().getModificarTienda().getIdComboBox().getSelectedItem();
                    ciudad = ventana.getPanelAdmin().getModificarTienda().getCiudad().getText();
                    direccion = ventana.getPanelAdmin().getModificarTienda().getDireccion().getText();

                    if (!ciudad.equals("") || !direccion.equals("")) {
                        assert idTienda != null;
                        if (dto.getDaoTienda().modificarTienda(dto.getArrayTiendas(), dto.getFileTiendas(), Integer.parseInt(idTienda), ciudad, direccion)) {
                            ventana.getMensajes().mostrarInfo("La tienda ha sido modificada correctamente.");
                        } else {
                            ventana.getMensajes().mostrarInfo("La tienda especificada no existe.");
                        }
                    } else {
                        ventana.getMensajes().mostrarError("Por favor complete todos los campos.");
                    }
                    break;
                case "ELIMINAR_TIENDA":
                    ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().removeAllItems();
                    for (Tienda tiendas : dto.getArrayTiendas()) {
                        idTienda = String.valueOf(tiendas.getIdTienda());
                        ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().addItem(idTienda);
                    }
                    break;
                case "TIENDA_ELIMINAR_COMBOBOX":
                    idTienda = (String) ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().getSelectedItem();

                    if (idTienda != null) {
                        if (!idTienda.equals("")) {
                            tienda = dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(idTienda));
                            ventana.getPanelAdmin().getEliminarTienda().getCiudad().setText(tienda.getCiudadTienda());
                            ventana.getPanelAdmin().getEliminarTienda().getDireccion().setText(tienda.getDireccionTienda());
                        }
                    } else {
                        ventana.getPanelAdmin().getEliminarTienda().getCiudad().setText("");
                        ventana.getPanelAdmin().getEliminarTienda().getDireccion().setText("");
                    }
                    break;
                case "BUSCAR_TIENDA":
                    ventana.getPanelAdmin().getBuscarTienda().getIdComboBox().removeAllItems();
                    for (Tienda tiendas : dto.getArrayTiendas()) {
                        idTienda = String.valueOf(tiendas.getIdTienda());
                        ventana.getPanelAdmin().getBuscarTienda().getIdComboBox().addItem(idTienda);
                    }
                    break;
                case "TIENDA_BUSCAR_COMBOBOX":
                    idTienda = (String) ventana.getPanelAdmin().getBuscarTienda().getIdComboBox().getSelectedItem();

                    if (idTienda != null) {
                        if (!idTienda.equals("")) {
                            tienda = dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(idTienda));
                            ventana.getPanelAdmin().getBuscarTienda().getCiudad().setText(tienda.getCiudadTienda());
                            ventana.getPanelAdmin().getBuscarTienda().getDireccion().setText(tienda.getDireccionTienda());
                        }
                    } else {
                        ventana.getPanelAdmin().getBuscarTienda().getCiudad().setText("");
                        ventana.getPanelAdmin().getBuscarTienda().getDireccion().setText("");
                    }
                    break;
                case "TIENDA_ELIMINAR_ACEPTAR":
                    idTienda = (String) ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().getSelectedItem();

                    if (idTienda != null) {
                        if (!idTienda.equals("")) {
                            if (dto.getDaoTienda().eliminarTienda(dto.getArrayTiendas(), dto.getFileTiendas(), Integer.parseInt(idTienda))) {
                                ventana.getMensajes().mostrarInfo("La tienda ha sido eliminada correctamente.");
                                ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().removeItem(idTienda);
                            } else {
                                ventana.getMensajes().mostrarError("Esta tienda ya no existe.");
                            }
                        }
                    }
                    break;
            }
        } else if (comando.contains("PRODUCTO")) {
            String idProducto;
            String nombreProducto;
            String descripcionProducto;
            String precioProducto;
            ImageIcon imagenProducto;
            Producto producto;

            if (comando.contains("AGREGAR") || comando.contains("REMOVER")) {
                for (Producto productos : dto.getArrayProductos()) {
                    if (comando.equals("AGREGAR_PRODUCTO_" + productos.getIdProducto())) {
                        dto.getArrayProductosCarrito().add(productos);
                        ventana.getPanelPrincipal().getCarrito().setText("Tienes " + dto.getArrayProductosCarrito().size() + " productos en el carrito");
                        System.out.println(dto.getArrayProductosCarrito());
                        break;
                    } else if (comando.equals("REMOVER_PRODUCTO_" + productos.getIdProducto())) {
                        dto.getArrayProductosCarrito().remove(productos);
                        ventana.getPanelPrincipal().getCarrito().setText("Tienes " + dto.getArrayProductosCarrito().size() + " productos en el carrito");
                        break;
                    }
                }
            }

            switch (comando) {
                case "PRODUCTO_IMAGEN_AGREGAR":
                    ventana.getPanelAdmin().getAgregarProducto().getAgregarImagen().setIcon(cargarImagen());
                    break;
                case "PRODUCTO_IMAGEN_MODIFICAR":
                    ventana.getPanelAdmin().getModificarProducto().getAgregarImagen().setIcon(cargarImagen());
                    break;
                case "LISTADO_PRODUCTO":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoProducto());

                    ventana.getPanelAdmin().getListadoProducto().getDefaultTableModel().setRowCount(0);
                    for (Producto productos : dto.getArrayProductos()) {
                        idProducto = String.valueOf(productos.getIdProducto());
                        nombreProducto = productos.getNombreProducto();
                        descripcionProducto = productos.getLoreProducto();
                        precioProducto = "$" + productos.getPrecioProducto();
                        ventana.getPanelAdmin().getListadoProducto().getDefaultTableModel().addRow(new String[]{idProducto, nombreProducto, descripcionProducto, precioProducto});
                    }
                    break;
                case "PRODUCTO_AGREGAR_ACEPTAR":
                    try {
                        idProducto = ventana.getPanelAdmin().getAgregarProducto().getIdField().getText();
                        nombreProducto = ventana.getPanelAdmin().getAgregarProducto().getNombre().getText();
                        descripcionProducto = ventana.getPanelAdmin().getAgregarProducto().getDescripcion().getText();
                        precioProducto = ventana.getPanelAdmin().getAgregarProducto().getPrecio().getText();

                        if (imageAux == null) {
                            imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                        }

                        if (dto.getDaoProducto().agregarProducto(dto.getArrayProductos(), dto.getFileProductos(), Integer.parseInt(idProducto), nombreProducto, descripcionProducto, Long.parseLong(precioProducto), imageAux)) {
                            ventana.getMensajes().mostrarInfo("El producto ha sido agregado correctamente.");
                        } else {
                            ventana.getMensajes().mostrarError("Ya existe un producto con esta ID.");
                        }
                    } catch (NumberFormatException ex) {
                        ventana.getMensajes().mostrarError("Recuerde que los campos de ID y precio deben contener únicamente valores numéricos.");
                    }
                    break;
                case "MODIFICAR_PRODUCTO":
                    ventana.getPanelAdmin().getModificarProducto().getIdComboBox().removeAllItems();
                    for (Producto productos : dto.getArrayProductos()) {
                        idProducto = String.valueOf(productos.getIdProducto());
                        ventana.getPanelAdmin().getModificarProducto().getIdComboBox().addItem(idProducto);
                    }
                case "PRODUCTO_MODIFICAR_COMBOBOX":
                    idProducto = (String) ventana.getPanelAdmin().getModificarProducto().getIdComboBox().getSelectedItem();

                    if (idProducto != null) {
                        if (!idProducto.equals("")) {
                            try {
                                producto = dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(idProducto));
                                ventana.getPanelAdmin().getModificarProducto().getNombre().setText(producto.getNombreProducto());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Este producto ya no existe.");
                                ventana.getPanelAdmin().getModificarProducto().getIdComboBox().removeItem(idProducto);
                                idProducto = (String) ventana.getPanelAdmin().getModificarProducto().getIdComboBox().getSelectedItem();
                            } finally {
                                producto = dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(idProducto));
                                ventana.getPanelAdmin().getModificarProducto().getNombre().setText(producto.getNombreProducto());
                                ventana.getPanelAdmin().getModificarProducto().getDescripcion().setText(producto.getLoreProducto());
                                ventana.getPanelAdmin().getModificarProducto().getPrecio().setText(String.valueOf(producto.getPrecioProducto()));
                                ventana.getPanelAdmin().getModificarProducto().getAgregarImagen().setIcon(producto.getImagenProducto());
                            }
                        }
                    } else {
                        ventana.getPanelAdmin().getModificarProducto().getNombre().setText("");
                        ventana.getPanelAdmin().getModificarProducto().getDescripcion().setText("");
                        ventana.getPanelAdmin().getModificarProducto().getPrecio().setText("");
                        ventana.getPanelAdmin().getModificarProducto().getImagenLabel().setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    }
                    break;
                case "PRODUCTO_MODIFICAR_ACEPTAR":
                    idProducto = (String) ventana.getPanelAdmin().getModificarProducto().getIdComboBox().getSelectedItem();
                    nombreProducto = ventana.getPanelAdmin().getModificarProducto().getNombre().getText();
                    descripcionProducto = ventana.getPanelAdmin().getModificarProducto().getDescripcion().getText();
                    precioProducto = ventana.getPanelAdmin().getModificarProducto().getPrecio().getText();
                    imagenProducto = (ImageIcon) ventana.getPanelAdmin().getModificarProducto().getAgregarImagen().getIcon();

                    assert idProducto != null;
                    if (dto.getDaoProducto().modificarProducto(dto.getArrayProductos(), dto.getFileProductos(), Integer.parseInt(idProducto), nombreProducto, descripcionProducto, Long.parseLong(precioProducto), imagenProducto)) {
                        ventana.getMensajes().mostrarInfo("El producto ha sido modificado correctamente.");
                    } else {
                        ventana.getMensajes().mostrarInfo("El producto especificado no existe.");
                    }
                    break;
                case "ELIMINAR_PRODUCTO":
                    ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().removeAllItems();
                    for (Producto productos : dto.getArrayProductos()) {
                        idProducto = String.valueOf(productos.getIdProducto());
                        ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().addItem(idProducto);
                    }
                    break;
                case "PRODUCTO_ELIMINAR_COMBOBOX":
                    idProducto = (String) ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().getSelectedItem();

                    if (idProducto != null) {
                        if (!idProducto.equals("")) {
                            producto = dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(idProducto));
                            ventana.getPanelAdmin().getEliminarProducto().getNombre().setText(producto.getNombreProducto());
                            ventana.getPanelAdmin().getEliminarProducto().getDescripcion().setText(producto.getLoreProducto());
                            ventana.getPanelAdmin().getEliminarProducto().getPrecio().setText("$" + producto.getPrecioProducto());
                            ventana.getPanelAdmin().getEliminarProducto().getImagenLabel().setIcon(producto.getImagenProducto());
                        }
                    } else {
                        ventana.getPanelAdmin().getEliminarProducto().getNombre().setText("");
                        ventana.getPanelAdmin().getEliminarProducto().getDescripcion().setText("");
                        ventana.getPanelAdmin().getEliminarProducto().getPrecio().setText("");
                        ventana.getPanelAdmin().getEliminarProducto().getImagenLabel().setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    }
                    break;
                case "BUSCAR_PRODUCTO":
                    ventana.getPanelAdmin().getBuscarProducto().getIdComboBox().removeAllItems();
                    for (Producto productos : dto.getArrayProductos()) {
                        idProducto = String.valueOf(productos.getIdProducto());
                        ventana.getPanelAdmin().getBuscarProducto().getIdComboBox().addItem(idProducto);
                    }
                    break;
                case "PRODUCTO_BUSCAR_COMBOBOX":
                    idProducto = (String) ventana.getPanelAdmin().getBuscarProducto().getIdComboBox().getSelectedItem();

                    if (idProducto != null) {
                        if (!idProducto.equals("")) {
                            producto = dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(idProducto));
                            ventana.getPanelAdmin().getBuscarProducto().getNombre().setText(producto.getNombreProducto());
                            ventana.getPanelAdmin().getBuscarProducto().getNombre().setText(producto.getNombreProducto());
                            ventana.getPanelAdmin().getBuscarProducto().getDescripcion().setText(producto.getLoreProducto());
                            ventana.getPanelAdmin().getBuscarProducto().getPrecio().setText("$" + producto.getPrecioProducto());
                            ventana.getPanelAdmin().getBuscarProducto().getImagenLabel().setIcon(producto.getImagenProducto());
                        }
                    } else {
                        ventana.getPanelAdmin().getBuscarProducto().getNombre().setText("");
                        ventana.getPanelAdmin().getBuscarProducto().getDescripcion().setText("");
                        ventana.getPanelAdmin().getBuscarProducto().getPrecio().setText("");
                        ventana.getPanelAdmin().getBuscarProducto().getImagenLabel().setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    }
                    break;
                case "PRODUCTO_ELIMINAR_ACEPTAR":
                    idProducto = (String) ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().getSelectedItem();

                    if (idProducto != null) {
                        if (!idProducto.equals("")) {
                            if (dto.getDaoProducto().eliminarProducto(dto.getArrayProductos(), dto.getFileProductos(), Integer.parseInt(idProducto))) {
                                ventana.getMensajes().mostrarInfo("El producto ha sido eliminado correctamente.");
                                ventana.getPanelAdmin().getEliminarProducto().getIdComboBox().removeItem(idProducto);
                            } else {
                                ventana.getMensajes().mostrarError("Este producto ya no existe.");
                            }
                        }
                    }
                    break;
            }
        } else if (comando.contains("PAREJA")) {
            String idPareja;
            String nombres;
            String apellidos;
            String genero;
            String anioNacimiento;
            String mesNacimiento;
            String diaNacimiento;
            String fechaNacimiento;
            long saldo;
            Cliente cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuarioSesion);
            ArrayList<Pareja> parejasArray = cliente.getParejas();
            Pareja pareja;

            switch (comando) {
                case "TARJETA_PAREJA":
                    ventana.getDialogUsuario().setVisible(true);
                    ventana.getDialogUsuario().setLocationRelativeTo(null);

                    ventana.getDialogUsuario().getTarjetaCreditoPanel().getCvv().setText(String.valueOf(cliente.getCodigoTarjeta()));

                    StringBuilder mensaje = new StringBuilder();
                    int contador = 0;
                    for (int i = 0; i < cliente.getBinTarjeta().length(); i++) {
                        if (contador == 3) {
                            mensaje.append(cliente.getBinTarjeta().charAt(i)).append(" ");
                            contador = 0;
                        } else {
                            contador++;
                            mensaje.append(cliente.getBinTarjeta().charAt(i));
                        }
                    }
                    ventana.getDialogUsuario().getTarjetaCreditoPanel().getBin().setText(mensaje.toString());

                    break;
                case "PAREJA_AGREGAR_ACEPTAR":
                    try {
                        idPareja = ventana.getPanelAdmin().getAgregarPareja().getIdPareja().getText();
                        nombres = ventana.getPanelAdmin().getAgregarPareja().getNombres().getText();
                        apellidos = ventana.getPanelAdmin().getAgregarPareja().getApellidos().getText();
                        genero = (String) ventana.getPanelAdmin().getAgregarPareja().getGeneroCombo().getSelectedItem();
                        anioNacimiento = String.valueOf(ventana.getPanelAdmin().getAgregarPareja().getAnioNacimientoComboBox().getSelectedItem());
                        mesNacimiento = (String) ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().getSelectedItem();
                        diaNacimiento = String.valueOf(ventana.getPanelAdmin().getAgregarPareja().getDiaNacimientoComboBox().getSelectedItem());
                        fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
                        saldo = Long.parseLong(ventana.getPanelAdmin().getAgregarPareja().getSaldo().getText());

                        if (!(saldo > cliente.getSaldo())) {
                            if (dto.getDaoCliente().agregarPareja(dto.getArrayClientes(), dto.getFileClientes(), parejasArray, cliente.getUsuario(), Integer.parseInt(idPareja), nombres, apellidos, genero, fechaNacimiento, saldo)) {
                                ventana.getMensajes().mostrarInfo("La pareja ha sido agregada correctamente.");
                            } else {
                                ventana.getMensajes().mostrarError("Ya existe una pareja con esta ID.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        ventana.getMensajes().mostrarError("Recuerde que los campos de ID y saldo deben contener únicamente valores numéricos.");
                    }
                    break;
                case "LISTADO_PAREJA":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoPareja());

                    ventana.getPanelAdmin().getListadoPareja().getDefaultTableModel().setRowCount(0);
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        nombres = parejas.getNombres();
                        apellidos = parejas.getApellidos();
                        genero = parejas.getGenero();
                        fechaNacimiento = parejas.getFechaNacimiento();
                        saldo = parejas.getSaldo();
                        ventana.getPanelAdmin().getListadoPareja().getDefaultTableModel().addRow(new String[]{idPareja, nombres, apellidos, genero, fechaNacimiento, String.valueOf(saldo)});
                    }
                    break;
                case "MODIFICAR_PAREJA":
                    ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().removeAllItems();
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().addItem(idPareja);
                    }
                    break;
                case "PAREJA_MODIFICAR_COMBOBOX":
                    idPareja = (String) ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().getSelectedItem();

                    if (idPareja != null) {
                        if (!idPareja.equals("")) {
                            try {
                                pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                                ventana.getPanelAdmin().getModificarPareja().getNombres().setText(pareja.getNombres());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Esta pareja ya no existe.");
                                ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().removeItem(idPareja);
                                idPareja = (String) ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().getSelectedItem();
                            } finally {
                                pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                                ventana.getPanelAdmin().getModificarPareja().getNombres().setText(pareja.getNombres());
                                ventana.getPanelAdmin().getModificarPareja().getApellidos().setText(pareja.getApellidos());
                                ventana.getPanelAdmin().getModificarPareja().getSaldo().setText(String.valueOf(pareja.getSaldo()));
                                ventana.getPanelAdmin().getModificarPareja().getGeneroCombo().setSelectedItem(pareja.getGenero());
                            }
                        }
                    } else {
                        ventana.getPanelAdmin().getModificarPareja().getNombres().setText("");
                        ventana.getPanelAdmin().getModificarPareja().getApellidos().setText("");
                        ventana.getPanelAdmin().getModificarPareja().getSaldo().setText("");
                    }
                    break;
/*                case "PAREJA_MODIFICAR_ACEPTAR":
                    idPareja = (String) ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().getSelectedItem();
                    nombres = ventana.getPanelAdmin().getModificarPareja().getNombres().getText();
                    apellidos = ventana.getPanelAdmin().getModificarPareja().getApellidos().getText();
                    genero = (String) ventana.getPanelAdmin().getModificarPareja().getGeneroCombo().getSelectedItem();
                    diaNacimiento = String.valueOf(ventana.getPanelAdmin().getModificarPareja().getDiaNacimientoComboBox().getSelectedItem());
                    mesNacimiento = (String) ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().getSelectedItem();
                    anioNacimiento = String.valueOf(ventana.getPanelAdmin().getModificarPareja().getAnioNacimientoComboBox().getSelectedItem());
                    fechaNacimiento = diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
                    saldo = Long.parseLong(ventana.getPanelAdmin().getModificarPareja().getSaldo().getText());

                    assert idPareja != null;
                    if (dto.getDaoCliente().modificarPareja(dto.getArrayClientes(), dto.getFileProductos(), cliente.getParejas(), cliente.getUsuario(), Integer.parseInt(idPareja), nombres, apellidos, genero, fechaNacimiento, saldo)) {
                        ventana.getMensajes().mostrarInfo("La  pareja ha sido modificada correctamente.");
                    } else {
                        ventana.getMensajes().mostrarInfo("La pareja especificada no existe.");
                    }
                    break;*/
                case "ELIMINAR_PAREJA":
                    ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().removeAllItems();
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().addItem(idPareja);
                    }
                    break;
                case "PAREJA_ELIMINAR_COMBOBOX":
                    idPareja = (String) ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().getSelectedItem();

                    if (idPareja != null) {
                        if (!idPareja.equals("")) {
                            pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                            ventana.getPanelAdmin().getEliminarPareja().getNombres().setText(pareja.getNombres());
                            ventana.getPanelAdmin().getEliminarPareja().getApellidos().setText(pareja.getApellidos());
                            ventana.getPanelAdmin().getEliminarPareja().getSaldo().setText("$" + pareja.getSaldo());
                            ventana.getPanelAdmin().getEliminarPareja().getGeneroField().setText(pareja.getGenero());
                            ventana.getPanelAdmin().getEliminarPareja().getFechaNacimientoField().setText(pareja.getFechaNacimiento());
                        }
                    } else {
                        ventana.getPanelAdmin().getEliminarPareja().getNombres().setText("");
                        ventana.getPanelAdmin().getEliminarPareja().getApellidos().setText("");
                        ventana.getPanelAdmin().getEliminarPareja().getSaldo().setText("");
                        ventana.getPanelAdmin().getEliminarPareja().getGeneroField().setText("");
                        ventana.getPanelAdmin().getEliminarPareja().getFechaNacimientoField().setText("");
                    }
                    break;
                case "PAREJA_ELIMINAR_ACEPTAR":
                    idPareja = (String) ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().getSelectedItem();

                    if (idPareja != null) {
                        if (!idPareja.equals("")) {
                            if (dto.getDaoCliente().eliminarPareja(dto.getArrayClientes(), dto.getFileClientes(), cliente.getParejas(), cliente.getUsuario(), Integer.parseInt(idPareja))) {
                                ventana.getMensajes().mostrarInfo("La pareja ha sido eliminada correctamente.");
                                ventana.getPanelAdmin().getEliminarPareja().getIdParejaCombo().removeItem(idPareja);
                            } else {
                                ventana.getMensajes().mostrarError("Esta pareja ya no existe.");
                            }
                        }
                    }
                    break;


              /*  case "MODIFICAR_PAREJA":
                    ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().removeAllItems();
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().addItem(idPareja);
                    }
                case "PAREJA_MODIFICAR_COMBOBOX":
                    idPareja = (String) ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().getSelectedItem();

                    if (idPareja != null) {
                        if (!idPareja.equals("")) {
                            try {
                                pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                                ventana.getPanelAdmin().getModificarPareja().getNombres().setText(pareja.getNombres());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Esta pareja ya no existe.");
                                ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().removeItem(idPareja);
                                idPareja = (String) ventana.getPanelAdmin().getModificarPareja().getIdParejaCombo().getSelectedItem();
                            } finally {
                                pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                                ventana.getPanelAdmin().getModificarPareja().getNombres().setText(pareja.getNombres());
                                ventana.getPanelAdmin().getModificarPareja().getApellidos().setText(pareja.getApellidos());
                                ventana.getPanelAdmin().getModificarPareja().getSaldo().setText(String.valueOf(pareja.getSaldo()));
                            }
                        }
                    } else {
                        ventana.getPanelAdmin().getModificarPareja().getNombres().setText("");
                        ventana.getPanelAdmin().getModificarPareja().getApellidos().setText("");
                        ventana.getPanelAdmin().getModificarPareja().getSaldo().setText("");
                    }
                    break;


                case "BUSCAR_PAREJA":
                    ventana.getPanelAdmin().getBuscarPareja().getIdParejaCombo().removeAllItems();
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        ventana.getPanelAdmin().getBuscarPareja().getIdParejaCombo().addItem(idPareja);
                    }
                    break;
                case "PAREJA_BUSCAR_COMBOBOX":
                    idPareja = (String) ventana.getPanelAdmin().getBuscarPareja().getIdParejaCombo().getSelectedItem();

                    if (idPareja != null) {
                        if (!idPareja.equals("")) {
                            pareja = dto.getDaoCliente().buscarPareja(cliente.getParejas(), Integer.parseInt(idPareja));
                            ventana.getPanelAdmin().getBuscarPareja().getNombres().setText(pareja.getNombres());
                            ventana.getPanelAdmin().getBuscarPareja().getApellidos().setText(pareja.getApellidos());
                            ventana.getPanelAdmin().getBuscarPareja().getSaldo().setText("$" + pareja.getSaldo());
                            ventana.getPanelAdmin().getBuscarPareja().getGeneroField().setText(pareja.getGenero());
                            ventana.getPanelAdmin().getBuscarPareja().getFechaNacimientoField().setText(pareja.getFechaNacimiento());
                        }
                    } else {
                        ventana.getPanelAdmin().getBuscarPareja().getNombres().setText("");
                        ventana.getPanelAdmin().getBuscarPareja().getApellidos().setText("");
                        ventana.getPanelAdmin().getBuscarPareja().getSaldo().setText("");
                        ventana.getPanelAdmin().getBuscarPareja().getGeneroField().setText("");
                        ventana.getPanelAdmin().getBuscarPareja().getFechaNacimientoField().setText("");
                    }
                    break;

                case "LISTADO_PAREJA":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoPareja());

                    ventana.getPanelAdmin().getListadoPareja().getDefaultTableModel().setRowCount(0);
                    for (Pareja parejas : cliente.getParejas()) {
                        idPareja = String.valueOf(parejas.getId());
                        nombres = parejas.getNombres();
                        apellidos = parejas.getApellidos();
                        genero = parejas.getGenero();
                        fechaNacimiento = parejas.getFechaNacimiento();
                        saldo = parejas.getSaldo();
                        ventana.getPanelAdmin().getListadoPareja().getDefaultTableModel().addRow(new String[]{idPareja, nombres, apellidos, genero, fechaNacimiento, String.valueOf(saldo)});
                    }
                    break;
            }*/
            }
        }
    }

    public void visibilidadPaneles(JPanel panelVisible) {
        ventana.getPanelAdmin().getAgregarProducto().setVisible(false);
        ventana.getPanelAdmin().getBuscarProducto().setVisible(false);
        ventana.getPanelAdmin().getModificarProducto().setVisible(false);
        ventana.getPanelAdmin().getEliminarProducto().setVisible(false);
        ventana.getPanelAdmin().getListadoProducto().setVisible(false);

        ventana.getPanelAdmin().getAgregarTienda().setVisible(false);
        ventana.getPanelAdmin().getBuscarTienda().setVisible(false);
        ventana.getPanelAdmin().getModificarTienda().setVisible(false);
        ventana.getPanelAdmin().getEliminarTienda().setVisible(false);
        ventana.getPanelAdmin().getListadoTienda().setVisible(false);

        ventana.getPanelAdmin().getAgregarCliente().setVisible(false);
        ventana.getPanelAdmin().getBuscarCliente().setVisible(false);
        ventana.getPanelAdmin().getModificarCliente().setVisible(false);
        ventana.getPanelAdmin().getEliminarCliente().setVisible(false);
        ventana.getPanelAdmin().getListadoCliente().setVisible(false);

        ventana.getPanelAdmin().getAgregarPareja().setVisible(false);
        ventana.getPanelAdmin().getBuscarPareja().setVisible(false);
        ventana.getPanelAdmin().getModificarPareja().setVisible(false);
        ventana.getPanelAdmin().getEliminarPareja().setVisible(false);
        ventana.getPanelAdmin().getListadoPareja().setVisible(false);

        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getAgregarProducto());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getBuscarProducto());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getModificarProducto());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getEliminarProducto());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getListadoProducto());

        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getAgregarTienda());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getBuscarTienda());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getModificarTienda());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getEliminarTienda());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getListadoTienda());

        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getAgregarCliente());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getBuscarCliente());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getModificarCliente());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getEliminarCliente());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getListadoCliente());

        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getAgregarPareja());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getBuscarPareja());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getModificarPareja());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getEliminarPareja());
        ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getListadoPareja());

        if (panelVisible != null) {
            ventana.getPanelAdmin().add(panelVisible, BorderLayout.CENTER);
            panelVisible.setVisible(true);
        }
    }

    public ImageIcon cargarImagen() {
        FileDialog fileDialog = new FileDialog(ventana, "Seleccione una imagen", FileDialog.LOAD);
        fileDialog.setFile("*.jpg;*.jpeg;*.png;*.jfif");
        fileDialog.show();

        if (fileDialog.getFile() == null) {
            ventana.getMensajes().mostrarError("No ha seleccionado ninguna imagen.");
            return new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        } else {
            String ruta = (fileDialog.getDirectory() + fileDialog.getFile());
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage(ruta);
            imageAux = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            return imageAux;
        }
    }

    public void visibilidadOpcionesAdmin(String comando) {
        HashMap<String, JPanel> panelHashMap = new HashMap<>();
        panelHashMap.put("TIENDA_ADMINISTRAR", ventana.getPanelPrincipal().getAccionesTienda());
        panelHashMap.put("CLIENTE_ADMINISTRAR", ventana.getPanelPrincipal().getAccionesCliente());
        panelHashMap.put("PRODUCTO_ADMINISTRAR", ventana.getPanelPrincipal().getAccionesProducto());

        panelHashMap.put("REGRESAR_PANEL_TIENDA", ventana.getPanelPrincipal().getAccionesTienda());
        panelHashMap.put("REGRESAR_PANEL_CLIENTE", ventana.getPanelPrincipal().getAccionesCliente());
        panelHashMap.put("REGRESAR_PANEL_PRODUCTO", ventana.getPanelPrincipal().getAccionesProducto());

        panelHashMap.put("AGREGAR_PRODUCTO", ventana.getPanelAdmin().getAgregarProducto());
        panelHashMap.put("BUSCAR_PRODUCTO", ventana.getPanelAdmin().getBuscarProducto());
        panelHashMap.put("MODIFICAR_PRODUCTO", ventana.getPanelAdmin().getModificarProducto());
        panelHashMap.put("ELIMINAR_PRODUCTO", ventana.getPanelAdmin().getEliminarProducto());

        panelHashMap.put("AGREGAR_TIENDA", ventana.getPanelAdmin().getAgregarTienda());
        panelHashMap.put("BUSCAR_TIENDA", ventana.getPanelAdmin().getBuscarTienda());
        panelHashMap.put("MODIFICAR_TIENDA", ventana.getPanelAdmin().getModificarTienda());
        panelHashMap.put("ELIMINAR_TIENDA", ventana.getPanelAdmin().getEliminarTienda());

        panelHashMap.put("AGREGAR_CLIENTE", ventana.getPanelAdmin().getAgregarCliente());
        panelHashMap.put("BUSCAR_CLIENTE", ventana.getPanelAdmin().getBuscarCliente());
        panelHashMap.put("MODIFICAR_CLIENTE", ventana.getPanelAdmin().getModificarCliente());
        panelHashMap.put("ELIMINAR_CLIENTE", ventana.getPanelAdmin().getEliminarCliente());

        panelHashMap.put("AGREGAR_PAREJA", ventana.getPanelAdmin().getAgregarPareja());
        panelHashMap.put("BUSCAR_PAREJA", ventana.getPanelAdmin().getBuscarPareja());
        panelHashMap.put("MODIFICAR_PAREJA", ventana.getPanelAdmin().getModificarPareja());
        panelHashMap.put("ELIMINAR_PAREJA", ventana.getPanelAdmin().getEliminarPareja());

        boolean visibilidadPanelPrincipal = ventana.getPanelPrincipal().getPanelAdminGestion().isVisible();
        JPanel aux = null;

        if (panelHashMap.containsKey(comando)) {
            if (comando.contains("ADMINISTRAR") || comando.contains("REGRESAR")) {
                if (panelHashMap.get(comando).isVisible()) {
                    panelHashMap.get(comando).setVisible(!panelHashMap.get(comando).isVisible());
                    ventana.getPanelPrincipal().remove(panelHashMap.get(comando));
                    //ventana.getPanelAdmin().add(ventana.getPanelAdmin().getPanelAdminOpciones(), BorderLayout.NORTH);
                    ventana.getPanelPrincipal().add(ventana.getPanelPrincipal().getPanelAdminGestion(), BorderLayout.NORTH);
                } else {
                    ventana.getPanelPrincipal().add(panelHashMap.get(comando), BorderLayout.NORTH);
                    panelHashMap.get(comando).setVisible(!panelHashMap.get(comando).isVisible());
                    //ventana.getPanelAdmin().remove(ventana.getPanelAdmin().getPanelAdminOpciones());
                    ventana.getPanelPrincipal().remove(ventana.getPanelPrincipal().getPanelAdminGestion());
                }
                ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(!visibilidadPanelPrincipal);
            } else {
                aux = panelHashMap.get(comando);
            }
            visibilidadPaneles(aux);
        }
    }

    public void formatoFecha() {
        ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().removeAllItems();
        ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().removeAllItems();

        ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().removeAllItems();
        ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().removeAllItems();

        ventana.getPanelAdmin().getAgregarPareja().getAnioNacimientoComboBox().removeAllItems();
        ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().removeAllItems();

        ventana.getPanelAdmin().getModificarPareja().getAnioNacimientoComboBox().removeAllItems();
        ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().removeAllItems();

        anioActual = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("El anio actual es: " + anioActual);

        String[] mesesArray = DateFormatSymbols.getInstance().getMonths();
        for (String mes : mesesArray) {
            if (!mes.equals("")) {
                ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().addItem(mes.toUpperCase());
                ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().addItem(mes.toUpperCase());

                ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().addItem(mes.toUpperCase());
                ventana.getPanelAdmin().getAgregarPareja().getMesNacimientoComboBox().addItem(mes.toUpperCase());

                ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().addItem(mes.toUpperCase());
                ventana.getPanelAdmin().getModificarPareja().getMesNacimientoComboBox().addItem(mes.toUpperCase());
            }
        }

        for (int i = anioActual; i >= (anioActual - 120); i--) {
            ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().addItem(i);
            ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().addItem(i);

            ventana.getPanelAdmin().getAgregarPareja().getAnioNacimientoComboBox().addItem(i);
            ventana.getPanelAdmin().getModificarPareja().getAnioNacimientoComboBox().addItem(i);
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
