package vallegrande.edu.pe.sistemalogin.view;

import javax.swing.*;
import java.awt.*;



public class DashboardView extends JFrame {

    public JButton btnProductos;
    public JButton btnClientes;
    public JButton btnReportes;
    public JButton btnSalir;

    public DashboardView() {

        setTitle("Dashboard");
        setSize(1100,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(220,650));
        menu.setBackground(new Color(33,43,54));
        menu.setLayout(null);

        JLabel titulo = new JLabel("SISTEMA MVC");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI",Font.BOLD,24));
        titulo.setBounds(20,30,200,40);

        btnProductos = crearBoton("📦 Productos");
        btnClientes = crearBoton("👥 Clientes");
        btnReportes = crearBoton("📊 Reportes");
        btnSalir = crearBoton("🚪 Salir");

        btnProductos.setBounds(20,120,180,45);
        btnClientes.setBounds(20,180,180,45);
        btnReportes.setBounds(20,240,180,45);
        btnSalir.setBounds(20,300,180,45);

        menu.add(titulo);
        menu.add(btnProductos);
        menu.add(btnClientes);
        menu.add(btnReportes);
        menu.add(btnSalir);

        // CENTRO

        JPanel centro = new JPanel();
        centro.setBackground(new Color(245,247,250));
        centro.setLayout(new FlowLayout(
                FlowLayout.CENTER,
                30,
                50));

        centro.add(crearCard("Productos","5"));
        centro.add(crearCard("Usuarios","1"));
        centro.add(crearCard("reportes","0"));

        add(menu,BorderLayout.WEST);
        add(centro,BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto){

        JButton btn = new JButton(texto);

        btn.setFocusPainted(false);

        btn.setBackground(
                new Color(52,152,219));

        btn.setForeground(Color.WHITE);

        btn.setFont(
                new Font("Segoe UI",
                        Font.BOLD,
                        16));

        return btn;
    }

    private JPanel crearCard(String titulo,
                             String valor){

        JPanel card = new JPanel();

        card.setPreferredSize(
                new Dimension(220,120));

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createLineBorder(
                        Color.LIGHT_GRAY));

        card.setLayout(
                new BorderLayout());

        JLabel lblTitulo =
                new JLabel(titulo,
                        SwingConstants.CENTER);

        JLabel lblValor =
                new JLabel(valor,
                        SwingConstants.CENTER);

        lblTitulo.setFont(
                new Font("Segoe UI",
                        Font.PLAIN,
                        18));

        lblValor.setFont(
                new Font("Segoe UI",
                        Font.BOLD,
                        40));

        card.add(lblTitulo,
                BorderLayout.NORTH);

        card.add(lblValor,
                BorderLayout.CENTER);

        return card;
    }
}