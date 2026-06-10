package vallegrande.edu.pe.sistemalogin.controller;


import vallegrande.edu.pe.sistemalogin.view.DashboardView;
import vallegrande.edu.pe.sistemalogin.view.ProductoView;
import vallegrande.edu.pe.sistemalogin.view.ReportesView;

public class DashboardController {

    private DashboardView vista;

    public DashboardController(DashboardView vista) {

        this.vista = vista;

        vista.btnProductos.addActionListener(
                e -> abrirProductos());

        vista.btnReportes.addActionListener(
        e -> abrirReportes());

        vista.btnSalir.addActionListener(
                e -> System.exit(0));
    }

    private void abrirReportes() {

        ReportesView rv =
                new ReportesView();

        new ReportesController(rv);

        rv.setVisible(true);
    }

    private void abrirProductos() {

        ProductoView productoView =
                new ProductoView();

        new ProductoController(productoView);

        productoView.setVisible(true);
    }
}