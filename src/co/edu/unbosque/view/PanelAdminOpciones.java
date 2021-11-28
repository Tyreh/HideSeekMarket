package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelAdminOpciones extends JPanel {

    private JButton tiendasButton;

    private JButton clientesButton;

    private JButton productosButton;

    private JButton reportesButton;

    private JButton regresarButton;

    private Font font;

    public PanelAdminOpciones() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        init();
        setVisible(true);
    }

    public void init() {
        font = new Font("Century Gothic", Font.BOLD, 13);

        tiendasButton = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Tiendas</p></html>");
        tiendasButton.setBackground(new Color(138, 227, 138));
        tiendasButton.setForeground(Color.BLACK);
        tiendasButton.setActionCommand("ADMINISTRAR_TIENDAS");
        add(tiendasButton);

        clientesButton = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Clientes</p></html>");
        clientesButton.setBackground(new Color(138, 227, 138));
        clientesButton.setForeground(Color.BLACK);
        clientesButton.setActionCommand("ADMINISTRAR_CLIENTES");
        add(clientesButton);

        productosButton = new JButton("<html><p style=\"text-align:center;\">Administrar<br>Productos</p></html>");
        productosButton.setBackground(new Color(138, 227, 138));
        productosButton.setForeground(Color.BLACK);
        productosButton.setActionCommand("ADMINISTRAR_PRODUCTOS");
        add(productosButton);

        reportesButton = new JButton("<html><p style=\"text-align:center;\">Generar<br>Reporte</p></html>");
        reportesButton.setBackground(new Color(138, 227, 138));
        reportesButton.setForeground(Color.BLACK);
        reportesButton.setActionCommand("GENERAR_REPORTE");
        add(reportesButton);

        regresarButton = new JButton("<html><p style=\"text-align:center;\">Regresar</p></html>");
        regresarButton.setBackground(new Color(250, 128, 114));
        regresarButton.setForeground(Color.BLACK);
        regresarButton.setActionCommand("REGRESAR_PANEL_ADMIN");
        add(regresarButton);

    }

    public JButton getTiendasButton() {
        return tiendasButton;
    }

    public void setTiendasButton(JButton tiendasButton) {
        this.tiendasButton = tiendasButton;
    }

    public JButton getClientesButton() {
        return clientesButton;
    }

    public void setClientesButton(JButton clientesButton) {
        this.clientesButton = clientesButton;
    }

    public JButton getProductosButton() {
        return productosButton;
    }

    public void setProductosButton(JButton productosButton) {
        this.productosButton = productosButton;
    }

    public JButton getReportesButton() {
        return reportesButton;
    }

    public void setReportesButton(JButton reportesButton) {
        this.reportesButton = reportesButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }

    public void setRegresarButton(JButton regresarButton) {
        this.regresarButton = regresarButton;
    }
}
