package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelAdmin extends JPanel {

    private PanelProducto agregarProducto;

    private PanelProducto buscarProducto;

    private PanelProducto modificarProducto;

    private PanelProducto listadoProducto;

    private PanelProducto eliminarProducto;

    private PanelCliente agregarCliente;

    private PanelCliente buscarCliente;

    private PanelCliente modificarCliente;

    private PanelCliente eliminarCliente;

    private PanelCliente listadoCliente;

    private PanelTienda agregarTienda;

    private PanelTienda buscarTienda;

    private PanelTienda modificarTienda;

    private PanelTienda eliminarTienda;

    private PanelTienda listadoTienda;

    public PanelAdmin() {
        setLayout(new BorderLayout());
        init();
        setVisible(false);
    }

    public void init() {
        agregarCliente = new PanelCliente("AGREGAR", "Agregar cliente");
        buscarCliente = new PanelCliente("BUSCAR", "Buscar cliente");
        modificarCliente = new PanelCliente("MODIFICAR", "Modificar cliente");
        eliminarCliente = new PanelCliente("ELIMINAR", "Eliminar cliente");
        listadoCliente = new PanelCliente("LISTADO");

        agregarProducto = new PanelProducto("AGREGAR", "Agregar producto");
        buscarProducto = new PanelProducto("BUSCAR", "Buscar producto");
        modificarProducto = new PanelProducto("MODIFICAR", "Modificar producto");
        eliminarProducto = new PanelProducto("ELIMINAR", "Eliminar producto");
        listadoProducto = new PanelProducto("LISTADO");

        agregarTienda = new PanelTienda("AGREGAR", "Agregar tienda");
        buscarTienda = new PanelTienda("BUSCAR", "Buscar tienda");
        modificarTienda = new PanelTienda("MODIFICAR", "Modificar tienda");
        eliminarTienda = new PanelTienda("ELIMINAR", "Eliminar tienda");
        listadoTienda = new PanelTienda("LISTADO");
    }

    public PanelProducto getAgregarProducto() {
        return agregarProducto;
    }

    public PanelProducto getModificarProducto() {
        return modificarProducto;
    }

    public PanelProducto getListadoProducto() {
        return listadoProducto;
    }

    public PanelCliente getAgregarCliente() {
        return agregarCliente;
    }

    public PanelCliente getModificarCliente() {
        return modificarCliente;
    }

    public PanelCliente getListadoCliente() {
        return listadoCliente;
    }

    public PanelTienda getAgregarTienda() {
        return agregarTienda;
    }

    public PanelTienda getModificarTienda() {
        return modificarTienda;
    }

    public PanelProducto getEliminarProducto() {
        return eliminarProducto;
    }

    public PanelProducto getBuscarProducto() {
        return buscarProducto;
    }

    public PanelTienda getBuscarTienda() {
        return buscarTienda;
    }

    public PanelTienda getEliminarTienda() {
        return eliminarTienda;
    }

    public PanelTienda getListadoTienda() {
        return listadoTienda;
    }

    public PanelCliente getBuscarCliente() {
        return buscarCliente;
    }

    public PanelCliente getEliminarCliente() {
        return eliminarCliente;
    }
}