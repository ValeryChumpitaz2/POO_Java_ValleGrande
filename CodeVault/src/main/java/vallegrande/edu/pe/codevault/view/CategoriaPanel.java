package vallegrande.edu.pe.codevault.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CategoriaPanel extends JPanel {

    public JTextField txtId = new JTextField();
    public JTextField txtNombre = new JTextField();

    public JButton btnGuardar = new JButton("Guardar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLimpiar = new JButton("Limpiar");

    public JTable tabla = new JTable();
    public DefaultTableModel modelo = new DefaultTableModel();

    public CategoriaPanel() {

        setLayout(null);
        setBackground(new Color(25, 25, 25));

        JLabel title = new JLabel("CRUD CATEGORÍAS");
        title.setBounds(20, 10, 200, 25);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title);

        txtId.setVisible(false);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20, 50, 100, 25);
        lblNombre.setForeground(Color.LIGHT_GRAY);

        txtNombre.setBounds(100, 50, 200, 25);

        btnGuardar.setBounds(20, 90, 100, 30);
        btnActualizar.setBounds(130, 90, 120, 30);
        btnEliminar.setBounds(260, 90, 100, 30);
        btnLimpiar.setBounds(370, 90, 100, 30);

        modelo.setColumnIdentifiers(new String[]{
                "ID", "Nombre"
        });

        tabla.setModel(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 140, 600, 300);

        add(txtId);
        add(lblNombre);
        add(txtNombre);

        add(btnGuardar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnLimpiar);

        add(scroll);
    }
}