package co.edu.unbosque.controller;

import co.edu.unbosque.model.Dto;
import co.edu.unbosque.model.GeneradorTarjetas;
import co.edu.unbosque.model.Producto;
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

    private final VentanaPrincipal ventanaPrincipal;

    private final Dto dto;

    private final GeneradorTarjetas generadorTarjetas;

    private ImageIcon imageAux;

    public Controller() {
        dto = new Dto();
        generadorTarjetas = new GeneradorTarjetas(dto);
        ventanaPrincipal = new VentanaPrincipal();
        listeners();
        formatoFecha();
    }

    public void listeners() {
        ventanaPrincipal.getPanelPrincipal().getIniciarSesionButton().addActionListener(this);
        ventanaPrincipal.getPanelPrincipal().getRegistrarseButton().addActionListener(this);

        ventanaPrincipal.getDialogRegistro().getMesNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getDialogRegistro().getAnioNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getDialogRegistro().getAceptarButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().getProductosButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().getClientesButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().getRegresarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().getReportesButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().getTiendasButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getAgregarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getBuscarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getModificarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getEliminarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getMostrarTodosButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesClientes().getRegresarButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getAgregarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getBuscarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getModificarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getEliminarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getMostrarTodosButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesProductos().getRegresarButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getAgregarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getBuscarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getModificarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getEliminarButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getMostrarTodosButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getOpcionesTiendas().getRegresarButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getAgregarProductoButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getImagenButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getModificarProductoPanel().getAgregarProductoButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getModificarProductoPanel().getImagenButton().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAgregarClienteButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAnioNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getMesNacimientoComboBox().addActionListener(this);

        ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getAgregarClienteButton().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getAnioNacimientoComboBox().addActionListener(this);
        ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getMesNacimientoComboBox().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String busqueda;
        String[] separadorComando = comando.split("_");
        System.out.println(comando);

        visibilidadOpcionesAdmin(comando);

        switch (comando) {
            case "INICIAR_SESION":
                iniciarSesion();
                break;
            case "REGISTRARSE":
                ventanaPrincipal.getDialogRegistro().setVisible(true);
                ventanaPrincipal.getDialogRegistro().setLocationRelativeTo(null);
                break;
            case "FECHA_NACIMIENTO":
                JComboBox<Integer> agregarDiaComboBox = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getDiaNacimientoComboBox();
                String agregarMesComboBox = (String) ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getMesNacimientoComboBox().getSelectedItem();
                JComboBox<Integer> agregarAnioComboBox = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAnioNacimientoComboBox();

                JComboBox<Integer> modificarDiaComboBox = ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getDiaNacimientoComboBox();
                String modificarMesComboBox = (String) ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getMesNacimientoComboBox().getSelectedItem();
                JComboBox<Integer> modificarAnioComboBox = ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getAnioNacimientoComboBox();

                try {
                    assert agregarMesComboBox != null;
                    assert modificarMesComboBox != null;
                    calcularDias(agregarMesComboBox, agregarDiaComboBox, agregarAnioComboBox);
                    calcularDias(modificarMesComboBox, modificarDiaComboBox, modificarAnioComboBox);
                } catch (NullPointerException ex) {
                    ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().setVisible(false);
                    ventanaPrincipal.getPanelAdmin().getModificarClientePanel().setVisible(false);
                }
                break;
            case "INGRESAR_REGISTRO":
                String nombres = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getNombresField().getText();
                String apellidos = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getApellidosField().getText();
                String correo = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getCorreoField().getText();
                Integer anioNacimiento = (Integer) ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAnioNacimientoComboBox().getSelectedItem();
                String mesNacimiento = (String) ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getMesNacimientoComboBox().getSelectedItem();
                Integer diaNacimiento = (Integer) ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getDiaNacimientoComboBox().getSelectedItem();
                String genero = (String) ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getGeneroComboBox().getSelectedItem();
                String usuario = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getUsuarioField().getText();
                String clave = ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getClaveField().getText();

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

                        if (dto.getDaoCliente().agregarCliente(dto.getArrayClientes(), dto.getFileClientes(), usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, null, binTarjeta, mesCaducidad, anioCaducidad, codigoTarjeta)) {
                            ventanaPrincipal.getMensajes().mostrarInfo("¡Bienvenido, su registro ha sido exitoso!\nEn unos minutos recibirá un correo de confirmación.");
                        } else {
                            ventanaPrincipal.getMensajes().mostrarError("Ya existe un cliente con este nombre de usuario.");
                        }
                    }
                }
                break;
            case "BUSCAR_CLIENTE":
                busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese el usuario que desea buscar: ");
                if (!(busqueda == null)) {
                    if (!busqueda.equals("")) {
                        if (dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), busqueda) != null) {
                            ventanaPrincipal.getMensajes().mostrarInfo(dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), busqueda).toString());
                        } else {
                            ventanaPrincipal.getMensajes().mostrarError("No se encontró a ningún cliente con el usuario " + (char) 34 + busqueda + (char) 34 + ".");
                        }
                    }
                }
                break;
            case "BUSCAR_PRODUCTO":
                try {
                    busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese la ID del producto que desea buscar: ");
                    if (!(busqueda == null)) {
                        if (!busqueda.equals("")) {
                            if (dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(busqueda)) != null) {
                                Producto producto = dto.getDaoProducto().buscarProducto(dto.getArrayProductos(), Integer.parseInt(busqueda));
                                ventanaPrincipal.getMensajes().mostrarInfoImagen(producto.toString(), producto.getImagenProducto());
                            } else {
                                ventanaPrincipal.getMensajes().mostrarError("No se encontró a ningún producto con la id " + (char) 34 + busqueda + (char) 34 + ".");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    ventanaPrincipal.getMensajes().mostrarError("Recuerde que la ID solo debe contener números.");
                }
                break;
            case "BUSCAR_TIENDA":
                try {
                    busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese la ID de la tienda que desea buscar: ");
                    if (!(busqueda == null)) {
                        if (!busqueda.equals("")) {
                            if (dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(busqueda)) != null) {
                                ventanaPrincipal.getMensajes().mostrarInfo(dto.getDaoTienda().buscarTienda(dto.getArrayTiendas(), Integer.parseInt(busqueda)).toString());
                            } else {
                                ventanaPrincipal.getMensajes().mostrarError("No se encontró a ninguna tienda con la id " + (char) 34 + busqueda + (char) 34 + ".");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    ventanaPrincipal.getMensajes().mostrarError("Recuerde que la ID solo debe contener números.");
                }
                break;
            case "ELIMINAR_CLIENTE":
                busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese el usuario que desea eliminar: ");
                if (!(busqueda == null)) {
                    if (!busqueda.equals("")) {
                        if (dto.getDaoCliente().eliminarCliente(dto.getArrayClientes(), dto.getFileClientes(), busqueda)) {
                            ventanaPrincipal.getMensajes().mostrarInfo("El cliente con usuario" + (char) 34 + busqueda + (char) 34 + " ha sido eliminado correctamente.");
                        } else {
                            ventanaPrincipal.getMensajes().mostrarError("No se encontró a ningún cliente con el usuario " + (char) 34 + busqueda + (char) 34 + ".");
                        }
                    }
                }
                break;
            case "ELIMINAR_PRODUCTO":
                try {
                    busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese la ID del producto que desea eliminar: ");
                    if (!(busqueda == null)) {
                        if (!busqueda.equals("")) {
                            if (dto.getDaoProducto().eliminarProducto(dto.getArrayProductos(), dto.getFileProductos(), Integer.parseInt(busqueda))) {
                                ventanaPrincipal.getMensajes().mostrarInfo("El producto con ID" + (char) 34 + busqueda + (char) 34 + " ha sido eliminada correctamente.");
                            } else {
                                ventanaPrincipal.getMensajes().mostrarError("No se encontró a ningún producto con la id " + (char) 34 + busqueda + (char) 34 + ".");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    ventanaPrincipal.getMensajes().mostrarError("Recuerde que la ID solo debe contener números.");
                }
                break;
            case "ELIMINAR_TIENDA":
                try {
                    busqueda = ventanaPrincipal.getMensajes().pedirDatoString("Ingrese la ID de la tienda que desea eliminar: ");
                    if (!(busqueda == null)) {
                        if (!busqueda.equals("")) {
                            if (dto.getDaoTienda().eliminarTienda(dto.getArrayTiendas(), dto.getFileClientes(), Integer.parseInt(busqueda))) {
                                ventanaPrincipal.getMensajes().mostrarInfo("La tienda con ID" + (char) 34 + busqueda + (char) 34 + " ha sido eliminada correctamente.");
                            } else {
                                ventanaPrincipal.getMensajes().mostrarError("No se encontró a ninguna tienda con la id " + (char) 34 + busqueda + (char) 34 + ".");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    ventanaPrincipal.getMensajes().mostrarError("Recuerde que la ID solo debe contener números.");
                }
                break;
            case "AGREGAR_PRODUCTO":
                ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().setVisible(true);
                ventanaPrincipal.getPanelAdmin().getModificarProductoPanel().setVisible(false);
                break;
            case "AGREGAR_CLIENTE":
                ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().setVisible(true);
                ventanaPrincipal.getPanelAdmin().getModificarClientePanel().setVisible(false);
                break;
            case "MODIFICAR_PRODUCTO":
                ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().setVisible(false);
                ventanaPrincipal.getPanelAdmin().getModificarProductoPanel().setVisible(true);
                break;
            case "MODIFICAR_CLIENTE":
                ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().setVisible(false);
                ventanaPrincipal.getPanelAdmin().getModificarClientePanel().setVisible(true);
                break;
            case "INGRESAR_PRODUCTO":
                try {
                    int idProducto = Integer.parseInt(ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getIdField().getText());
                    String nombreProducto = ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getNombreField().getText();
                    String loreProducto = ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getDescripcionField().getText();
                    long precioProducto = Long.parseLong(ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getPrecioField().getText());

                    if (dto.getDaoProducto().agregarProducto(dto.getArrayProductos(), dto.getFileProductos(), idProducto, nombreProducto, loreProducto, precioProducto, imageAux)) {
                        ventanaPrincipal.getMensajes().mostrarInfo("El producto ha sido agregado correctamente.");
                    } else {
                        ventanaPrincipal.getMensajes().mostrarError("Ya existe un producto con esta ID.");
                    }
                } catch (NumberFormatException ex) {
                    ventanaPrincipal.getMensajes().mostrarError("Recuerde que los campos de ID y precio deben contener únicamente valores numéricos.");
                }
                break;
            case "IMAGEN_PRODUCTO":
                ventanaPrincipal.getPanelAdmin().getAgregarProductoPanel().getImagenButton().setIcon(cargarImagen());
                break;
        }
    }

    public ImageIcon cargarImagen() {
        FileDialog fileDialog = new FileDialog(ventanaPrincipal, "Seleccione una imagen", FileDialog.LOAD);
        fileDialog.show();

        if (fileDialog.getFile() == null) {
            ventanaPrincipal.getMensajes().mostrarError("No ha seleccionado ninguna imagen.");
            return new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/noImage.png/"))).getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH));
        } else {
            String ruta = (fileDialog.getDirectory() + fileDialog.getFile());
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage(ruta);
            imageAux = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            return imageAux;
        }
    }


    public void visibilidadOpcionesAdmin(String comando) {
        HashMap<String, JPanel> panelHashMap = new HashMap<>();
        panelHashMap.put("ADMINISTRAR_TIENDAS", ventanaPrincipal.getPanelAdmin().getOpcionesTiendas());
        panelHashMap.put("ADMINISTRAR_CLIENTES", ventanaPrincipal.getPanelAdmin().getOpcionesClientes());
        panelHashMap.put("ADMINISTRAR_PRODUCTOS", ventanaPrincipal.getPanelAdmin().getOpcionesProductos());
        panelHashMap.put("REGRESAR_PANEL_TIENDA", ventanaPrincipal.getPanelAdmin().getOpcionesTiendas());
        panelHashMap.put("REGRESAR_PANEL_CLIENTE", ventanaPrincipal.getPanelAdmin().getOpcionesClientes());
        panelHashMap.put("REGRESAR_PANEL_PRODUCTO", ventanaPrincipal.getPanelAdmin().getOpcionesProductos());

        boolean visibilidadPanelPrincipal = ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().isVisible();

        if (panelHashMap.containsKey(comando)) {
            panelHashMap.get(comando).setVisible(!panelHashMap.get(comando).isVisible());
            ventanaPrincipal.getPanelAdmin().getPanelAdminOpciones().setVisible(!visibilidadPanelPrincipal);
        }
    }

    public void iniciarSesion() {
        String usuario = ventanaPrincipal.getPanelPrincipal().getUsuarioField().getText();
        String clave = ventanaPrincipal.getPanelPrincipal().getClaveField().getText();

        if (usuario.equals("") || clave.equals("")) {
            ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nDebe ingresar su usuario y contraseña para poder iniciar sesión.");
        } else if (usuario.equals("A") && clave.equals("A")) {
            ventanaPrincipal.getPanelAdmin().setVisible(true);
        } else {
            if (dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario) != null) {
                if (dto.getDaoCliente().buscarCliente(dto.getArrayClientes(), usuario).getClave().equals(clave)) {
                    ventanaPrincipal.getDialogUsuario().setVisible(true);
                } else {
                    ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nLa contraseña ingresada es incorrecta, inténtelo de nuevo.");
                }
            } else {
                ventanaPrincipal.getMensajes().mostrarError("Estimado Cliente:\nEl usuario ingresado no está registrado.");
            }
        }
    }

    public void formatoFecha() {
        ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAnioNacimientoComboBox().removeAllItems();
        ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getMesNacimientoComboBox().removeAllItems();

        ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getAnioNacimientoComboBox().removeAllItems();
        ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getMesNacimientoComboBox().removeAllItems();

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("El anio actual es: " + anioActual);

        String[] mesesArray = DateFormatSymbols.getInstance().getMonths();
        for (String mes : mesesArray) {
            if (!mes.equals("")) {
                ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getMesNacimientoComboBox().addItem(mes.toUpperCase());
                ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getMesNacimientoComboBox().addItem(mes.toUpperCase());
            }
        }

        for (int i = anioActual; i >= (anioActual - 120); i--) {
            ventanaPrincipal.getPanelAdmin().getAgregarClientePanel().getAnioNacimientoComboBox().addItem(i);
            ventanaPrincipal.getPanelAdmin().getModificarClientePanel().getAnioNacimientoComboBox().addItem(i);
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
