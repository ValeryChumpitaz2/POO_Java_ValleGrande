package vallegrande.edu.pe.codevault.model;

import vallegrande.edu.pe.codevault.model.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {

    public List<Proyecto> listar() {

        List<Proyecto> lista = new ArrayList<>();

        String sql = "SELECT * FROM proyecto";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Proyecto p = new Proyecto();

                p.setIdProyecto(rs.getInt("idProyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCategoria(rs.getInt("categoria"));
                p.setLenguaje(rs.getString("lenguaje"));
                p.setEstado(rs.getString("estado"));
                p.setBaseDatos(rs.getBoolean("baseDatos"));
                p.setLoginSistema(rs.getBoolean("loginSistema"));
                p.setReportes(rs.getBoolean("reportes"));

                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error ProyectoDAO listar: " + e.getMessage());
        }

        return lista;
    }

    public void insertar(Proyecto p) {

        String sql = """
            INSERT INTO proyecto
            (nombre,descripcion,categoria,lenguaje,estado,baseDatos,loginSistema,reportes)
            VALUES (?,?,?,?,?,?,?,?)
        """;

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getCategoria());
            ps.setString(4, p.getLenguaje());
            ps.setString(5, p.getEstado());
            ps.setBoolean(6, p.isBaseDatos());
            ps.setBoolean(7, p.isLoginSistema());
            ps.setBoolean(8, p.isReportes());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ProyectoDAO insertar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM proyecto WHERE idProyecto=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error eliminar proyecto: " + e.getMessage());
        }
    }
}