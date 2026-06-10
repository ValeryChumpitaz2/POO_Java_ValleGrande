package vallegrande.edu.pe.sistemalogin.controller;


import vallegrande.edu.pe.sistemalogin.model.Producto;
import vallegrande.edu.pe.sistemalogin.model.ProductoDAO;
import vallegrande.edu.pe.sistemalogin.view.ProductoView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductoController {

    private ProductoView vista;
    private ProductoDAO dao;

    public ProductoController(ProductoView vista) {

        this.vista = vista;
        this.dao = new ProductoDAO();

        listar();

        vista.btnGuardar.addActionListener(e -> guardar());

        vista.btnActualizar.addActionListener(e -> actualizar());

        vista.btnEliminar.addActionListener(e -> eliminar());

        vista.tabla.getSelectionModel()
                .addListSelectionListener(e -> seleccionarFila());
    }

    private void guardar() {

        Producto p = new Producto();

        p.setNombre(vista.txtNombre.getText());
        p.setCategoria(vista.txtCategoria.getText());
        p.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
        p.setStock(Integer.parseInt(vista.txtStock.getText()));

        dao.guardar(p);

        limpiar();
        listar();
    }

    private void actualizar() {

        Producto p = new Producto();

        p.setId(Integer.parseInt(vista.txtId.getText()));
        p.setNombre(vista.txtNombre.getText());
        p.setCategoria(vista.txtCategoria.getText());
        p.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
        p.setStock(Integer.parseInt(vista.txtStock.getText()));

        dao.actualizar(p);

        limpiar();
        listar();
    }

    private void eliminar() {

        if (!vista.txtId.getText().isEmpty()) {

            dao.eliminar(
                    Integer.parseInt(vista.txtId.getText()));

            limpiar();
            listar();
        }
    }

    private void listar() {

        DefaultTableModel modelo = vista.modelo;

        modelo.setRowCount(0);

        for (Producto p : dao.listar()) {

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getPrecio(),
                    p.getStock()
            });
        }
    }

    private void seleccionarFila() {

        int fila = vista.tabla.getSelectedRow();

        if (fila >= 0) {

            vista.txtId.setText(
                    vista.tabla.getValueAt(fila,0).toString());

            vista.txtNombre.setText(
                    vista.tabla.getValueAt(fila,1).toString());

            vista.txtCategoria.setText(
                    vista.tabla.getValueAt(fila,2).toString());

            vista.txtPrecio.setText(
                    vista.tabla.getValueAt(fila,3).toString());

            vista.txtStock.setText(
                    vista.tabla.getValueAt(fila,4).toString());
        }
    }

    private void limpiar() {

        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtCategoria.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
    }
}