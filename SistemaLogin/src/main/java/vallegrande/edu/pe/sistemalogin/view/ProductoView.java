package vallegrande.edu.pe.sistemalogin.view;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoView extends JFrame {

    public JTextField txtId;
    public JTextField txtNombre;
    public JTextField txtCategoria;
    public JTextField txtPrecio;
    public JTextField txtStock;

    public JButton btnGuardar;
    public JButton btnActualizar;
    public JButton btnEliminar;

    public JTable tabla;
    public DefaultTableModel modelo;

    public ProductoView() {

        setTitle("CRUD Productos");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelForm = new JPanel(new GridLayout(5,2,10,10));

        txtId = new JTextField();
        txtId.setEnabled(false);

        txtNombre = new JTextField();
        txtCategoria = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();

        panelForm.add(new JLabel("ID"));
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre"));
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Categoria"));
        panelForm.add(txtCategoria);

        panelForm.add(new JLabel("Precio"));
        panelForm.add(txtPrecio);

        panelForm.add(new JLabel("Stock"));
        panelForm.add(txtStock);

        JPanel panelBotones = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoria");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");

        tabla = new JTable(modelo);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}