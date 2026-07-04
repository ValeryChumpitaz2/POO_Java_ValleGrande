package vallegrande.edu.pe.codevault.model;

import vallegrande.edu.pe.codevault.model.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listar() {

        System.out.println("🔥 ENTRO A CATEGORIA DAO -> LISTAR");

        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try (Connection con = Conexion.getConexion()) {

            if (con == null) {
                System.out.println("❌ CONEXION ES NULL");
                return lista;
            }

            System.out.println("✅ CONEXION OK");

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Categoria c = new Categoria();

                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNombre(rs.getString("nombre"));

                System.out.println("✔ Categoria encontrada: " + c.getNombre());

                lista.add(c);
            }

            System.out.println("📦 TOTAL CATEGORIAS: " + lista.size());

        } catch (Exception e) {

            System.out.println("❌ ERROR EN LISTAR CATEGORIAS: " + e.getMessage());
        }

        return lista;
    }

    public void insertar(Categoria c) {

        System.out.println("🔥 INSERTANDO CATEGORIA: " + c.getNombre());

        String sql = "INSERT INTO categoria(nombre) VALUES(?)";

        try (Connection con = Conexion.getConexion()) {

            if (con == null) {
                System.out.println("❌ CONEXION ES NULL");
                return;
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());

            int rows = ps.executeUpdate();

            System.out.println("✔ FILAS INSERTADAS: " + rows);

        } catch (Exception e) {

            System.out.println("❌ ERROR INSERTAR CATEGORIA: " + e.getMessage());
        }
    }
}