package vallegrande.edu.pe.codevault.controller;

import vallegrande.edu.pe.codevault.view.*;

import java.awt.BorderLayout;

public class DashboardController {

    private DashboardView vista;

    public DashboardController(DashboardView vista) {
        this.vista = vista;

        vista.btnProyectos.addActionListener(e -> mostrarProyectos());
        vista.btnCategorias.addActionListener(e -> mostrarCategorias());
        vista.btnSalir.addActionListener(e -> salir());
    }

    private void mostrarProyectos() {

        System.out.println("👉 ABRIENDO PROYECTOS");

        vista.contentPanel.removeAll();

        ProyectoPanel panel = new ProyectoPanel();

        new ProyectoController(panel); // 🔥 IMPORTANTE

        vista.contentPanel.setLayout(new BorderLayout());
        vista.contentPanel.add(panel, BorderLayout.CENTER);

        vista.contentPanel.revalidate();
        vista.contentPanel.repaint();
    }

    private void mostrarCategorias() {

        System.out.println("👉 ABRIENDO CATEGORIAS");

        vista.contentPanel.removeAll();

        CategoriaPanel panel = new CategoriaPanel();

        new CategoriaController(panel); // 🔥 ESTA ES LA CLAVE

        vista.contentPanel.setLayout(new BorderLayout());
        vista.contentPanel.add(panel, BorderLayout.CENTER);

        vista.contentPanel.revalidate();
        vista.contentPanel.repaint();
    }

    private void salir() {

        vista.dispose();

        LoginView login = new LoginView();
        new LoginController(login);

        login.setVisible(true);
    }
}