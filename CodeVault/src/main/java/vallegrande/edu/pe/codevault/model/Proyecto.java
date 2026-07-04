package vallegrande.edu.pe.codevault.model;

public class Proyecto {

    private int idProyecto;
    private String nombre;
    private String descripcion;
    private int categoria;
    private String lenguaje;
    private String estado;
    private boolean baseDatos;
    private boolean loginSistema;
    private boolean reportes;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombre, String descripcion,
                    int categoria, String lenguaje, String estado,
                    boolean baseDatos, boolean loginSistema,
                    boolean reportes) {

        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.lenguaje = lenguaje;
        this.estado = estado;
        this.baseDatos = baseDatos;
        this.loginSistema = loginSistema;
        this.reportes = reportes;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(boolean baseDatos) {
        this.baseDatos = baseDatos;
    }

    public boolean isLoginSistema() {
        return loginSistema;
    }

    public void setLoginSistema(boolean loginSistema) {
        this.loginSistema = loginSistema;
    }

    public boolean isReportes() {
        return reportes;
    }

    public void setReportes(boolean reportes) {
        this.reportes = reportes;
    }

}