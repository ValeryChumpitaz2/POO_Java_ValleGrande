package vallegrande.edu.pe.codevault.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {

        try {

            String url =
                    "jdbc:mysql://localhost:3307/CodeVault" +
                            "?useSSL=false" +
                            "&allowPublicKeyRetrieval=true" +
                            "&serverTimezone=UTC";

            String user = "root";
            String pass = "123456"; // o tu contraseña real

            return DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {

            System.out.println("ERROR SQL: " + e.getMessage());
            return null;
        }
    }
}