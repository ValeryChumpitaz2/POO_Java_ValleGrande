package vallegrande.edu.pe.codevault.view;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {

    public JPanel sidebar = new JPanel();
    public JPanel contentPanel = new JPanel();

    public JButton btnProyectos = new JButton("📁 Proyectos");
    public JButton btnCategorias = new JButton("📂 Categorías");
    public JButton btnSalir = new JButton("🚪 Salir");

    public DashboardView() {

        setTitle("CodeVault Enterprise");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(new Color(18, 18, 18));
        main.setBounds(0, 0, 1100, 650);

        // SIDEBAR
        sidebar.setLayout(null);
        sidebar.setBounds(0, 0, 240, 650);
        sidebar.setBackground(new Color(28, 28, 28));

        JLabel logo = new JLabel("CODEVAULT");
        logo.setBounds(60, 20, 200, 30);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 16));

        style(btnProyectos, 100);
        style(btnCategorias, 160);
        style(btnSalir, 550);

        sidebar.add(logo);
        sidebar.add(btnProyectos);
        sidebar.add(btnCategorias);
        sidebar.add(btnSalir);

        // CONTENT AREA
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBounds(240, 0, 860, 650);
        contentPanel.setBackground(new Color(20, 20, 20));

        JLabel welcome = new JLabel("Bienvenido a CodeVault Enterprise");
        welcome.setForeground(Color.GRAY);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(welcome, BorderLayout.CENTER);

        main.add(sidebar);
        main.add(contentPanel);

        add(main);
    }

    private void style(JButton btn, int y) {

        btn.setBounds(20, y, 200, 40);
        btn.setBackground(new Color(45, 45, 45));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(70, 70, 70));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(45, 45, 45));
            }
        });
    }
}