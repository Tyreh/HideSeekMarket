package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelAdmin extends JPanel {

    private Font font;

    private PanelAdminOpciones panelAdminOpciones;

    private PanelAdminOpcionesAvanzadas opcionesClientes;

    private PanelAdminOpcionesAvanzadas opcionesProductos;

    private PanelAdminOpcionesAvanzadas opcionesTiendas;

    private PanelProducto agregarProductoPanel;

    private PanelProducto modificarProductoPanel;

    private PanelProducto listadoProductoPanel;

    private PanelCliente agregarClientePanel;

    private PanelCliente modificarClientePanel;

    private PanelCliente listadoClientePanel;

    private PanelTienda agregarTiendaPanel;

    private PanelTienda modificarTiendaPanel;

    public PanelAdmin() {
        setLayout(new BorderLayout());
        setBackground(Color.RED);
        init();
        setVisible(false);
    }

    public void init() {
        font = new Font("Century Gothic", Font.BOLD, 13);

        panelAdminOpciones = new PanelAdminOpciones();
        //panelAdminOpciones.setBounds(0, 0, 600, 50);
        add(panelAdminOpciones, BorderLayout.NORTH);

        opcionesClientes = new PanelAdminOpcionesAvanzadas("Cliente");
       // opcionesClientes.setBounds(0, 0, 600, 50);
        //add(opcionesClientes);

        opcionesProductos = new PanelAdminOpcionesAvanzadas("Producto");
        //opcionesProductos.setBounds(0, 0, 600, 50);
        //add(opcionesProductos);

        opcionesTiendas = new PanelAdminOpcionesAvanzadas("Tienda");
        opcionesTiendas.setBounds(0, 0, 600, 50);
        //add(opcionesTiendas);

        agregarProductoPanel = new PanelProducto("AGREGAR", "Agregar producto", "INGRESAR_PRODUCTO");
        //agregarProductoPanel.setBounds(0,60,250,250);
//        add(agregarProductoPanel);

        modificarProductoPanel = new PanelProducto("MODIFICAR", "Modificar producto", "INGRESAR_MODIFICACION_PRODUCTO");
        listadoProductoPanel = new PanelProducto("LISTADO");
        //modificarProductoPanel.setBounds(0,60,250,250);
//        add(modificarProductoPanel);

        agregarClientePanel = new PanelCliente("AGREGAR", "Agregar cliente", "INGRESAR_REGISTRO");
        //agregarClientePanel.setBounds(0,60,500,240);
//        add(agregarClientePanel);

        modificarClientePanel = new PanelCliente("MODIFICAR", "Modificar cliente", "INGRESAR_MODIFICACION_CLIENTE");
        listadoClientePanel = new PanelCliente("LISTADO");
        //modificarClientePanel.setBounds(0,60,240,250);
//        add(modificarClientePanel);

        agregarTiendaPanel = new PanelTienda(false, "Agregar tienda", "INGRESAR_TIENDA");
       // agregarTiendaPanel.setBounds(0,60,240,250);
//        add(agregarTiendaPanel);

        modificarTiendaPanel = new PanelTienda(true, "Modificar tienda", "INGRESAR_MODIFICACION_PRODUCTO");
       // modificarTiendaPanel.setBounds(0,60,240,250);
//        add(modificarTiendaPanel);
    }

    public PanelAdminOpciones getPanelAdminOpciones() {
        return panelAdminOpciones;
    }

    public void setPanelAdminOpciones(PanelAdminOpciones panelAdminOpciones) {
        this.panelAdminOpciones = panelAdminOpciones;
    }

    public PanelAdminOpcionesAvanzadas getOpcionesClientes() {
        return opcionesClientes;
    }

    public void setOpcionesClientes(PanelAdminOpcionesAvanzadas opcionesClientes) {
        this.opcionesClientes = opcionesClientes;
    }

    public PanelAdminOpcionesAvanzadas getOpcionesProductos() {
        return opcionesProductos;
    }

    public void setOpcionesProductos(PanelAdminOpcionesAvanzadas opcionesProductos) {
        this.opcionesProductos = opcionesProductos;
    }

    public PanelAdminOpcionesAvanzadas getOpcionesTiendas() {
        return opcionesTiendas;
    }

    public void setOpcionesTiendas(PanelAdminOpcionesAvanzadas opcionesTiendas) {
        this.opcionesTiendas = opcionesTiendas;
    }

    public PanelProducto getAgregarProductoPanel() {
        return agregarProductoPanel;
    }

    public void setAgregarProductoPanel(PanelProducto agregarProductoPanel) {
        this.agregarProductoPanel = agregarProductoPanel;
    }

    public PanelProducto getModificarProductoPanel() {
        return modificarProductoPanel;
    }

    public void setModificarProductoPanel(PanelProducto modificarProductoPanel) {
        this.modificarProductoPanel = modificarProductoPanel;
    }

    public PanelCliente getAgregarClientePanel() {
        return agregarClientePanel;
    }

    public void setAgregarClientePanel(PanelCliente agregarClientePanel) {
        this.agregarClientePanel = agregarClientePanel;
    }

    public PanelCliente getModificarClientePanel() {
        return modificarClientePanel;
    }

    public void setModificarClientePanel(PanelCliente modificarClientePanel) {
        this.modificarClientePanel = modificarClientePanel;
    }

    public PanelTienda getAgregarTiendaPanel() {
        return agregarTiendaPanel;
    }

    public void setAgregarTiendaPanel(PanelTienda agregarTiendaPanel) {
        this.agregarTiendaPanel = agregarTiendaPanel;
    }

    public PanelTienda getModificarTiendaPanel() {
        return modificarTiendaPanel;
    }

    public void setModificarTiendaPanel(PanelTienda modificarTiendaPanel) {
        this.modificarTiendaPanel = modificarTiendaPanel;
    }

    public PanelProducto getListadoProductoPanel() {
        return listadoProductoPanel;
    }

    public void setListadoProductoPanel(PanelProducto listadoProductoPanel) {
        this.listadoProductoPanel = listadoProductoPanel;
    }

    public PanelCliente getListadoClientePanel() {
        return listadoClientePanel;
    }

    public void setListadoClientePanel(PanelCliente listadoClientePanel) {
        this.listadoClientePanel = listadoClientePanel;
    }
}