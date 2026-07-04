package vallegrande.edu.pe.codevault.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean login(Usuario usuario) {

        String sql = "SELECT * FROM usuario WHERE username=? AND password=?";

        try {

            Connection con = Conexion.getConexion();

            // 🔴 validar conexión
            if (con == null) {
                System.out.println("❌ Error: No hay conexión a la base de datos");
                return false;
            }

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());

            ResultSet rs = ps.executeQuery();

            return rs.next(); // true si existe usuario

        } catch (SQLException e) {

            System.out.println("❌ Error SQL en login: " + e.getMessage());
        }

        return false;
    }
}