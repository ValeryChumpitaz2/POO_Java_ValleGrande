package vallegrande.edu.pe.sistemalogin.view;

import javax.swing.*;
 import java.awt.*;


import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField txtUsuario;
    public JPasswordField txtPassword;
    public JButton btnIngresar;

    public LoginView() {

        setTitle("Sistema MVC");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new GridLayout(1,2));

        // PANEL IZQUIERDO

        JPanel izquierda = new JPanel();
        izquierda.setBackground(new Color(41,128,185));
        izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("SISTEMA MVC");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Gestión de Productos");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        izquierda.add(Box.createVerticalGlue());
        izquierda.add(titulo);
        izquierda.add(Box.createVerticalStrut(20));
        izquierda.add(subtitulo);
        izquierda.add(Box.createVerticalGlue());

        // PANEL DERECHO

        JPanel derecha = new JPanel();
        derecha.setBackground(Color.WHITE);
        derecha.setLayout(null);

        JLabel login = new JLabel("Iniciar Sesión");
        login.setFont(new Font("Segoe UI", Font.BOLD, 28));
        login.setBounds(110,50,300,40);

        JLabel lblUser = new JLabel("Usuario");
        lblUser.setBounds(80,130,100,25);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(80,160,250,35);

        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setBounds(80,220,100,25);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(80,250,250,35);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(80,320,250,40);

        btnIngresar.setBackground(
                new Color(52,152,219));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusPainted(false);

        derecha.add(login);
        derecha.add(lblUser);
        derecha.add(txtUsuario);
        derecha.add(lblPass);
        derecha.add(txtPassword);
        derecha.add(btnIngresar);

        add(izquierda);
        add(derecha);
    }
}