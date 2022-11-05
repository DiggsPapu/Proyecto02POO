
import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Diego Alonzo 20172
 */
public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static Cities citi = new Cities();
	public static Brain brain =  new Brain();
		public static void printRoute(ArrayList<String> route){
		if (route== null){
			System.out.println("No existe alguna de las ciudades ingresadas\n");
		}
		else {
			System.out.println(String.valueOf(brain.getDistance(route)));
		}
	}
	public static void printCities(){
		for (int k = 0 ; k < brain.getCities().getCities().size() ; k ++){
			System.out.println(String.valueOf(k)+"- "+brain.getCities().getCities().get(k));
		}
	}
	public static void printPrincipalMenu(){
		System.out.println("Ingresa una opcion de las siguientes:\n1- Ingreso de usuario\n2- Informacion del impacto del CO2\n3- Creacion de usuario\n4- Salir");
	}
	public static void userMenu(User user){
		if (user != null && user.getClass() == UserNormal.class ){
			System.out.println("Bienvenido al portal usuario "+user.getName());
		}
		else if (user != null && user.getClass() == Admin.class ){
			System.out.println("Bienvenido al portal administrador"+ user.getName());
		}
		else{
			System.out.println("El usuario/contrasenia ingresada es invalido");
		}
	}
	public static int enterInteger(){
		while (true){
			try {
				System.out.print("Ingrese un entero: ");
				int value = Integer.parseInt(scan.nextLine());
				return value;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("El valor ingresado es invalido, intentelo nuevamente");
			}
		}
	}
	public static void createUser(){
		System.out.print("Ingresa el nombre: ");
		String name = scan.nextLine();
		System.out.print("Ingresa el password: ");
		String contra = scan.nextLine();
		System.out.print("Ingresa la edad: ");
		int edad = enterInteger();
		System.out.print("Ingresa la placa del auto: ");
		String plate = scan.nextLine();
		int identifier = brain.getNewId();
		System.out.println("El id es: "+String.valueOf(identifier));
		User user = new UserNormal(identifier, name, edad, plate, contra);
		brain.createUser(user);
		System.out.println("El usuario fue correctamente creado");
	}
	/**
	 * Es el main
	 * @param args
	 */
	// C:\Users\Windows 10\Documents\UVG\CODING\Semestre 4\POO\Proyectos\Proyecto2\Others\Rutas2.txt
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean keepInApp = true;
		while (keepInApp) {
			printPrincipalMenu();
			String option = scan.nextLine();
			switch(option){
				case "1":
				System.out.println("Ingresa el id de usuario:");
				int id = enterInteger();
				System.out.println("Ingresa el password del usuario de usuario:");
				String password = scan.nextLine();
				userMenu(brain.logIn(id, password));
				break;
				case "2":
				break;
				case "3":
				createUser();
				break;
				case "4":
				keepInApp = false;
				break;
				default:
				System.out.println("La opcion ingresada es invalida");
				break;
			}
		}
		// 	String opcion = View.getOption();
		// 	if (opcion.equals("1")) {
		// 		printCities();
		// 		System.out.print("Ingrese la ciudad 1: ");
		// 		String ciudad1 = teclado.nextLine() ;
		// 		System.out.print("Ingrese la ciudad 2: ");
		// 		String ciudad2 = teclado.nextLine() ;
		// 		printRoute(brain.getRoute(ciudad1, ciudad2));
		// 	}else if( opcion.equals("2")){
		// 		System.out.print("La ciudad mas centralizada es: " + citi.getCenter() + "\n");
		// 	}else if( opcion.equals("3")){
		// 		System.out.print("Ingrese la ciudad 1: ");
		// 		String ciudad1 = teclado.nextLine() ;
		// 		System.out.print("Ingrese la ciudad 2: ");
		// 		String ciudad2 = teclado.nextLine() ;
		// 		System.out.print("Ingrese el cambio en km: ");
		// 		try {
		// 			String km = teclado.nextLine() ;
		// 			citi.changeRouteStatus(ciudad1, ciudad2,Integer.valueOf(km)) ;
		// 		}catch (Exception e){
		// 			System.out.print("No ingreso una cantidad de km valida\n") ;
		// 		}
				
		// 	}else if( opcion.equals("4")){
		// 		System.out.print("Ingrese la ciudad 1: ") ;
		// 		String ciudad1 = teclado.nextLine() ;
		// 		System.out.print("Ingrese la ciudad 2: ") ;
		// 		String ciudad2 = teclado.nextLine() ;
		// 		citi.changeRouteStatus(ciudad1, ciudad2, null) ;
		// 	}else if(opcion.equals("5")) {
		// 		System.out.print("Gracias por usar nuestro programa\n") ;
		// 		break ;
		// 	}else if (opcion.equals("6")){
		// 		View.printMatrix(citi.getOriginal());
		// 	}
		// 	else if (opcion.equals("7")){
		// 		for (int k = 0 ; k < citi.getCities().size() ; k++ ){
		// 			System.out.println(citi.getCities().get(k));
		// 		}
		// 	}
		// 	else {
		// 		System.out.print("No ingreso una opcion valida, vuelvalo a intentar\n");
		// 	}
		// }
		// teclado.close();
	}
	

}
