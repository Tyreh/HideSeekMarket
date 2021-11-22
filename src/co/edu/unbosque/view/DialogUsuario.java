package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DialogUsuario extends JDialog {
    private JLabel disenioTarjeta;

    private JLabel binTarjeta;

    private JLabel fechaCaducidadTarjeta;

    private JLabel titularTarjeta;

    private JLabel CVVTarjeta;

    private Font font;

    private TarjetaCreditoPanel tarjetaCreditoPanel;

    private PanelBotonesUsuario panelBotonesUsuario;

    private ImageIcon fondo;

    private JLabel fondoLabel;

    public DialogUsuario() {
        setLayout(null);
        init();
        setVisible(false);
    }

    public void init() {
        font = new Font("Tahoma", Font.BOLD, 20);

        binTarjeta = new JLabel("XXXX XXXX XXXX XXXX");
        binTarjeta.setFont(font);
        binTarjeta.setForeground(Color.WHITE);
        binTarjeta.setBounds(320, 200, 200, 20);
        add(binTarjeta);

        tarjetaCreditoPanel = new TarjetaCreditoPanel();
        tarjetaCreditoPanel.setBounds(170, 35, 440, 230);
        add(tarjetaCreditoPanel);

        panelBotonesUsuario = new PanelBotonesUsuario();
        panelBotonesUsuario.setBounds(10, 300, 760, 40);
        add(panelBotonesUsuario);

        fondo = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondo.png/"))).getImage().getScaledInstance(800,390, Image.SCALE_SMOOTH));
        fondoLabel = new JLabel();
        fondoLabel.setIcon(fondo);
        fondoLabel.setBounds(0,0, 800,390);
        add(fondoLabel);
    }
}
