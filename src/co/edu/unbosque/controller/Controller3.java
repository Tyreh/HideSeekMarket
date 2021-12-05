/*
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Dto;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.view.ProductoManager;
import co.edu.unbosque.view.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
    private VentanaPrincipal ventana;

    private Dto dto;


    public Controller() {
        dto = new Dto();
        ventana = new VentanaPrincipal(dto.getArrayProductos());
        listeners();
    }

    public void listeners() {
        ventana.getPanelPrincipal().getIniciarSesion().addActionListener(this);
        ventana.getPanelPrincipal().getRegistrarse().addActionListener(this);
        ventana.getPanelPrincipal().getPagar().addActionListener(this);

        ventana.getPanelAdminGestion().getProductos().addActionListener(this);
        ventana.getPanelAdminGestion().getClientes().addActionListener(this);
        ventana.getPanelAdminGestion().getTiendas().addActionListener(this);
        ventana.getPanelAdminGestion().getReportes().addActionListener(this);
        ventana.getPanelAdminGestion().getRegresar().addActionListener(this);

        ventana.getPanelPrincipal().getPanelAdminGestion().getTiendas().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getClientes().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getProductos().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getReportes().addActionListener(this);
        ventana.getPanelPrincipal().getPanelAdminGestion().getRegresar().addActionListener(this);

        for (ProductoManager panel : ventana.getListaProductos().getProductoManagers()) {
            panel.getAgregar().addActionListener(this);
            panel.getRemover().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println(comando);

        if (comando.contains("ADMINISTRAR")) {
            switch (comando) {
                case "ADMINISTRAR_CLIENTES":
//                    ventana.remove(ventana.getPanelPrincipal());
//                    ventana.remove(ventana.getScrollProductos());
//                    ventana.add(ventana.getPanelAdmin(), BorderLayout.CENTER);
*/
/*                    ventana.getPanelPrincipal().getPanelCarrito().setVisible(false);
                    ventana.getPanelPrincipal().getPanelSesion().setVisible(false);
                    ventana.getPanelPrincipal().add(ventana.getPanelAdmin());
                    ventana.getPanelPrincipal().getPanelAdmin().setVisible(true);*//*

                    // ventana.getPanelAdmin().setVisible(true);
                    break;
                case "ADMINISTRAR_PRODUCTOS":
                    break;
                case "ADMINISTRAR_TIENDAS":
                    break;

            }
        } else if (comando.contains("PRINCIPAL")) {
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
                            ventana.add(ventana.getPanelAdmin(), BorderLayout.NORTH);
                            ventana.getPanelAdmin().setVisible(true);
                            ventana.getPanelPrincipal().getPanelCarrito().setVisible(false);
                            ventana.getPanelPrincipal().getPanelSesion().setVisible(false);
//                            ventana.getPanelPrincipal().add(ventana.getPanelPrincipal().getPanelAdminGestion());
                            ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(true);
                            ventana.setSize(1200,500);
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
*/
/*                        ventana.remove(ventana.getScrollProductos());
                        ventana.setSize(600,300);
                        ventana.add(ventana.getPagarCarrito(), BorderLayout.CENTER);*//*

                        ventana.getPagarCarrito().setVisible(true);
                        ventana.getPagarCarrito().setLocationRelativeTo(null);
                    } else {
                        ventana.getMensajes().mostrarError("El carrito no puede estar vacío.");
                    }
                    break;
            }
        } else if (comando.contains("CLIENTE")) {

        } else if (comando.contains("PRODUCTO")) {
            switch (comando) {
                case "PRODUCTO_ADMINISTRAR":
                    ventana.getPanelPrincipal().getPanelAdminGestion().setVisible(false);
                    ventana.getPanelPrincipal().getAccionesProducto().setVisible(true);
                    break;
            }

            if (comando.contains("AGREGAR") || comando.contains("REMOVER")) {
                for (Producto producto : dto.getArrayProductos()) {
                    if (comando.equals("AGREGAR_PRODUCTO_" + producto.getIdProducto())) {
                        dto.getArrayProductosCarrito().add(producto);
                        ventana.getPanelPrincipal().getCarrito().setText("Tienes " + dto.getArrayProductosCarrito().size() + " productos en el carrito");

                        // REMEMBER TO REMOVE IT
                        System.out.println("DEBUG");
                        System.out.println(dto.getArrayProductosCarrito());
                        System.out.println("=======================================");
                        System.out.println("=======================================");
                        System.out.println("=======================================");
                        // THIS
                        break;
                    } else if (comando.equals("REMOVER_PRODUCTO_" + producto.getIdProducto())) {
                        dto.getArrayProductosCarrito().remove(producto);

                        // REMEMBER TO REMOVE IT
                        System.out.println("DEBUG");
                        ventana.getPanelPrincipal().getCarrito().setText("Tienes " + dto.getArrayProductosCarrito().size() + " productos en el carrito");
                        System.out.println(dto.getArrayProductosCarrito());
                        System.out.println("=======================================");
                        System.out.println("=======================================");
                        System.out.println("=======================================");
                        // THIS
                        break;
                    }
                }
            }

        } else if (comando.contains("TIENDA")) {

        }

    }

    public void visibilidadPaneles(JPanel agregarPanel, JPanel modificarPanel, JPanel listadoPanel, JPanel panelVisible) {
        agregarPanel.setVisible(false);
        modificarPanel.setVisible(false);
        listadoPanel.setVisible(false);

        ventana.getPanelAdmin().remove(agregarPanel);
        ventana.getPanelAdmin().remove(modificarPanel);
        ventana.getPanelAdmin().remove(listadoPanel);

        if (panelVisible != null) {
            ventana.getPanelAdmin().add(panelVisible, BorderLayout.CENTER);
            panelVisible.setVisible(true);
        }
    }
}
*/
