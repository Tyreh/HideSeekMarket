package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelUsuario extends JPanel {

    private JLabel disenioTarjeta;

    private JLabel binTarjeta;

    private JLabel fechaCaducidadTarjeta;

    private JLabel titularTarjeta;

    private JLabel CVVTarjeta;

    private Font font;

    private TarjetaCreditoPanel tarjetaCreditoPanel;

    private PanelBotonesUsuario panelBotonesUsuario;

    public PanelUsuario() {
        setLayout(null);
        init();
        setVisible(true);
    }

    public void init() {
        font = new Font("Tahoma", Font.BOLD, 20);

        binTarjeta = new JLabel("XXXX XXXX XXXX XXXX");
        binTarjeta.setFont(font);
        binTarjeta.setForeground(Color.WHITE);
        binTarjeta.setBounds(320,200, 200,20);
        add(binTarjeta);

        tarjetaCreditoPanel = new TarjetaCreditoPanel();
        tarjetaCreditoPanel.setBounds(155, 35, 440, 230);
        add(tarjetaCreditoPanel);

        panelBotonesUsuario = new PanelBotonesUsuario();
        panelBotonesUsuario.setBounds(10,300,730,40);
        add(panelBotonesUsuario);


    }
}
