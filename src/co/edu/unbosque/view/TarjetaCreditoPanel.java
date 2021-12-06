package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TarjetaCreditoPanel extends JPanel {

    private ImageIcon imageAux;

    private JLabel labelAux;

    private JLabel saldo;

    private JLabel bin;

    private JLabel cvv;


    public TarjetaCreditoPanel() {
        setLayout(null);
        setOpaque(false);
        init();
        setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(20, 20);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(new Color(58,166,164));
        graphics2D.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics2D.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }

    public void init() {

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png/"))).getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(345, 10, 90, 90);
        labelAux.setIcon(imageAux);
        add(labelAux);

        labelAux = new JLabel("<html><p style=\"text-align:right;\">Banco<br>Los Arbolitos</p></html>");
        labelAux.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelAux.setForeground(Color.WHITE);
        labelAux.setBounds(220,30,200,40);
        add(labelAux);

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/creditCard/creditCardChip.png/"))).getImage().getScaledInstance(70,50,Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(30,70,70,50);
        labelAux.setIcon(imageAux);
        add(labelAux);

        bin = new JLabel("XXXX XXXX XXXX XXXX");
        bin.setBounds(30, 170, 300, 20);
        bin.setFont(new Font("Tahoma", Font.BOLD, 25));
        bin.setForeground(Color.WHITE);
        add(bin);

        cvv = new JLabel("CVV");
        cvv.setBounds(30, 190, 100, 20);
        cvv.setFont(new Font("Tahoma", Font.BOLD, 12));
        cvv.setForeground(Color.WHITE);
        add(cvv);

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/creditCard/creditCardVISA.png/"))).getImage().getScaledInstance(70,30,Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(350,190,70,30);
        labelAux.setIcon(imageAux);
        add(labelAux);
    }

    public JLabel getBin() {
        return bin;
    }

    public void setBin(JLabel bin) {
        this.bin = bin;
    }

    public JLabel getCvv() {
        return cvv;
    }

    public void setCvv(JLabel cvv) {
        this.cvv = cvv;
    }
}
