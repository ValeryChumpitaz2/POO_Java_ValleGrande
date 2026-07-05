package vallegrande.edu.pe.systemtemplate.view.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CardPanel extends JPanel{

    private JLabel lblTitulo;
    private JLabel lblNumero;
    private JLabel lblDescripcion;

    public CardPanel(String titulo,String numero){

        setLayout(new BorderLayout());

        setBackground(Color.WHITE);

        setBorder(new CompoundBorder(
                new LineBorder(new Color(210,210,210),1,true),
                new EmptyBorder(10,10,10,10)));

        setPreferredSize(new Dimension(180,120));

        lblTitulo=new JLabel(titulo);

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Segoe UI",Font.BOLD,16));

        lblNumero=new JLabel(numero);

        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);

        lblNumero.setFont(new Font("Segoe UI",Font.BOLD,34));

        lblNumero.setForeground(new Color(33,150,243));

        lblDescripcion=new JLabel("Registros");

        lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);

        lblDescripcion.setForeground(Color.GRAY);

        lblDescripcion.setFont(new Font("Segoe UI",Font.PLAIN,12));

        add(lblTitulo,BorderLayout.NORTH);

        add(lblNumero,BorderLayout.CENTER);

        add(lblDescripcion,BorderLayout.SOUTH);

    }

    public void setNumero(String numero){

        lblNumero.setText(numero);

    }

    public void setDescripcion(String descripcion){

        lblDescripcion.setText(descripcion);

    }

    public String getNumero(){

        return lblNumero.getText();

    }

}