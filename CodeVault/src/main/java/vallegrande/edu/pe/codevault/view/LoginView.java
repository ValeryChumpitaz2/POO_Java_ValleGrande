package vallegrande.edu.pe.codevault.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField txtUsuario = new JTextField();
    public JPasswordField txtPassword = new JPasswordField();

    public JButton btnLogin = new JButton("Iniciar sesión");
    public JCheckBox chkShowPass = new JCheckBox("Mostrar contraseña");

    public LoginView() {

        setTitle("CodeVault");
        setSize(450, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // 🌑 Fondo dark Windows 11
        JPanel background = new JPanel();
        background.setLayout(null);
        background.setBackground(new Color(18, 18, 18));

        // 🪟 Card estilo Windows 11
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(70, 80, 300, 380);
        card.setBackground(new Color(32, 32, 32));

        // Título
        JLabel title = new JLabel("CODEVAULT");
        title.setBounds(85, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel subtitle = new JLabel("Inicia sesión en tu cuenta");
        subtitle.setBounds(55, 50, 250, 20);
        subtitle.setForeground(Color.GRAY);

        // Usuario
        JLabel userLbl = new JLabel("Usuario");
        userLbl.setBounds(30, 100, 200, 20);
        userLbl.setForeground(Color.LIGHT_GRAY);

        txtUsuario.setBounds(30, 125, 240, 35);
        styleInput(txtUsuario);

        // Password
        JLabel passLbl = new JLabel("Contraseña");
        passLbl.setBounds(30, 170, 200, 20);
        passLbl.setForeground(Color.LIGHT_GRAY);

        txtPassword.setBounds(30, 195, 240, 35);
        styleInput(txtPassword);

        // Mostrar password
        chkShowPass.setBounds(30, 235, 200, 20);
        chkShowPass.setForeground(Color.GRAY);
        chkShowPass.setBackground(new Color(32, 32, 32));

        chkShowPass.addActionListener(e -> {
            if (chkShowPass.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });

        // Botón LOGIN (con hover animado simple)
        btnLogin.setBounds(30, 280, 240, 40);
        styleButton(btnLogin);

        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButton(btnLogin, new Color(0, 120, 215));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButton(btnLogin, new Color(0, 102, 204));
            }
        });

        // Demo info
        JLabel demo = new JLabel("Demo: admin / 1234");
        demo.setBounds(85, 330, 200, 20);
        demo.setForeground(Color.DARK_GRAY);

        // Add
        card.add(title);
        card.add(subtitle);
        card.add(userLbl);
        card.add(txtUsuario);
        card.add(passLbl);
        card.add(txtPassword);
        card.add(chkShowPass);
        card.add(btnLogin);
        card.add(demo);

        background.add(card);
        add(background);

        // default
        txtPassword.setEchoChar('•');
    }

    // 🎨 estilo inputs Windows 11
    private void styleInput(JTextField field) {
        field.setBackground(new Color(45, 45, 45));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    // 🎨 botón moderno
    private void styleButton(JButton btn) {
        btn.setBackground(new Color(0, 102, 204));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    // ✨ animación suave simulada
    private void animateButton(JButton btn, Color color) {
        btn.setBackground(color);
    }
}