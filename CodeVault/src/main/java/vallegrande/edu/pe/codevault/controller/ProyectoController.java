package vallegrande.edu.pe.codevault.controller;

import vallegrande.edu.pe.codevault.model.*;
import vallegrande.edu.pe.codevault.view.ProyectoPanel;

public class ProyectoController {

    private ProyectoPanel vista;
    private ProyectoDAO dao = new ProyectoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public ProyectoController(ProyectoPanel vista) {

        this.vista = vista;

        cargarCategorias();
        listar();

        vista.btnGuardar.addActionListener(e -> insertar());
        vista.btnEliminar.addActionListener(e -> eliminar());
    }

    private void cargarCategorias() {

        vista.cboCategoria.removeAllItems();

        for (Categoria c : categoriaDAO.listar()) {

            vista.cboCategoria.addItem(c);
        }
    }

    private void listar() {

        vista.modelo.setRowCount(0);

        for (Proyecto p : dao.listar()) {

            vista.modelo.addRow(new Object[]{
                    p.getIdProyecto(),
                    p.getNombre(),
                    p.getDescripcion(),
                    p.getCategoria(),
                    p.getLenguaje(),
                    p.getEstado(),
                    p.isBaseDatos(),
                    p.isLoginSistema(),
                    p.isReportes()
            });
        }
    }

    private void insertar() {

        Proyecto p = new Proyecto();

        p.setNombre(vista.txtNombre.getText());
        p.setDescripcion(vista.txtDescripcion.getText());

        Categoria cat = (Categoria) vista.cboCategoria.getSelectedItem();
        p.setCategoria(cat.getIdCategoria());

        if (vista.rbJava.isSelected()) p.setLenguaje("Java");
        if (vista.rbPython.isSelected()) p.setLenguaje("Python");
        if (vista.rbCSharp.isSelected()) p.setLenguaje("C#");

        if (vista.rbCompleto.isSelected()) p.setEstado("Completo");
        if (vista.rbDesarrollo.isSelected()) p.setEstado("En desarrollo");

        p.setBaseDatos(vista.chkBD.isSelected());
        p.setLoginSistema(vista.chkLogin.isSelected());
        p.setReportes(vista.chkReportes.isSelected());

        dao.insertar(p);

        listar();
        limpiar();
    }

    private void eliminar() {

        int fila = vista.tabla.getSelectedRow();

        if (fila >= 0) {

            int id = (int) vista.tabla.getValueAt(fila, 0);

            dao.eliminar(id);

            listar();
        }
    }

    private void limpiar() {

        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");

        vista.chkBD.setSelected(false);
        vista.chkLogin.setSelected(false);
        vista.chkReportes.setSelected(false);
    }
}