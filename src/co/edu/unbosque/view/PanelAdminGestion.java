package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelAdminGestion extends JPanel {

    private JButton tiendas;

    private JButton clientes;

    private JButton productos;

    private JButton reportes;

    private JButton regresar;

    public PanelAdminGestion() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        init();
        setVisible(false);
    }

    public void init() {
        tiendas = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Tiendas</p></html>");
        tiendas.setBackground(new Color(138, 227, 138));
        tiendas.setForeground(Color.BLACK);
        tiendas.setActionCommand("TIENDA_ADMINISTRAR");
        add(tiendas);

        clientes = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Clientes</p></html>");
        clientes.setBackground(new Color(138, 227, 138));
        clientes.setForeground(Color.BLACK);
        clientes.setActionCommand("CLIENTE_ADMINISTRAR");
        add(clientes);

        productos = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Productos</p></html>");
        productos.setBackground(new Color(138, 227, 138));
        productos.setForeground(Color.BLACK);
        productos.setActionCommand("PRODUCTO_ADMINISTRAR");
        add(productos);

        reportes = new JButton("<html><p style=\"text-align:center;\">Generar<br>Reporte</p></html>");
        reportes.setBackground(new Color(138, 227, 138));
        reportes.setForeground(Color.BLACK);
        reportes.setActionCommand("GENERAR_REPORTE");
        add(reportes);

        regresar = new JButton("<html><p style=\"text-align:center;\">Regresar</p></html>");
        regresar.setBackground(new Color(250, 128, 114));
        regresar.setForeground(Color.BLACK);
        regresar.setActionCommand("REGRESAR_PANEL_ADMIN");
        add(regresar);
    }

    public JButton getTiendas() {
        return tiendas;
    }

    public void setTiendas(JButton tiendas) {
        this.tiendas = tiendas;
    }

    public JButton getClientes() {
        return clientes;
    }

    public void setClientes(JButton clientes) {
        this.clientes = clientes;
    }

    public JButton getProductos() {
        return productos;
    }

    public void setProductos(JButton productos) {
        this.productos = productos;
    }

    public JButton getReportes() {
        return reportes;
    }

    public void setReportes(JButton reportes) {
        this.reportes = reportes;
    }

    public JButton getRegresar() {
        return regresar;
    }

    public void setRegresar(JButton regresar) {
        this.regresar = regresar;
    }
}
