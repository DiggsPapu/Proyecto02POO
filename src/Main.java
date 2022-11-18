import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Diego Alonzo 20172
 */
public class Main {
	/**
	 * Atributos estaticos del main
	 */
	public static Scanner scan = new Scanner(System.in);
	public static Cities citi = new Cities();
	public static Brain brain =  new Brain();
	/**
	 * Metodo para imprimir rutas
	 * @param route
	 */
		public static void printRoute(ArrayList<String> route){
		if (route== null){
			System.out.println("No existe alguna de las ciudades ingresadas\n");
		}
		else {
			System.out.println(String.valueOf(brain.getDistance(route)));
		}
	}
	/**
	 * Metodo para imprimir ciudades
	 */
	public static void printCities(){
		for (int k = 0 ; k < brain.getCities().getCities().size() ; k ++){
			System.out.println("Ciudad: "+brain.getCities().getCities().get(k));
		}
	}
	/**
	 * Metodo para ingresar enteros
	 * @return
	 */
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
	/**
	 * Metodo para chequear ciudades
	 * @return
	 */
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
	/**
	 * Metodo para ingresar rutas
	 * @return
	 */
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
	/**
	 * Metodo para crear usuarios
	 */
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
	/**
	 * Metodo para ingresar un id valido al momento de loggearse 
	 * @return
	 */
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
	/**
	 * Metodo para cambiar de vehiculo
	 * @param user
	 */
	private static void changeVehicle(User user){
		boolean keepInChanges = true;
		Vehicle vehicle = brain.searchVehicle(user);
		while (keepInChanges && vehicle!= null){
			System.out.println("Selecciona entre las siguientes opciones\n1- Cambiar el tipo de vehiculo\n2- Cambiar el tipo de combustible\n3- Salir");
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
	/**
	 * Metodo para ingresar el menu de administrador
	 * @param user
	 */
	private static void adminMenu(User user){
		boolean keepInMenu = true;
		while (keepInMenu){
			System.out.println("Selecciona entre estas opciones:\n1- Crear un nuevo usuario\n2- Modificar un usuario\n3- Modificar un vehiculo\n4- Salir\n");
			switch (scan.nextLine()) {
				case "1":
				createUser();
				break;
				case "2":
				changeUser(getValidId());
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
	/**
	 * Metodo para ingresar un tipo de gasolina
	 * @return
	 */
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
	/**
	 * Metodo para crear vehiculo
	 * @param id
	 * @return
	 */
	private static Vehicle createVehicle(int id){
		System.out.print("Ingrese la placa del auto: ");
		String plate = scan.nextLine();
		System.out.print("Ingrese el tipo de vehiculo: ");
		String type = scan.nextLine();
		Vehicle vehicle = new Vehicle(id, plate, type, enterGas());
		return vehicle;
	}
	/**
	 * Metodo para imprimir el menu de usuario
	 * @param user
	 */
	private static void userMenu(User user){
		boolean keepInMenu = true;
		UserNormal usern = (UserNormal) user;
		while (keepInMenu){
			System.out.println("Selecciona entre las siguientes opciones:\n1- Mi dioxido de carbono\n2- Mi ruta optima\n3- Mi carro optimo\n4- Chequear tu perfil\n5- Cambiar tu perfil\n6- Salir");
			switch (scan.nextLine()){
				case "1":
				System.out.println("Esta opcion te despliega cuanto dioxido de carbono produces basado en el consumo que realizas\n");
				System.out.println(brain.myCO2(user));;
				break;
				case "2":
				System.out.println("Esta opcion despliega la ruta optima\n");
				
				ArrayList<String> optimusroute = (brain.getRoute(usern.getRuta().get(0), usern.getRuta().get(usern.getRuta().size()-1)));
				for (int u = 0 ; u < optimusroute.size()-1 ; u++){
					System.out.print(optimusroute.get(u));
					System.out.print("->");
				}
				System.out.print(optimusroute.get(optimusroute.size()-1));
				System.out.println("\nLa distancia recorrida es de: "+String.valueOf(citi.distance(optimusroute)));
				break;
				case "3":
				System.out.println("Esta opcion despliega el carro optimo para la ruta ingresada\n");
				System.out.println(brain.getOptimusCar(usern));
				break;
				case "4":
				System.out.println("Nombre: "+usern.getName()+"\nEdad: "+String.valueOf(usern.getAge())+"\nPassword: "+usern.getPassword()+"\nId: "+usern.getId()+"\n");
				break;
				case "5":
				changeUser(usern.getId());
				break;
				case "6":
				keepInMenu = false;
				break;
				default:
				System.out.println("La opcion ingresada es invalida");
				break;
			}
		}
	}
	
	/**
	 * Metodo para cambiar de usuario
	 */
	private static void changeUser(int id){
		boolean keepInChanges = true;
		while (keepInChanges){
			System.out.println("Selecciona que atributo modificaras:\n1- Nombre\n2- Edad\n3- Contrasenia\n4- Cambiar la ruta\n5- Salir");
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
				UserNormal usern = (UserNormal) brain.getUsers().get(id);
				usern.setRuta(enterRoute());
				brain.getUsers().set(id, usern);
				case "5":
				keepInChanges = false;
				break;
				default:
				System.out.println("Ingrese un valor valido.");
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
		System.out.println(brain.loadData());;
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
					System.out.println("Bienvenido al portal administrador "+ user.getName());
					adminMenu((Admin) user);
				}
				else{
					System.out.println("El usuario/contrasenia ingresada es invalido");
				}
				break;
				case "2":
				System.out.println("QUE ES EL DIOXIDO DE CARBONO Y COMO IMPACTA EL PLANETA?\n\nLas emisiones excesivas de este gas incoloro, inodoro y compuesto por oxígeno y carbono son una de las principales causas del calentamiento global. Un problema causado por la actividad humana y agravado por la larga pervivencia del CO2 en la atmósfera. Ante la amenaza de una escala sin precedentes, se plantea el almacenamiento subterráneo.");
				System.out.println("En los últimos 800.000 años, la concentración de CO2 en la atmósfera fluctuó entre las 170 y 330 partes por millón (niveles muy aceptables para la sostenibilidad del planeta), pero desde los últimos 170 años, y de forma enormemente acelerada en las tres últimas décadas, se ha disparado hasta unos valores que alcanzan en la actualidad 415 partes por millón");
				System.out.println("Las emisiones de CO2 se han multiplicado y tienen consecuencias. Es un gas que contribuye al calentamiento del planeta aunque no sea el único. También otros gases naturales (metano, óxido nitroso) o artificiales (gases fluorados) forman parte de los tan mentados gases de efecto invernadero (GEI). De hecho, su aumento en la atmósfera es lo que desencadena el cambio climático, la crisis climática o la emergencia climática. Son tres términos muy cercanos que se utilizan para describir el calentamiento global que sufre la Tierra. Las estadísticas oficiales confirman que no han bajado las emisiones de CO2 durante los últimos años (exceptuando los meses de confinamientos y la caída drástica de la actividad en muchos países debido a la pandemia). En 2017, por ejemplo, la Unión Europea (UE) de los veintisiete emitió 3,9 Gton CO2e (gigatoneladas de dióxido de carbono equivalente). Esto representa el 7% de los GEI. Por esta razón, si la UE-27 alcanzara la neutralidad climática tendría un gran impacto en el desafío climático”, reflexiona Joseba Eceiza, socio de la consultora McKinsey & Company. Desde luego, no todos los ámbitos de actividad industrial emiten las mismas cantidades a la atmósfera. Las emisiones se reparten, sobre todo entre cinco sectores: transporte (28%), industria (26%), generación de electricidad (23%), edificios (13%) y agricultura (12%). Sin olvidar los combustibles fósiles, que son la principal fuente (80%) de GEI.");
				break;
				case "3":
				createUser();
				break;
				case "4":
				keepInApp = false;
				System.out.println(brain.saveFile());;
				break;
				default:
				System.out.println("La opcion ingresada es invalida");
				break;
			}
		}
	}
	

}