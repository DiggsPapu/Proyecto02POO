
/**
 * @author Augusto Sanic 20717
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main donde se presenta la parte del login
 * @paramargs
 */
public class Main {

    public static void main(String[] args) {
        int contador =0;
        System.out.println("Selecciona la opcion 1 iniciar sesion, opcion 2 registra, opcion 3 modificar, opcion 4 borrar, opcion 5 salir");
        while(contador == 0){
        Scanner teclado = new Scanner(System.in);
        String opcion = teclado.nextLine();

        if (opcion.equals("1")) {
            System.out.println("Ingrese usuario");
            String usuario = teclado.nextLine();
            System.out.println("Ingrese contraseña");
            String contrasenia = teclado.nextLine();
            if(UsuarioLogic.autentificar(usuario, contrasenia)){
                System.out.println("Bienvenido");

            }else{
                System.out.println("Usuario o contrasenia incorrectos");
            }
        } else if (opcion.equals("2")) {//registrar
            System.out.println("Ingrese usuario");
            String Usuario = teclado.nextLine();
            System.out.println("Ingrese contraseña");
            String contrasenia = teclado.nextLine();
            System.out.println("Ingrese nombres");
            String nombres = teclado.nextLine();
            System.out.println("Ingrese apellidos");
            String apellidos = teclado.nextLine();
            System.out.println("Ingrese correo");
            String correo = teclado.nextLine();
            Usuario usuario = new Usuario(Usuario, contrasenia, nombres, apellidos, correo);
            if(UsuarioLogic.insertar(usuario)){

                System.out.println("Usuario registrado exitosamente");
            }else{

                System.out.println("Usuario ya registrado");
            }

        } else if (opcion.equals("3")) {//modificar
            System.out.println("Ingrese usuario");
            String Usuario = teclado.nextLine();
            System.out.println("Ingrese contraseña");
            String contrasenia = teclado.nextLine();
            System.out.println("Ingrese nombres");
            String nombres = teclado.nextLine();
            System.out.println("Ingrese apellidos");
            String apellidos = teclado.nextLine();
            System.out.println("Ingrese correo");
            String correo = teclado.nextLine();
            Usuario usuario = new Usuario(Usuario, contrasenia, nombres, apellidos, correo);
            if(UsuarioLogic.modificar(usuario)){

                System.out.println("Usuario MODIFICADO exitosamente");
            }else{

                System.out.println("Usuario no encontrado");
            }

        }else if(opcion.equals("4")){//borrar
            String Usuario = teclado.nextLine();

            if(UsuarioLogic.eliminar(Usuario)){

                System.out.println("Usuario eliminado exitosamente");
            }else{

                System.out.println("Usuario no encontrado");
            }


        } else if (opcion.equals("5")) {
            contador = 1;
        }


        }


    }}
