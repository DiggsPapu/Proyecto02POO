public class UsuarioLogic {
    private static UsuarioDAO usuarioDao = new UsuarioDAO();
    //METODOS ESTATICOS EN EL PASO DE METODOS DAO


    public static boolean autentificar(String usuario, String contrasenia){
    if(obtener(usuario)!= null){
        Usuario usuarioConsulta = obtener(usuario);
        if (usuarioConsulta.getUsuario().equals(usuario)&&usuarioConsulta.getContrasenia().equals(contrasenia)){
        return true;

        }else {

        return false;}


    }else{

        return  false;
    }


    }
    public static boolean insertar(Usuario usuario) {
    return  usuarioDao.insertar(usuario);

    }

    public static boolean modificar(Usuario usuario) {

        return  usuarioDao.modificar(usuario);
    }

    public static boolean eliminar(String usuario) {
        return  usuarioDao.eliminar(usuario);


    }




    public static Usuario obtener(String usuario) {

        return  usuarioDao.obtener(usuario);

    }






}
