package vallegrande.edu.pe.codevault.controller;

import vallegrande.edu.pe.codevault.view.DashboardView;
import vallegrande.edu.pe.codevault.view.LoginView;
 import vallegrande.edu.pe.codevault.model.Usuario;
import vallegrande.edu.pe.codevault.model.UsuarioDAO;

import javax.swing.*;

public class LoginController {

    private LoginView vista;
    private UsuarioDAO dao;

    public LoginController(LoginView vista) {

        this.vista = vista;
        this.dao = new UsuarioDAO();

        vista.btnLogin.addActionListener(e -> login());
    }

    private void login() {

        Usuario u = new Usuario();
        u.setUsuario(vista.txtUsuario.getText());
        u.setPassword(String.valueOf(vista.txtPassword.getPassword()));

        if (dao.login(u)) {

            // 1. CREAR DASHBOARD PRIMERO
            DashboardView dashboard = new DashboardView();
            new DashboardController(dashboard);

            // 2. MOSTRAR DASHBOARD
            dashboard.setVisible(true);

            // 3. CERRAR LOGIN AL FINAL
            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(vista,
                    "Usuario o contraseña incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    } }