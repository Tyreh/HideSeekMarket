package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private JPanel panelCarrito;

    private JPanel panelSesion;

    private JLabel auxLabel;

    private JLabel carrito;

    private JTextField usuario;

    private JTextField clave;

    private JButton iniciarSesion;

    private JButton registrarse;

    private JButton pagar;

    private PanelAdminGestion panelAdminGestion;

    private PanelAdminAccion accionesCliente;

    private PanelAdminAccion accionesProducto;

    private PanelAdminAccion accionesTienda;

    private PanelAdminAccion accionesUsuario;

    public PanelPrincipal() {
        setLayout(new FlowLayout());
        setBackground(new Color(214, 81, 67));
        setVisible(true);
        init();
    }

    public void init() {
        panelAdminGestion = new PanelAdminGestion();
        add(panelAdminGestion);
        add(carritoPanel());
        add(sesionPanel());

        accionesCliente = new PanelAdminAccion("Cliente", false);
        accionesProducto = new PanelAdminAccion("Producto", false);
        accionesTienda = new PanelAdminAccion("Tienda", false);
        accionesUsuario = new PanelAdminAccion("Pareja", true);
    }

    public JPanel carritoPanel() {
        panelCarrito = new JPanel(new GridLayout(2, 1, 2, 2));
        panelCarrito.setOpaque(false);

        carrito = new JLabel("Tienes 0 productos en el carrito");
        carrito.setFont(new Font("Arial", Font.BOLD, 14));
        carrito.setForeground(Color.WHITE);
        panelCarrito.add(carrito);

        pagar = new JButton("Pagar");
        pagar.setActionCommand("PRINCIPAL_PAGAR");
        panelCarrito.add(pagar);

        return panelCarrito;
    }

    public JPanel sesionPanel() {
        panelSesion = new JPanel(new GridLayout(3, 2, 2, 4));
        panelSesion.setOpaque(false);

        JPanel botones = new JPanel(new GridLayout(1, 2, 2, 0));
        botones.setOpaque(false);

        registrarse = new JButton("Registrarse");
        registrarse.setActionCommand("PRINCIPAL_REGISTRARSE");
        botones.add(registrarse);

        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setActionCommand("PRINCIPAL_INICIAR_SESION");
        botones.add(iniciarSesion);

        auxLabel = new JLabel("Usuario: ", SwingConstants.RIGHT);
        auxLabel.setFont(new Font("Arial", Font.BOLD, 14));
        auxLabel.setForeground(Color.WHITE);
        panelSesion.add(auxLabel);

        usuario = new JTextField(15);
        usuario.setFont(new Font("Arial", Font.BOLD, 14));
        panelSesion.add(usuario);

        auxLabel = new JLabel("Clave: ", SwingConstants.RIGHT);
        auxLabel.setFont(new Font("Arial", Font.BOLD, 14));
        auxLabel.setForeground(Color.WHITE);
        panelSesion.add(auxLabel);

        clave = new JPasswordField(15);
        clave.setFont(new Font("Arial", Font.BOLD, 14));
        panelSesion.add(clave);

        auxLabel = new JLabel("");
        panelSesion.add(auxLabel);

        panelSesion.add(botones);

        return panelSesion;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JTextField getClave() {
        return clave;
    }

    public void setClave(JTextField clave) {
        this.clave = clave;
    }

    public JButton getIniciarSesion() {
        return iniciarSesion;
    }

    public void setIniciarSesion(JButton iniciarSesion) {
        this.iniciarSesion = iniciarSesion;
    }

    public JButton getRegistrarse() {
        return registrarse;
    }

    public void setRegistrarse(JButton registrarse) {
        this.registrarse = registrarse;
    }

    public JButton getPagar() {
        return pagar;
    }

    public void setPagar(JButton pagar) {
        this.pagar = pagar;
    }

    public JLabel getCarrito() {
        return carrito;
    }

    public void setCarrito(JLabel carrito) {
        this.carrito = carrito;
    }

    public PanelAdminGestion getPanelAdminGestion() {
        return panelAdminGestion;
    }

    public void setPanelAdminGestion(PanelAdminGestion panelAdminGestion) {
        this.panelAdminGestion = panelAdminGestion;
    }

    public JPanel getPanelCarrito() {
        return panelCarrito;
    }

    public void setPanelCarrito(JPanel panelCarrito) {
        this.panelCarrito = panelCarrito;
    }

    public JPanel getPanelSesion() {
        return panelSesion;
    }

    public void setPanelSesion(JPanel panelSesion) {
        this.panelSesion = panelSesion;
    }

    public PanelAdminAccion getAccionesCliente() {
        return accionesCliente;
    }

    public void setAccionesCliente(PanelAdminAccion accionesCliente) {
        this.accionesCliente = accionesCliente;
    }

    public PanelAdminAccion getAccionesProducto() {
        return accionesProducto;
    }

    public void setAccionesProducto(PanelAdminAccion accionesProducto) {
        this.accionesProducto = accionesProducto;
    }

    public PanelAdminAccion getAccionesTienda() {
        return accionesTienda;
    }

    public void setAccionesTienda(PanelAdminAccion accionesTienda) {
        this.accionesTienda = accionesTienda;
    }

    public PanelAdminAccion getAccionesUsuario() {
        return accionesUsuario;
    }
}
