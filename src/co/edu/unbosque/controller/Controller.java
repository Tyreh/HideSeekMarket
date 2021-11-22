package co.edu.unbosque.controller;

import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;

    public Controller() {
        ventanaPrincipal = new VentanaPrincipal();
    }

    public void listeners() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
    }
}
