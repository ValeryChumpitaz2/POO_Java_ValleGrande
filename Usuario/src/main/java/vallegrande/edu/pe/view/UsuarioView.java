package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.UsuarioController;
import vallegrande.edu.pe.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UsuarioView extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private UsuarioController controller = new UsuarioController();

    public UsuarioView() {
        setTitle("Usuarios");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 🔷 Título
        JLabel titulo = new JLabel("LISTADO DE USUARIOS", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(titulo, BorderLayout.NORTH);

        // 📊 Tabla
        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "Correo"}, 0
        );

        tabla = new JTable(modelo);
        tabla.setRowHeight(22);
        tabla.setFillsViewportHeight(true);

        // 🎨 Encabezado bonito
        tabla.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            {
                setOpaque(true);
                setBackground(new Color(0, 120, 215)); // azul
                setForeground(Color.WHITE);
                setHorizontalAlignment(JLabel.CENTER);
            }
        });

        // 🔙 Botón volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            new InicioView().setVisible(true);
            dispose();
        });

        JPanel abajo = new JPanel();
        abajo.setBackground(Color.WHITE);
        abajo.add(btnVolver);

        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        add(panel);

        cargarDatos();
    }

    private void cargarDatos() {
        List<Usuario> lista = controller.obtenerUsuarios();

        for (Usuario u : lista) {
            modelo.addRow(new Object[]{
                    u.getId(),
                    u.getNombre(),
                    u.getCorreo()
            });
        }
    }
}