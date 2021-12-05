package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class Controller implements ActionListener {

    private final VentanaPrincipal ventana;

    private final Dto dto;

    private ImageIcon imageAux;

    private ImageIcon iconAux;

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

        ventana.getPanelAdmin().getAgregarTienda().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getBuscarTienda().getIdComboBox().addActionListener(this);
        ventana.getPanelAdmin().getEliminarTienda().getIdComboBox().addActionListener(this);

        ventana.getPanelAdmin().getEliminarTienda().getAceptar().addActionListener(this);

        ventana.getPanelAdmin().getModificarTienda().getAceptar().addActionListener(this);
        ventana.getPanelAdmin().getModificarTienda().getIdComboBox().addActionListener(this);


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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println(comando);

        visibilidadOpcionesAdmin(comando);

        String nombres;
        String apellidos;
        String correo;
        Integer anioNacimiento;
        String mesNacimiento;
        Integer diaNacimiento;
        String genero;

        if (comando.contains("PRINCIPAL")) {
            String usuario;
            String clave;

            switch (comando) {
                case "PRINCIPAL_REGISTRARSE":
                    break;
                case "PRINCIPAL_INICIAR_SESION":
                    usuario = ventana.getPanelPrincipal().getUsuario().getText();
                    clave = ventana.getPanelPrincipal().getClave().getText();

                    if (usuario.equals("") || clave.equals("")) {
                        ventana.getMensajes().mostrarError("Debe llenar ambos campos para poder iniciar sesión.");
                    } else {
                        Cliente cliente = dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario);

                        if (usuario.equalsIgnoreCase("A") && clave.equalsIgnoreCase("A")) {
                            ventana.remove(ventana.getScrollProductos());
                            ventana.add(ventana.getPanelAdmin(), BorderLayout.CENTER);
                            ventana.getPanelAdmin().setVisible(true);
                            ventana.getPanelPrincipal().getPanelCarrito().setVisible(false);
                            ventana.getPanelPrincipal().getPanelSesion().setVisible(false);
//                            ventana.getPanelPrincipal().add(ventana.getPanelPrincipal().getPanelAdminGestion());
                            ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(true);
                            ventana.setSize(900, 500);
                            ventana.setLocationRelativeTo(null);
                        } else if (cliente != null) {
                            if (cliente.getClave().equals(clave)) {
                                ventana.remove(ventana.getPanelPrincipal());
                                ventana.remove(ventana.getScrollProductos());
                                ventana.add(ventana.getPanelUsuario(), BorderLayout.CENTER);
                                ventana.getPanelUsuario().setVisible(true);
                            } else {
                                ventana.getMensajes().mostrarError("El usuario o la clave es incorrecta.");
                            }
                        } else {
                            ventana.getMensajes().mostrarError("El usuario o la clave es incorrecta.");
                        }
                    }
                    break;
                case "PRINCIPAL_PAGAR":
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
        if (comando.contains("TIENDA")) {
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

                        if (dto.getDaoTienda().agregarTienda(dto.getArrayTiendas(), dto.getFileTiendas(), Integer.parseInt(idTienda), ciudad, direccion)) {
                            ventana.getMensajes().mostrarInfo("La tienda ha sido agregada correctamente.");
                        } else {
                            ventana.getMensajes().mostrarError("Ya existe una tienda con esta ID.");
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
                    }
                    break;
                case "TIENDA_MODIFICAR_ACEPTAR":
                    idTienda = (String) ventana.getPanelAdmin().getModificarTienda().getIdComboBox().getSelectedItem();
                    ciudad = ventana.getPanelAdmin().getModificarTienda().getCiudad().getText();
                    direccion = ventana.getPanelAdmin().getModificarTienda().getDireccion().getText();

                    assert idTienda != null;
                    if (dto.getDaoTienda().modificarTienda(dto.getArrayTiendas(), dto.getFileTiendas(), Integer.parseInt(idTienda), ciudad, direccion)) {
                        ventana.getMensajes().mostrarInfo("La tienda ha sido modificada correctamente.");
                    } else {
                        ventana.getMensajes().mostrarInfo("La tienda especificada no existe.");
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
                            ventana.getPanelAdmin().getEliminarTienda().getCiudad().setText(tienda.getCiudadTienda());
                            ventana.getPanelAdmin().getEliminarTienda().getDireccion().setText(tienda.getDireccionTienda());
                        }
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
                            ventana.getPanelAdmin().getBuscarTienda().getCiudad().setText(tienda.getCiudadTienda());
                            ventana.getPanelAdmin().getBuscarTienda().getDireccion().setText(tienda.getDireccionTienda());
                        }
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

        } else if (comando.contains("CLIENTE")) {
            String fechaNacimiento;
            String usuario;
            String clave;
            Cliente cliente;

            switch (comando) {
                case "LISTADO_CLIENTE":
                    visibilidadPaneles(ventana.getPanelAdmin().getListadoProducto());

                    ventana.getPanelAdmin().getListadoProducto().getDefaultTableModel().setRowCount(0);
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
                                ventana.getPanelAdmin().getModificarCliente().getNombres().setText(cliente.getNombres());
                            } catch (NullPointerException ex) {
                                ventana.getMensajes().mostrarError("Este producto ya no existe.");
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
                    }
                    break;
                case "INGRESAR_MODIFICACION_CLIENTE":
                    usuario = (String) ventana.getPanelAdmin().getModificarCliente().getUsuarioCombo().getSelectedItem();
                    clave = ventana.getPanelAdmin().getModificarCliente().getClave().getText();
                    nombres = ventana.getPanelAdmin().getModificarCliente().getNombres().getText();
                    apellidos = ventana.getPanelAdmin().getModificarCliente().getApellidos().getText();
                    correo = ventana.getPanelAdmin().getModificarCliente().getCorreo().getText();
                    genero = (String) ventana.getPanelAdmin().getModificarCliente().getGenero().getSelectedItem();
                    fechaNacimiento = ventana.getPanelAdmin().getModificarCliente().getDiaNacimientoComboBox().getSelectedItem() + "/" + ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().getSelectedItem() + "/" + ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().getSelectedItem();

                    assert usuario != null;
                    if (dto.getDaoCliente().modificarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento)) {
                        ventana.getMensajes().mostrarInfo("El cliente ha sido modificado correctamente.");
                    } else {
                        ventana.getMensajes().mostrarInfo("El cliente especificado no existe.");
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

        if (panelVisible != null) {
            ventana.getPanelAdmin().add(panelVisible, BorderLayout.CENTER);
            panelVisible.setVisible(true);
        }
    }

    public ImageIcon cargarImagen() {
        FileDialog fileDialog = new FileDialog(ventana, "Seleccione una imagen", FileDialog.LOAD);
        fileDialog.show();

        if (fileDialog.getFile() == null) {
            ventana.getMensajes().mostrarError("No ha seleccionado ninguna imagen.");
            return new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        } else if (!fileDialog.getFile().endsWith("png") || !fileDialog.getFile().endsWith("jpg") || !fileDialog.getFile().endsWith("jfif")) {
            ventana.getMensajes().mostrarError("El archivo seleccionado es inválido. Recuerde utilizar únicamente\nimagenes con formato .png .jpg o .jfif");
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

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("El anio actual es: " + anioActual);

        String[] mesesArray = DateFormatSymbols.getInstance().getMonths();
        for (String mes : mesesArray) {
            if (!mes.equals("")) {
                ventana.getPanelAdmin().getAgregarCliente().getMesNacimientoComboBox().addItem(mes.toUpperCase());
                ventana.getPanelAdmin().getModificarCliente().getMesNacimientoComboBox().addItem(mes.toUpperCase());
            }
        }

        for (int i = anioActual; i >= (anioActual - 120); i--) {
            ventana.getPanelAdmin().getAgregarCliente().getAnioNacimientoComboBox().addItem(i);
            ventana.getPanelAdmin().getModificarCliente().getAnioNacimientoComboBox().addItem(i);
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
