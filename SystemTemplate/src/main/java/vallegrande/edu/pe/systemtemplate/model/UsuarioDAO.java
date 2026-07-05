package vallegrande.edu.pe.systemtemplate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

    Conexion conexion = new Conexion();

    Connection cn;

    PreparedStatement ps;

    ResultSet rs;

    /*==========================================
                LOGIN
    ==========================================*/
    public Usuario login(String usuario, String password) {

        Usuario u = null;

        String sql = "SELECT * FROM usuario "
                + "WHERE usuario=? "
                + "AND password=? "
                + "AND estado='ACTIVO'";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);

            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                u = new Usuario();

                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setIdRol(rs.getInt("idRol"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setCorreo(rs.getString("correo"));
                u.setEstado(rs.getString("estado"));
                u.setFechaRegistro(rs.getTimestamp("fechaRegistro"));

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return u;

    }

    /*==========================================
            INSERTAR
    ==========================================*/
    public boolean insertar(Usuario u) {

        String sql = "INSERT INTO usuario("
                + "idRol,nombres,apellidos,"
                + "usuario,password,correo,estado)"
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            ps.setInt(1, u.getIdRol());
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getUsuario());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getCorreo());
            ps.setString(7, u.getEstado());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    /*==========================================
            ACTUALIZAR
    ==========================================*/
    public boolean actualizar(Usuario u) {

        String sql = "UPDATE usuario SET "
                + "idRol=?,"
                + "nombres=?,"
                + "apellidos=?,"
                + "usuario=?,"
                + "password=?,"
                + "correo=?,"
                + "estado=? "
                + "WHERE idUsuario=?";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            ps.setInt(1, u.getIdRol());
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getUsuario());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getCorreo());
            ps.setString(7, u.getEstado());
            ps.setInt(8, u.getIdUsuario());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    /*==========================================
            ELIMINAR (LÓGICO)
    ==========================================*/
    public boolean eliminar(int id) {

        String sql = "UPDATE usuario "
                + "SET estado='INACTIVO' "
                + "WHERE idUsuario=?";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    /*==========================================
            BUSCAR POR ID
    ==========================================*/
    public Usuario buscarPorId(int id) {

        Usuario u = null;

        String sql = "SELECT * FROM usuario WHERE idUsuario=?";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                u = new Usuario();

                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setIdRol(rs.getInt("idRol"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setCorreo(rs.getString("correo"));
                u.setEstado(rs.getString("estado"));
                u.setFechaRegistro(rs.getTimestamp("fechaRegistro"));

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return u;

    }

    /*==========================================
            LISTAR
    ==========================================*/
    public ArrayList<Usuario> listar() {

        ArrayList<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try {

            cn = conexion.getConexion();

            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario u = new Usuario();

                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setIdRol(rs.getInt("idRol"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setCorreo(rs.getString("correo"));
                u.setEstado(rs.getString("estado"));
                u.setFechaRegistro(rs.getTimestamp("fechaRegistro"));

                lista.add(u);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }

}