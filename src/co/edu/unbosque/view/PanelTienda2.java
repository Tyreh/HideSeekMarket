/*
package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelTienda extends JPanel {

    private JPanel panelFields;

    private JLabel label;

    private JTextField idTienda;

    private JComboBox<String> idComboBox;

    private JTextField ciudadField;

    private JTextField direccionField;

    private JButton agregarClienteButton;

    private final boolean edicionClientes;

    private final String textoBotonAceptar;

    private final String comando;

    public PanelTienda(boolean edicionClientes, String textoBotonAceptar, String comando) {
        this.textoBotonAceptar = textoBotonAceptar;
        this.edicionClientes = edicionClientes;
        this.comando = comando;
        setLayout(new GridLayout());
        init();
        setVisible(false);
    }

    public void init() {
        panelFields = new JPanel(new SpringLayout());

        label = new JLabel("ID: ", JLabel.TRAILING);
        panelFields.add(label);

        if (edicionClientes) {
            idComboBox = new JComboBox<>();
            label.setLabelFor(idComboBox);
            panelFields.add(idComboBox);
        } else {
            idTienda = new JTextField(10);
            label.setLabelFor(idTienda);
            panelFields.add(idTienda);
        }

        label = new JLabel("Ciudad: ", JLabel.TRAILING);
        panelFields.add(label);

        ciudadField = new JTextField(10);
        label.setLabelFor(ciudadField);
        panelFields.add(ciudadField);

        label = new JLabel("Dirección: ", JLabel.TRAILING);
        panelFields.add(label);

        direccionField = new JTextField(10);
        label.setLabelFor(direccionField);
        panelFields.add(direccionField);

        label = new JLabel("", JLabel.TRAILING);
        panelFields.add(label);

        agregarClienteButton = new JButton(textoBotonAceptar);
        agregarClienteButton.setActionCommand(comando);
        label.setLabelFor(agregarClienteButton);
        panelFields.add(agregarClienteButton);

        SpringUtilities.makeCompactGrid(panelFields, 4, 2, 0, 0, 5, 5);

        add(panelFields);
    }
}
*/
