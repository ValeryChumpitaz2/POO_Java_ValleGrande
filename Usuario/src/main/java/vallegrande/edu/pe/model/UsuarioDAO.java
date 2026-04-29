package vallegrande.edu.pe.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();


        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM usuario";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                lista.add(u);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return lista;
    }
}

