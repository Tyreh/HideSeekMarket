package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelAdminOpcionesAvanzadas extends JPanel {

    private JButton agregarButton;

    private JButton buscarButton;

    private JButton modificarButton;

    private JButton eliminarButton;

    private JButton mostrarTodosButton;

    private JButton regresarButton;

    private final String auxComando;

    public PanelAdminOpcionesAvanzadas(String auxComando) {
        this.auxComando = auxComando;
        setLayout(new FlowLayout());
        init();
        setVisible(false);
    }

    public void init() {
        agregarButton = new JButton("<html><p style=\"text-align:center;\">Agregar <br>" + auxComando + "</p></html>");
        agregarButton.setActionCommand("AGREGAR_" + auxComando.toUpperCase());
        add(agregarButton);

        buscarButton = new JButton("<html><p style=\"text-align:center;\">Buscar <br>" + auxComando + "</p></html>");
        buscarButton.setActionCommand("BUSCAR_" + auxComando.toUpperCase());
        add(buscarButton);

        modificarButton = new JButton("<html><p style=\"text-align:center;\">Modificar <br>" + auxComando + "</p></html>");
        modificarButton.setActionCommand("MODIFICAR_" + auxComando.toUpperCase());
        add(modificarButton);

        eliminarButton = new JButton("<html><p style=\"text-align:center;\">Eliminar <br>" + auxComando + "</p></html>");
        eliminarButton.setActionCommand("ELIMINAR_" + auxComando.toUpperCase());
        add(eliminarButton);

        mostrarTodosButton = new JButton("<html><p style=\"text-align:center;\">Listado de <br>" + auxComando.toLowerCase() + "s</p></html>");
        mostrarTodosButton.setActionCommand("LISTADO_" + auxComando.toUpperCase());
        add(mostrarTodosButton);

        regresarButton = new JButton("<html><p style=\"text-align:center;\">Regresar</p></html>");
        regresarButton.setBackground(new Color(250, 128, 114));
        regresarButton.setForeground(Color.BLACK);
        regresarButton.setActionCommand("REGRESAR_PANEL_" + auxComando.toUpperCase());
        add(regresarButton);
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public void setAgregarButton(JButton agregarButton) {
        this.agregarButton = agregarButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(JButton buscarButton) {
        this.buscarButton = buscarButton;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public void setModificarButton(JButton modificarButton) {
        this.modificarButton = modificarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }

    public JButton getMostrarTodosButton() {
        return mostrarTodosButton;
    }

    public void setMostrarTodosButton(JButton mostrarTodosButton) {
        this.mostrarTodosButton = mostrarTodosButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }

    public void setRegresarButton(JButton regresarButton) {
        this.regresarButton = regresarButton;
    }
}
