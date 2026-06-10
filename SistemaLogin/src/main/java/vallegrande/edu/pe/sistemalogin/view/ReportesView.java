package vallegrande.edu.pe.sistemalogin.view;

import javax.swing.*;
import java.awt.*;

public class ReportesView extends JFrame {

    public JButton btnVerReporte;
    public JButton btnExportarPDF;
    public JButton btnCerrar;

    public ReportesView() {

        setTitle("Gestión de Reportes");
        setSize(500,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,10,10));

        JLabel titulo =
                new JLabel(
                        "MÓDULO DE REPORTES",
                        SwingConstants.CENTER);

        titulo.setFont(
                new Font("Segoe UI",
                        Font.BOLD,
                        20));

        btnVerReporte =
                new JButton("📊 Ver Reporte");

        btnExportarPDF =
                new JButton("📄 Exportar PDF");

        btnCerrar =
                new JButton("❌ Cerrar");

        panel.add(titulo);
        panel.add(btnVerReporte);
        panel.add(btnExportarPDF);
        panel.add(btnCerrar);

        add(panel);
    }
}