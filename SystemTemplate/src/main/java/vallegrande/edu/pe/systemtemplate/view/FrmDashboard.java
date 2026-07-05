package vallegrande.edu.pe.systemtemplate.view;

import java.awt.*;
import javax.swing.*;

import vallegrande.edu.pe.systemtemplate.view.components.CardPanel;

public class FrmDashboard extends JFrame {

    //=========================================
    // LABELS
    //=========================================

    public JLabel lblTitulo;
    public JLabel lblBienvenido;
    public JLabel lblEstado;
    public JLabel lblVersion;

    //=========================================
    // DESKTOP
    //=========================================

    public JDesktopPane desktop;

    //=========================================
    // MENU
    //=========================================

    public JMenuBar menuBar;

    public JMenu menuArchivo;
    public JMenu menuMantenimientos;
    public JMenu menuOperaciones;
    public JMenu menuReportes;
    public JMenu menuSeguridad;

    //=========================================
    // MENU ITEMS
    //=========================================

    public JMenuItem itemSalir;

    public JMenuItem itemCategoria;
    public JMenuItem itemProducto;
    public JMenuItem itemCliente;
    public JMenuItem itemProveedor;
    public JMenuItem itemEmpleado;

    public JMenuItem itemCompra;
    public JMenuItem itemVenta;

    public JMenuItem itemReporteProductos;
    public JMenuItem itemReporteCompras;
    public JMenuItem itemReporteVentas;
    public JMenuItem itemReporteInventario;

    public JMenuItem itemUsuarios;
    public JMenuItem itemRoles;
    public JMenuItem itemCerrarSesion;

    //=========================================
    // CARDS
    //=========================================

    public CardPanel cardProductos;
    public CardPanel cardClientes;
    public CardPanel cardCompras;
    public CardPanel cardVentas;
    public CardPanel cardUsuarios;
    public CardPanel cardCategorias;

    //=========================================
    // PANELES
    //=========================================

    private JPanel panelSuperior;
    private JPanel panelCards;
    private JPanel panelCentral;
    private JPanel panelEstado;

    //=========================================

    public FrmDashboard() {

        iniciarComponentes();

    }

    private void iniciarComponentes() {

        setTitle("SystemTemplate");

        setSize(1300,750);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //=========================================
        // MENU
        //=========================================

        menuBar = new JMenuBar();

        menuArchivo = new JMenu("Archivo");
        menuMantenimientos = new JMenu("Mantenimientos");
        menuOperaciones = new JMenu("Operaciones");
        menuReportes = new JMenu("Reportes");
        menuSeguridad = new JMenu("Seguridad");

        itemSalir = new JMenuItem("Salir");

        itemCategoria = new JMenuItem("Categorías");
        itemProducto = new JMenuItem("Productos");
        itemCliente = new JMenuItem("Clientes");
        itemProveedor = new JMenuItem("Proveedores");
        itemEmpleado = new JMenuItem("Empleados");

        itemCompra = new JMenuItem("Compras");
        itemVenta = new JMenuItem("Ventas");

        itemReporteProductos = new JMenuItem("Productos");
        itemReporteCompras = new JMenuItem("Compras");
        itemReporteVentas = new JMenuItem("Ventas");
        itemReporteInventario = new JMenuItem("Inventario");

        itemUsuarios = new JMenuItem("Usuarios");
        itemRoles = new JMenuItem("Roles");
        itemCerrarSesion = new JMenuItem("Cerrar Sesión");

        menuArchivo.add(itemSalir);

        menuMantenimientos.add(itemCategoria);
        menuMantenimientos.add(itemProducto);
        menuMantenimientos.add(itemCliente);
        menuMantenimientos.add(itemProveedor);
        menuMantenimientos.add(itemEmpleado);

        menuOperaciones.add(itemCompra);
        menuOperaciones.add(itemVenta);

        menuReportes.add(itemReporteProductos);
        menuReportes.add(itemReporteCompras);
        menuReportes.add(itemReporteVentas);
        menuReportes.add(itemReporteInventario);

        menuSeguridad.add(itemUsuarios);
        menuSeguridad.add(itemRoles);
        menuSeguridad.addSeparator();
        menuSeguridad.add(itemCerrarSesion);

        menuBar.add(menuArchivo);
        menuBar.add(menuMantenimientos);
        menuBar.add(menuOperaciones);
        menuBar.add(menuReportes);
        menuBar.add(menuSeguridad);

        setJMenuBar(menuBar);

        //=========================================
        // PANEL SUPERIOR
        //=========================================

        panelSuperior = new JPanel();

        panelSuperior.setLayout(new GridLayout(2,1));

        lblTitulo = new JLabel("SYSTEM TEMPLATE");

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Segoe UI",Font.BOLD,30));

        lblBienvenido = new JLabel("Bienvenido");

        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);

        lblBienvenido.setFont(new Font("Segoe UI",Font.PLAIN,18));

        panelSuperior.add(lblTitulo);

        panelSuperior.add(lblBienvenido);

        //=========================================
        // CARDS
        //=========================================

        panelCards = new JPanel();

        panelCards.setBorder(
                BorderFactory.createEmptyBorder(10,10,10,10));

        panelCards.setLayout(new GridLayout(2,3,15,15));

        cardProductos = new CardPanel("Productos","0");
        cardProductos.setDescripcion("Registrados");

        cardClientes = new CardPanel("Clientes","0");
        cardClientes.setDescripcion("Registrados");

        cardCompras = new CardPanel("Compras","0");
        cardCompras.setDescripcion("Realizadas");

        cardVentas = new CardPanel("Ventas","0");
        cardVentas.setDescripcion("Realizadas");

        cardUsuarios = new CardPanel("Usuarios","0");
        cardUsuarios.setDescripcion("Activos");

        cardCategorias = new CardPanel("Categorías","0");
        cardCategorias.setDescripcion("Disponibles");

        panelCards.add(cardProductos);
        panelCards.add(cardClientes);
        panelCards.add(cardCompras);
        panelCards.add(cardVentas);
        panelCards.add(cardUsuarios);
        panelCards.add(cardCategorias);

        //=========================================
        // DESKTOP
        //=========================================

        desktop = new JDesktopPane();

        desktop.setBackground(new Color(240,240,240));

        desktop.setBorder(
                BorderFactory.createTitledBorder("Área de trabajo"));

        //=========================================
        // PANEL CENTRAL
        //=========================================

        panelCentral = new JPanel();

        panelCentral.setLayout(new BorderLayout(10,10));

        panelCentral.setBorder(
                BorderFactory.createEmptyBorder(10,10,10,10));

        panelCentral.add(panelCards, BorderLayout.NORTH);

        panelCentral.add(desktop, BorderLayout.CENTER);

        //=========================================
        // PANEL ESTADO
        //=========================================

        panelEstado = new JPanel(new BorderLayout());

        panelEstado.setBorder(
                BorderFactory.createEmptyBorder(8,10,8,10));

        lblEstado = new JLabel("Estado : Conectado");

        lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 13));

        lblVersion = new JLabel("Versión 1.0");

        lblVersion.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panelEstado.add(lblEstado, BorderLayout.WEST);

        panelEstado.add(lblVersion, BorderLayout.EAST);

        //=========================================
        // AGREGAR AL FRAME
        //=========================================

        add(panelSuperior, BorderLayout.NORTH);

        add(panelCentral, BorderLayout.CENTER);

        add(panelEstado, BorderLayout.SOUTH);

    }
    public void setUsuario(String nombre){

        lblBienvenido.setText("Bienvenido: " + nombre);

    }

}