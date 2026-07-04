package vallegrande.edu.pe.codevault.controller;

import vallegrande.edu.pe.codevault.model.*;
import vallegrande.edu.pe.codevault.view.CategoriaPanel;

public class CategoriaController {

    private CategoriaPanel vista;
    private CategoriaDAO dao = new CategoriaDAO();

    public CategoriaController(CategoriaPanel vista) {

        this.vista = vista;

        listar();

        vista.btnGuardar.addActionListener(e -> insertar());
    }

    private void listar() {

        vista.modelo.setRowCount(0);

        for (Categoria c : dao.listar()) {

            vista.modelo.addRow(new Object[]{
                    c.getIdCategoria(),
                    c.getNombre()
            });
        }
    }

    private void insertar() {

        Categoria c = new Categoria();
        c.setNombre(vista.txtNombre.getText());

        dao.insertar(c);

        listar();
        vista.txtNombre.setText("");
    }
}