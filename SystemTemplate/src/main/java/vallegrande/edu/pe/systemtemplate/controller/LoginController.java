package vallegrande.edu.pe.systemtemplate.controller;

import vallegrande.edu.pe.systemtemplate.model.Usuario;
import vallegrande.edu.pe.systemtemplate.model.UsuarioDAO;
import vallegrande.edu.pe.systemtemplate.view.FrmDashboard;
import vallegrande.edu.pe.systemtemplate.view.FrmLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;


public class LoginController implements ActionListener {

    private FrmLogin vista;
    private UsuarioDAO dao;

    public LoginController(FrmLogin vista) {

        this.vista = vista;
        this.dao = new UsuarioDAO();

        this.vista.btnIngresar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.chkMostrar.addActionListener(this);

        this.vista.txtPassword.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    iniciarSesion();

                }

            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnIngresar) {

            iniciarSesion();

        }

        if (e.getSource() == vista.btnSalir) {

            System.exit(0);

        }

        if (e.getSource() == vista.chkMostrar) {

            if (vista.chkMostrar.isSelected()) {

                vista.txtPassword.setEchoChar((char) 0);

            } else {

                vista.txtPassword.setEchoChar('•');

            }

        }

    }

    private void iniciarSesion() {

        String usuario = vista.txtUsuario.getText().trim();

        String password = String.valueOf(vista.txtPassword.getPassword());

        if (usuario.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Ingrese el usuario.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            vista.txtUsuario.requestFocus();

            return;

        }

        if (password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Ingrese la contraseña.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            vista.txtPassword.requestFocus();

            return;

        }

        Usuario u = dao.login(usuario, password);

        if (u != null) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Bienvenido " + u.getNombreCompleto());

            FrmDashboard dashboard = new FrmDashboard();

            dashboard.lblBienvenido.setText(
                    "Bienvenido: " + u.getNombreCompleto());

            new DashboardController(dashboard);

            dashboard.setVisible(true);

            vista.dispose();
        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "Usuario o contraseña incorrectos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            vista.txtPassword.setText("");

            vista.txtPassword.requestFocus();

        }

    }

}