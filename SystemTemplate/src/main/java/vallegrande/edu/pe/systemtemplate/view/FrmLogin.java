package vallegrande.edu.pe.systemtemplate.view;

import java.awt.*;
import javax.swing.*;

public class FrmLogin extends JFrame {

    //==============================
    // ETIQUETAS
    //==============================
    public JLabel lblTitulo;
    public JLabel lblSubTitulo;
    public JLabel lblUsuario;
    public JLabel lblPassword;

    //==============================
    // CAJAS DE TEXTO
    //==============================
    public JTextField txtUsuario;
    public JPasswordField txtPassword;

    //==============================
    // CHECKBOX
    //==============================
    public JCheckBox chkMostrar;

    //==============================
    // BOTONES
    //==============================
    public JButton btnIngresar;
    public JButton btnSalir;

    //==============================
    // PANELES
    //==============================
    private JPanel panelSuperior;
    private JPanel panelCentro;
    private JPanel panelBotones;

    public FrmLogin() {

        iniciarComponentes();

    }

    private void iniciarComponentes() {

        setTitle("SystemTemplate");

        setSize(430, 420);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);

        setLayout(new BorderLayout());

        //-------------------------
        // PANEL SUPERIOR
        //-------------------------

        panelSuperior = new JPanel();

        panelSuperior.setLayout(new GridLayout(3,1));

        lblTitulo = new JLabel("SystemTemplate");

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Segoe UI",Font.BOLD,24));

        lblSubTitulo = new JLabel("Sistema Base de Gestión Empresarial");

        lblSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblSubTitulo.setFont(new Font("Segoe UI",Font.PLAIN,14));

        JLabel espacio = new JLabel("");

        panelSuperior.add(espacio);

        panelSuperior.add(lblTitulo);

        panelSuperior.add(lblSubTitulo);

        //-------------------------
        // PANEL CENTRO
        //-------------------------

        panelCentro = new JPanel();

        panelCentro.setLayout(new GridLayout(5,2,10,10));

        panelCentro.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

        lblUsuario = new JLabel("Usuario");

        txtUsuario = new JTextField();

        lblPassword = new JLabel("Contraseña");

        txtPassword = new JPasswordField();

        chkMostrar = new JCheckBox("Mostrar contraseña");

        panelCentro.add(lblUsuario);

        panelCentro.add(txtUsuario);

        panelCentro.add(lblPassword);

        panelCentro.add(txtPassword);

        panelCentro.add(new JLabel());

        panelCentro.add(chkMostrar);

        //-------------------------
        // PANEL BOTONES
        //-------------------------

        panelBotones = new JPanel();

        btnIngresar = new JButton("Ingresar");

        btnSalir = new JButton("Salir");

        btnIngresar.setPreferredSize(new Dimension(120,35));

        btnSalir.setPreferredSize(new Dimension(120,35));

        panelBotones.add(btnIngresar);

        panelBotones.add(btnSalir);

        //-------------------------

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        txtUsuario.requestFocus();

        getRootPane().setDefaultButton(btnIngresar);

    }

}