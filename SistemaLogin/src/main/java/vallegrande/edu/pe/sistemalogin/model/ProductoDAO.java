package vallegrande.edu.pe.sistemalogin.model;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean guardar(Producto p) {

        String sql =
                "INSERT INTO productos(nombre,categoria,precio,stock) VALUES(?,?,?,?)";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM productos";

        try (Connection cn = Conexion.conectar();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Producto p = new Producto();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean actualizar(Producto p) {

        String sql =
                "UPDATE productos SET nombre=?, categoria=?, precio=?, stock=? WHERE id=?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM productos WHERE id=?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}