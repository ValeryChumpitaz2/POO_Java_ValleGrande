package vallegrande.edu.pe.systemtemplate;

import vallegrande.edu.pe.systemtemplate.controller.LoginController;
import vallegrande.edu.pe.systemtemplate.view.FrmLogin;

public class Main {

    public static void main(String[] args) {

        try {

            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        FrmLogin login = new FrmLogin();

        new LoginController(login);

        login.setVisible(true);

    }

}