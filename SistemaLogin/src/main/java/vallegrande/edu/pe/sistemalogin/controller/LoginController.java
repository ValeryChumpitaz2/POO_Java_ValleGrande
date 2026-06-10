package vallegrande.edu.pe.sistemalogin.controller;

import vallegrande.edu.pe.sistemalogin.model.Usuario;
import vallegrande.edu.pe.sistemalogin.model.UsuarioDAO;
import vallegrande.edu.pe.sistemalogin.view.DashboardView;
import vallegrande.edu.pe.sistemalogin.view.LoginView;
import vallegrande.edu.pe.sistemalogin.view.ProductoView;

import javax.swing.*;


import javax.swing.*;


import javax.swing.*;

public class LoginController {

    private LoginView vista;
    private UsuarioDAO dao;

    public LoginController(LoginView vista) {

        this.vista = vista;
        this.dao = new UsuarioDAO();

        vista.btnIngresar.addActionListener(
                e -> ingresar()
        );
    }

    private void ingresar() {

        String usuario = vista.txtUsuario.getText().trim();

        String password =
                String.valueOf(
                        vista.txtPassword.getPassword()
                );

        if (usuario.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Complete todos los campos"
            );

            return;
        }

        Usuario u = dao.login(usuario, password);

        if (u != null) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Bienvenido " + u.getUsuario()
            );

            DashboardView dashboard =
                    new DashboardView();

            new DashboardController(dashboard);

            dashboard.setVisible(true);

            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "Usuario o contraseña incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            vista.txtPassword.setText("");
            vista.txtPassword.requestFocus();
        }
    }
}