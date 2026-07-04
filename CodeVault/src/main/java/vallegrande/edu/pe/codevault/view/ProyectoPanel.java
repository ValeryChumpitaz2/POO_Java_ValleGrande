package vallegrande.edu.pe.codevault.view;

import vallegrande.edu.pe.codevault.model.Categoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProyectoPanel extends JPanel {

    public JTextField txtId = new JTextField();
    public JTextField txtNombre = new JTextField();
    public JTextField txtDescripcion = new JTextField();

    public JComboBox<Categoria> cboCategoria = new JComboBox<>();

    public JRadioButton rbJava = new JRadioButton("Java");
    public JRadioButton rbPython = new JRadioButton("Python");
    public JRadioButton rbCSharp = new JRadioButton("C#");

    public JRadioButton rbCompleto = new JRadioButton("Completo");
    public JRadioButton rbDesarrollo = new JRadioButton("En desarrollo");

    public JCheckBox chkBD = new JCheckBox("Base de datos");
    public JCheckBox chkLogin = new JCheckBox("Login");
    public JCheckBox chkReportes = new JCheckBox("Reportes");

    public JButton btnGuardar = new JButton("Guardar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLimpiar = new JButton("Limpiar");

    public JTable tabla = new JTable();
    public DefaultTableModel modelo = new DefaultTableModel();

    public ProyectoPanel() {

        setLayout(null);
        setBackground(new Color(25, 25, 25));

        // ID oculto visualmente
        txtId.setVisible(false);

        ButtonGroup langGroup = new ButtonGroup();
        langGroup.add(rbJava);
        langGroup.add(rbPython);
        langGroup.add(rbCSharp);

        ButtonGroup estadoGroup = new ButtonGroup();
        estadoGroup.add(rbCompleto);
        estadoGroup.add(rbDesarrollo);

        // FORM
        JLabel title = new JLabel("CRUD PROYECTOS - ERP");
        title.setBounds(20, 10, 300, 25);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));

        add(title);

        addLabel("Nombre", 20, 50);
        txtNombre.setBounds(120, 50, 200, 25);

        addLabel("Descripción", 20, 80);
        txtDescripcion.setBounds(120, 80, 200, 25);

        addLabel("Categoría", 20, 110);
        cboCategoria.setBounds(120, 110, 200, 25);

        addLabel("Lenguaje", 20, 140);
        rbJava.setBounds(120, 140, 70, 25);
        rbPython.setBounds(200, 140, 80, 25);
        rbCSharp.setBounds(280, 140, 60, 25);

        addLabel("Estado", 20, 170);
        rbCompleto.setBounds(120, 170, 100, 25);
        rbDesarrollo.setBounds(230, 170, 130, 25);

        addLabel("Extras", 20, 200);
        chkBD.setBounds(120, 200, 120, 25);
        chkLogin.setBounds(220, 200, 100, 25);
        chkReportes.setBounds(320, 200, 120, 25);

        // BOTONES
        btnGuardar.setBounds(20, 240, 100, 30);
        btnActualizar.setBounds(130, 240, 120, 30);
        btnEliminar.setBounds(260, 240, 100, 30);
        btnLimpiar.setBounds(370, 240, 100, 30);

        // TABLA
        modelo.setColumnIdentifiers(new String[]{
                "ID","Nombre","Descripción","Categoría",
                "Lenguaje","Estado","BD","Login","Reportes"
        });

        tabla.setModel(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 290, 750, 250);

        // ADD
        add(txtId);
        add(txtNombre);
        add(txtDescripcion);
        add(cboCategoria);

        add(rbJava);
        add(rbPython);
        add(rbCSharp);

        add(rbCompleto);
        add(rbDesarrollo);

        add(chkBD);
        add(chkLogin);
        add(chkReportes);

        add(btnGuardar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnLimpiar);

        add(scroll);
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 100, 25);
        lbl.setForeground(Color.LIGHT_GRAY);
        add(lbl);
    }
}