package vallegrande.edu.pe.sistemalogin;

import vallegrande.edu.pe.sistemalogin.controller.LoginController;
import vallegrande.edu.pe.sistemalogin.view.LoginView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        LoginView vista = new LoginView();

        new LoginController(vista);

        vista.setVisible(true);
    }
}