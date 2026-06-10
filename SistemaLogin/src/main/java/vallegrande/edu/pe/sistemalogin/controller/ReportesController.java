package vallegrande.edu.pe.sistemalogin.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import vallegrande.edu.pe.sistemalogin.model.Conexion;
import vallegrande.edu.pe.sistemalogin.view.ReportesView;

import javax.swing.*;
import java.io.File;
import java.sql.Connection;

public class ReportesController {

    private ReportesView vista;

    public ReportesController(ReportesView vista) {

        this.vista = vista;

        vista.btnVerReporte.addActionListener(
                e -> verReporte());

        vista.btnExportarPDF.addActionListener(
                e -> exportarPDF());

        vista.btnCerrar.addActionListener(
                e -> vista.dispose());
    }
    private void verReporte() {

        try {

            Connection cn =
                    Conexion.conectar();

            JasperReport reporte =
                    JasperCompileManager.compileReport(
                            "src/main/resources/reportes/Producto.jrxml");

            JasperPrint print =
                    JasperFillManager.fillReport(
                            reporte,
                            null,
                            cn);

            JasperViewer.viewReport(
                    print,
                    false);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage());
        }
    }private void exportarPDF() {

        try {

            Connection cn =
                    Conexion.conectar();

            JasperReport reporte =
                    JasperCompileManager.compileReport(
                            getClass().getResourceAsStream(
                                    "/reportes/Producto.jrxml"));

            JasperPrint print =
                    JasperFillManager.fillReport(
                            reporte,
                            null,
                            cn);

            JasperExportManager.exportReportToPdfFile(
                    print,
                    "Producto.pdf");

            JOptionPane.showMessageDialog(
                    null,
                    "PDF generado correctamente");

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    null,
                    e.toString(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    } }