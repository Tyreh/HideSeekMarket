package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class DialogUsuario extends JDialog {

    private JLabel disenioTarjeta;

    private JLabel binTarjeta;

    private JLabel fechaCaducidadTarjeta;

    private JLabel titularTarjeta;

    private JLabel CVVTarjeta;

    private Font font;

    private TarjetaCreditoPanel tarjetaCreditoPanel;

    private PanelAdminAccion acciones;

    private ImageIcon fondo;

    private JLabel fondoLabel;

    public DialogUsuario() {
        setLayout(null);
        init();
        setVisible(false);
    }

    public void init() {
        font = new Font("Tahoma", Font.BOLD, 20);

        tarjetaCreditoPanel = new TarjetaCreditoPanel();
        tarjetaCreditoPanel.setBounds(170, 35, 440, 230);
        add(tarjetaCreditoPanel);


    }

    public TarjetaCreditoPanel getTarjetaCreditoPanel() {
        return tarjetaCreditoPanel;
    }

    public void setTarjetaCreditoPanel(TarjetaCreditoPanel tarjetaCreditoPanel) {
        this.tarjetaCreditoPanel = tarjetaCreditoPanel;
    }
}