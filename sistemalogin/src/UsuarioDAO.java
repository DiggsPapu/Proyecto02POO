/**
 * Metodos para obtencion, insertar o agregar, eliminar y modificar los usuarios presentes en el arraylist
 */
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO(){
        usuarios = new ArrayList<>();


    }
    //recorrer arreglo
    public int buscar(String Usuario){
        int n = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getUsuario().equals(Usuario)){



                n=i;
                break;
            }
        }
        
        return n;
        
    }


    //pasar objeto usuario
    public boolean insertar(Usuario usuario){
        if(buscar(usuario.getUsuario())==-1){

            usuarios.add(usuario);
            return true;




        }else{

            return false;
        }




    }

    public boolean modificar(Usuario usuario){

        if(buscar(usuario.getUsuario())!=-1){

            Usuario usuarioaux=obtener(usuario.getUsuario());

            usuarioaux.setContrasenia(usuario.getContrasenia());
            usuarioaux.setNombres(usuario.getNombres());
            usuarioaux.setApellidos(usuario.getApellidos());
            usuarioaux.setCorreo(usuario.getCorreo());

            return true;


        }else{

            return false;
        }







    }

    public boolean eliminar(String usuario){


        if(buscar(usuario)!=-1){

            usuarios.remove(buscar(usuario));


            return true;




        }else{

            return false;
        }




    }

//funcion obtener necesario para modificar
    public Usuario obtener(String usuario){

        if (buscar(usuario)!=-1){
            return usuarios.get(buscar(usuario));
        }
        else{
            return null;//indica un objeto vacio


        }

    }


}
