    package vallegrande.edu.pe.controller;
    import vallegrande.edu.pe.model.Usuario;
    import vallegrande.edu.pe.model.UsuarioDAO;

    import java.util.List;

    public class UsuarioController {

        private final UsuarioDAO dao = new UsuarioDAO();

        public List <Usuario> obtenerUsuarios(){
            return dao.listar();
        }
        //INSERTAR
        public void agregarUsuario(String nombre, String correo){
            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setCorreo(correo);

            dao.insertar(u);
        }
        //ELIMINAR
        public void eliminarUsuario(int id){
            dao.eliminar(id);
        }
    }