    package vallegrande.edu.pe.controller;
    import vallegrande.edu.pe.model.Usuario;
    import vallegrande.edu.pe.model.UsuarioDAO;

    import java.util.List;

    public class UsuarioController {

        private final UsuarioDAO dao = new UsuarioDAO();

        public List <Usuario> obtenerUsuarios(){
            return dao.listar();
        }

    }