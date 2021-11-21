package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelBotonesUsuario extends JPanel {

    private JButton verParejasButton;

    private JButton agregarParejaButton;

    private JButton eliminarParejaButton;

    private JButton adminParejasButton;

    private JButton consultarSaldoButton;

    public PanelBotonesUsuario() {
        setLayout(new GridLayout());
        init();
        setVisible(true);
    }

    public void init() {

        consultarSaldoButton = new JButton("Consultar saldo");
        consultarSaldoButton.setActionCommand("VER_PAREJAS");
        add(consultarSaldoButton);

        verParejasButton = new JButton("Ver parejas");
        verParejasButton.setActionCommand("VER_PAREJAS");
        add(verParejasButton);

        agregarParejaButton = new JButton("Nueva pareja");
        agregarParejaButton.setActionCommand("AGREGAR_PAREJA");
        add(agregarParejaButton);

        eliminarParejaButton = new JButton("Eliminar pareja");
        eliminarParejaButton.setActionCommand("ELIMINAR_PAREJA");
        add(eliminarParejaButton);

        adminParejasButton = new JButton("Administrar parejas");
        adminParejasButton.setActionCommand("ADMIN_PAREJAS");
        add(adminParejasButton);
    }
}
