package vallegrande.edu.pe.systemtemplate.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import vallegrande.edu.pe.systemtemplate.view.*;
import vallegrande.edu.pe.systemtemplate.view.JDesktopPane.FrmCategoria;

public class DashboardController implements ActionListener{

    private FrmDashboard vista;

    public DashboardController(FrmDashboard vista){

        this.vista=vista;

        eventos();

    }

    private void eventos(){

        vista.itemSalir.addActionListener(this);

        vista.itemCerrarSesion.addActionListener(this);

        vista.itemCategoria.addActionListener(this);

        vista.itemProducto.addActionListener(this);

        vista.itemCliente.addActionListener(this);

        vista.itemProveedor.addActionListener(this);

        vista.itemEmpleado.addActionListener(this);

        vista.itemCompra.addActionListener(this);

        vista.itemVenta.addActionListener(this);

        vista.itemUsuarios.addActionListener(this);

        vista.itemRoles.addActionListener(this);

        vista.itemReporteProductos.addActionListener(this);

        vista.itemReporteCompras.addActionListener(this);

        vista.itemReporteVentas.addActionListener(this);

        vista.itemReporteInventario.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        Object evento=e.getSource();

        if(evento==vista.itemSalir){

            salir();

        }

        if(evento==vista.itemCerrarSesion){

            cerrarSesion();

        }

        if(evento==vista.itemCategoria){

            abrirCategoria();

        }

        if(evento==vista.itemProducto){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Productos próximamente");

        }

        if(evento==vista.itemCliente){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Clientes próximamente");

        }

        if(evento==vista.itemProveedor){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Proveedores próximamente");

        }

        if(evento==vista.itemEmpleado){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Empleados próximamente");

        }

        if(evento==vista.itemCompra){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Compras próximamente");

        }

        if(evento==vista.itemVenta){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Ventas próximamente");

        }

        if(evento==vista.itemUsuarios){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Usuarios próximamente");

        }

        if(evento==vista.itemRoles){

            JOptionPane.showMessageDialog(vista,
                    "Módulo Roles próximamente");

        }

    }

    private void salir(){

        int op=JOptionPane.showConfirmDialog(vista,
                "¿Desea salir del sistema?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if(op==JOptionPane.YES_OPTION){

            System.exit(0);

        }

    }

    private void cerrarSesion(){

        int op=JOptionPane.showConfirmDialog(vista,
                "¿Cerrar sesión?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if(op==JOptionPane.YES_OPTION){

            vista.dispose();

            FrmLogin login=new FrmLogin();

            new LoginController(login);

            login.setVisible(true);

        }

    }

    private void abrirCategoria(){

        for(JInternalFrame frame : vista.desktop.getAllFrames()){

            if(frame instanceof FrmCategoria){

                try{

                    frame.setSelected(true);

                }catch(Exception ex){}

                frame.toFront();

                return;

            }

        }

        FrmCategoria frm=new FrmCategoria();

        vista.desktop.add(frm);

        Dimension desktop=vista.desktop.getSize();

        Dimension ventana=frm.getSize();

        frm.setLocation(
                (desktop.width-ventana.width)/2,
                (desktop.height-ventana.height)/2
        );

        frm.setVisible(true);

    }

}