package vallegrande.edu.pe.sistemalogin.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3307/sistemas_login";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection conectar(){
        try {
        return DriverManager.getConnection(URL,USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }
}
