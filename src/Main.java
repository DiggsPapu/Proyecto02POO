
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
			System.out.println("Ciudad: "+brain.getCities().getCities().get(k));
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
	private static String checkCity(){
		while (true){
			printCities();
			System.out.print("Ingrese la ciudad: ");
			String city = scan.nextLine();
			if (brain.getCities().getCities().contains(city)){
				return city;
			}
			else{
				System.out.println("Ingrese una ciudad valida");
			}
		}
	}
	private static ArrayList<String> enterRoute(){
		ArrayList<String> route = new ArrayList<>();
		while (true){
			printCities();
			route.add(checkCity());
			System.out.print("Ya termino de ingresar la ruta? (s): ");
			if (scan.nextLine().equals("s")){
				return route;
			}
		}
	}
	private static void createUser(){
		int identifier = brain.getNewId();
		System.out.println("El id es: "+String.valueOf(identifier));
		System.out.print("Ingresa el nombre: ");
		String name = scan.nextLine();
		System.out.print("Ingresa el password: ");
		String contra = scan.nextLine();
		System.out.print("Ingresa la edad: ");
		int edad = enterInteger();
		Vehicle vehicle = createVehicle(identifier);
		brain.createVehicle(vehicle);
		User user = new UserNormal(identifier, name, edad, contra, enterRoute());
		brain.createUser(user);
		System.out.println("El usuario fue correctamente creado");
	}
	private static int getValidId(){
		while (true){
			System.out.println("Ingresa el id de usuario: ");
			try {
				return brain.getUsers().get(enterInteger()).getId();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("No existe el usuario ingresado");
			}
				
		}
	}
	private static void changeUser(){
		boolean keepInChanges = true;
		int id = getValidId();
		while (keepInChanges){
			System.out.println("Selecciona que atributo modificaras:\n1- Nombre\n2- Edad\n3- Contrasenia\n4- Salir");
			switch (scan.nextLine()) {
				case "1":
				System.out.println("Ingresa el nuevo nombre:");
				brain.getUsers().get(id).setName(scan.nextLine());
				break;
				case "2":
				System.out.println("Ingresa la nueva edad:");
				brain.getUsers().get(id).setAge(enterInteger());
				break;
				case "3":
				System.out.println("Ingresa la nueva contrasenia:");
				brain.getUsers().get(id).setPassword(scan.nextLine());
				break;
				case "4":
				keepInChanges = false;
				break;
				default:
				break;
			}
		}
	}
	private static void changeVehicle(User user){
		boolean keepInChanges = true;
		Vehicle vehicle = brain.searchVehicle(user);
		while (keepInChanges && vehicle!= null){
			System.out.println("Selecciona entre las siguientes opciones\n1- Cambiar el tipo de vehiculo\n2- Cambiar el tipo de combustible\n4- Salir");
			switch (scan.nextLine()) {
				case "1":
					System.out.print("Ingrese el tipo de vehiculo que es:  ");
					vehicle.setVehicle_type(scan.nextLine());
					break;
				case "2":
					System.out.print("Ingrese el tipo de combustible que usa:  ");
					vehicle.setGas_type(scan.nextLine());
					break;
				case "3":
				keepInChanges = false;
				break;
				default:
				System.out.println("La opcion ingresada no es valida");
					break;
			}
		}
	}
	private static void adminMenu(User user){
		boolean keepInMenu = true;
		while (keepInMenu){
			System.out.println("Selecciona entre estas opciones:\n1- Crear un nuevo usuario\n2- Modificar un usuario\n3- Modificar un vehiculo\n4- Salir\n");
			switch (scan.nextLine()) {
				case "1":
				createUser();
				break;
				case "2":
				changeUser();
				break;
				case "3":
				User usuario = brain.getUsers().get(getValidId());
				changeVehicle(usuario);
				break;
				case "4":
				keepInMenu = false;
				break;
				default:System.out.println("La opcion ingresada es invalida");
				break;
			}
		}
	}
	private static String enterGas(){
		while (true){
			System.out.print("Tipo de combustible?\n1- Gasolina\n2- Diesel\n");
			switch (scan.nextLine()) {
				case "1":
				return "Gasolina";
				case "2":
				return "Diesel";
				default:
					break;
			}			
		}
	}
	private static Vehicle createVehicle(int id){
		System.out.print("Ingrese la placa del auto: ");
		String plate = scan.nextLine();
		System.out.print("Ingrese el tipo de vehiculo: ");
		String type = scan.nextLine();
		Vehicle vehicle = new Vehicle(id, plate, type, enterGas());
		return vehicle;
	}
	private static void userMenu(User user){
		boolean keepInMenu = true;
		UserNormal usern = (UserNormal) user;
		while (keepInMenu){
			System.out.println("Selecciona entre las siguientes opciones:\n1- Mi dioxido de carbono\n2- Mi ruta optima\n3- Mi carro optimo\n4- Salir");
			switch (scan.nextLine()){
				case "1":
				System.out.println("Esta opcion te despliega cuanto dioxido de carbono produces basado en el consumo que realizas\n");
				System.out.println(brain.myCO2(user));;
				break;
				case "2":
				System.out.println("Esta opcion despliega la ruta optima\n");
				System.out.println(brain.getCities().routeAndDistance(brain.getRoute(usern.getRuta().get(0), usern.getRuta().get(usern.getRuta().size()-1))));
				break;
				case "3":
				System.out.println("Esta opcion despliega el carro optimo para la ruta ingresada\n");
				System.out.println(brain.getOptimusCar(usern));
				break;
				case "4":
				keepInMenu = false;
				break;
				default:
				System.out.println("La opcion ingresada es invalida");
				break;
			}
		}
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
			System.out.println("Ingresa una opcion de las siguientes:\n1- Ingreso de usuario\n2- Informacion del impacto del CO2\n3- Creacion de usuario\n4- Salir");
			String option = scan.nextLine();
			switch(option){
				case "1":
				System.out.println("Ingresa el id de usuario:");
				int id = enterInteger();
				System.out.println("Ingresa el password del usuario de usuario:");
				String password = scan.nextLine();
				User user = brain.logIn(id, password);
				if (user != null && user.getClass() == UserNormal.class ){
					System.out.println("Bienvenido al portal usuario "+user.getName());
					userMenu((UserNormal) user);
				}
				else if (user != null && user.getClass() == Admin.class ){
					System.out.println("Bienvenido al portal administrador"+ user.getName());
					adminMenu((Admin) user);
				}
				else{
					System.out.println("El usuario/contrasenia ingresada es invalido");
				}
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
