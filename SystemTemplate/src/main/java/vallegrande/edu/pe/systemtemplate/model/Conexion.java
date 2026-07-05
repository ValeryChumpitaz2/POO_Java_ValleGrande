package vallegrande.edu.pe.systemtemplate.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3307/SystemTemplate?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "123456";

    private Connection conexion;

    public Connection getConexion() {

        try {

            if (conexion == null || conexion.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            }

        } catch (ClassNotFoundException e) {

            System.out.println("Driver JDBC no encontrado.");

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

        }

        return conexion;

    }

    public void cerrarConexion() {

        try {

            if (conexion != null && !conexion.isClosed()) {

                conexion.close();

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

}