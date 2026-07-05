package vallegrande.edu.pe.systemtemplate.model;

import java.sql.Timestamp;

public class Usuario {

    private int idUsuario;
    private int idRol;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String password;
    private String correo;
    private String estado;
    private Timestamp fechaRegistro;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idRol, String nombres,
                   String apellidos, String usuario,
                   String password, String correo,
                   String estado, Timestamp fechaRegistro) {

        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

}