package co.edu.unbosque.view;

import javax.swing.*;

public class Mensajes {

    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Proyecto", JOptionPane.INFORMATION_MESSAGE);
    }

    public String pedirDatoString(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Proyecto", JOptionPane.INFORMATION_MESSAGE);
    }

    public int pedirDatoInteger(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, "Proyecto", JOptionPane.INFORMATION_MESSAGE));
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Proyecto", JOptionPane.ERROR_MESSAGE);
    }
}
