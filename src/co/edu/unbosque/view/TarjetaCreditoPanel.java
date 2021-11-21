package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TarjetaCreditoPanel extends JPanel {

    private ImageIcon imageAux;

    private JLabel labelAux;

    private Font font;

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
        font = new Font("Tahoma", Font.BOLD, 20);

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png/"))).getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(345, 10, 90, 90);
        labelAux.setIcon(imageAux);
        add(labelAux);

        labelAux = new JLabel("<html><p style=\"text-align:right;\">Banco<br>Los Arbolitos</p></html>");
        labelAux.setFont(font);
        labelAux.setForeground(Color.WHITE);
        labelAux.setBounds(220,30,200,40);
        add(labelAux);

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/creditCard/creditCardChip.png/"))).getImage().getScaledInstance(70,50,Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(30,70,70,50);
        labelAux.setIcon(imageAux);
        add(labelAux);

        font = new Font("Tahoma", Font.BOLD, 12);

        labelAux = new JLabel("CVV");
        labelAux.setBounds(30, 170, 100, 20);
        labelAux.setFont(font);
        labelAux.setForeground(Color.WHITE);
        add(labelAux);

        labelAux = new JLabel("MES / AÑO");
        labelAux.setBounds(210, 150, 100, 20);
        labelAux.setFont(font);
        labelAux.setForeground(Color.WHITE);
        add(labelAux);

        labelAux = new JLabel("<html>HASTA<br>THRU</html>");
        labelAux.setBounds(130, 180, 100, 30);
        labelAux.setFont(font);
        labelAux.setForeground(Color.WHITE);
        add(labelAux);

        imageAux = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/creditCard/creditCardVISA.png/"))).getImage().getScaledInstance(70,30,Image.SCALE_SMOOTH));
        labelAux = new JLabel();
        labelAux.setBounds(350,190,70,30);
        labelAux.setIcon(imageAux);
        add(labelAux);
    }
}
