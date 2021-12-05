package co.edu.unbosque.view;

import co.edu.unbosque.model.Producto;
import com.sun.jdi.PrimitiveValue;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private PanelUsuario panelUsuario;

    private DialogRegistro dialogRegistro;

    private PanelAdmin panelAdmin;

    private PanelPrincipal panelPrincipal;

    private ListaProductos listaProductos;

    private JScrollPane scrollProductos;

    private PanelAdminGestion panelAdminGestion;

    private Mensajes mensajes;

    private final ArrayList<Producto> productoArrayList;

    private PagarCarrito pagarCarrito;


    public VentanaPrincipal(ArrayList<Producto> productoArrayList) {
        this.productoArrayList = productoArrayList;
        setTitle("Proyecto");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        init();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void init() {
        panelPrincipal = new PanelPrincipal();
        add(panelPrincipal, BorderLayout.NORTH);

        listaProductos = new ListaProductos(productoArrayList);
        scrollProductos = new JScrollPane(listaProductos);
        add(scrollProductos, BorderLayout.CENTER);

        pagarCarrito = new PagarCarrito(productoArrayList);
        pagarCarrito.setBounds(0, 0, 560, 450);
        //add(pagarCarrito, BorderLayout.LINE_START);

        panelAdminGestion = new PanelAdminGestion();

        panelAdmin = new PanelAdmin();

        mensajes = new Mensajes();
    }

    public PanelAdmin getPanelAdmin() {
        return panelAdmin;
    }

    public void setPanelAdmin(PanelAdmin panelAdmin) {
        this.panelAdmin = panelAdmin;
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

    public JScrollPane getScrollProductos() {
        return scrollProductos;
    }

    public PanelUsuario getPanelUsuario() {
        return panelUsuario;
    }

    public PanelAdminGestion getPanelAdminGestion() {
        return panelAdminGestion;
    }

    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    public PagarCarrito getPagarCarrito() {
        return pagarCarrito;
    }


}

