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
// 📝 Campos + botones
        JTextField txtNombre = new JTextField(10);
        JTextField txtCorreo = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");

        JPanel panelTop = new JPanel();
        panelTop.setBackground(Color.WHITE);

        panelTop.add(new JLabel("Nombre:"));
        panelTop.add(txtNombre);
        panelTop.add(new JLabel("Correo:"));
        panelTop.add(txtCorreo);
        panelTop.add(btnAgregar);
        panelTop.add(btnEliminar);

// ⬇️ IMPORTANTE: usar SOUTH para no borrar el título
        panel.add(panelTop, BorderLayout.SOUTH);

        // ➕ AGREGAR
        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();

            controller.agregarUsuario(nombre, correo);

            modelo.setRowCount(0);
            cargarDatos();

            txtNombre.setText("");
            txtCorreo.setText("");
        });

// 🗑️ ELIMINAR
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);

            controller.eliminarUsuario(id);

            modelo.setRowCount(0);
            cargarDatos();
        });


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