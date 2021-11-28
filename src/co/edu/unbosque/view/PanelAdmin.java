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

    private PanelCliente agregarClientePanel;

    private PanelCliente modificarClientePanel;

    public PanelAdmin() {
        setLayout(null);
        setBackground(Color.RED);
        init();
        setVisible(false);
    }

    public void init() {
        font = new Font("Century Gothic", Font.BOLD, 13);

        panelAdminOpciones = new PanelAdminOpciones();
        panelAdminOpciones.setBounds(0, 0, 600, 50);
        add(panelAdminOpciones);

        opcionesClientes = new PanelAdminOpcionesAvanzadas("Cliente");
        opcionesClientes.setBounds(0, 0, 600, 50);
        add(opcionesClientes);

        opcionesProductos = new PanelAdminOpcionesAvanzadas("Producto");
        opcionesProductos.setBounds(0, 0, 600, 50);
        add(opcionesProductos);

        opcionesTiendas = new PanelAdminOpcionesAvanzadas("Tienda");
        opcionesTiendas.setBounds(0, 0, 600, 50);
        add(opcionesTiendas);

        agregarProductoPanel = new PanelProducto(false, "Agregar producto", "INGRESAR_PRODUCTO");
        agregarProductoPanel.setBounds(0,60,250,250);
        add(agregarProductoPanel);

        modificarProductoPanel = new PanelProducto(true, "Modificar producto", "INGRESAR_MODIFICACION_PRODUCTO");
        modificarProductoPanel.setBounds(0,60,250,250);
        add(modificarProductoPanel);

        agregarClientePanel = new PanelCliente(false, "Agregar cliente", "INGRESAR_REGISTRO");
        agregarClientePanel.setBounds(0,60,500,240);
        add(agregarClientePanel);

        modificarClientePanel = new PanelCliente(true, "Modificar cliente", "INGRESAR_MODIFICACION_CLIENTE");
        modificarClientePanel.setBounds(0,60,240,250);
        add(modificarClientePanel);
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
}