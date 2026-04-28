package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class InicioView extends JFrame {

    public InicioView() {
        setTitle("Sistema Principal");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 🔷 Título
        JLabel titulo = new JLabel("BIENVENIDO", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(titulo, BorderLayout.NORTH);

        // 📝 Texto pequeño
        JLabel descripcion = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Este sistema permite gestionar usuarios<br>"
                        + "utilizando el patrón MVC."
                        + "</div></html>",
                JLabel.CENTER
        );
        descripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        // 🔘 Botón
        JButton btnUsuarios = new JButton("Ir a Usuarios");
        btnUsuarios.setFocusPainted(false);

        btnUsuarios.addActionListener(e -> {
            new UsuarioView().setVisible(true);
            dispose();
        });

        // Contenedor central
        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));
        centro.setBackground(Color.WHITE);
        centro.add(descripcion);
        centro.add(btnUsuarios);

        panel.add(centro, BorderLayout.CENTER);

        add(panel);
    }
}