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
    public void insertar(Usuario u) {
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "INSERT INTO usuario(nombre, correo) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminar(int id) {
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}