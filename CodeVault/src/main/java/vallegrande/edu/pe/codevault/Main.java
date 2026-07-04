package vallegrande.edu.pe.codevault;

import vallegrande.edu.pe.codevault.view.LoginView;
import vallegrande.edu.pe.codevault.controller.LoginController;

public class Main {

    public static void main(String[] args) {

        LoginView v = new LoginView();
        new LoginController(v);

        v.setVisible(true);
    }
}