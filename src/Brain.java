import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Brain {
    private ArrayList<User> users = new ArrayList<>();
    private Cities cities = new Cities();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<String> getRoute(String city1, String city2){
        return cities.getRouteArrayList(city1, city2);
    }
    public String getDistance(ArrayList<String> route){
        return cities.routeAndDistance(route);
    }
    public Cities getCities() {
        return cities;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    public User logIn(int id, String passwrod){
        for (int k = 0 ; k < users.size() ; k++ ){
            if (users.get(k).getId()== id && users.get(k).getPassword().equals(passwrod)){
                return users.get(k);
            } 
        }
        return null;
    }
    public void createVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void createUser(User user){
        users.add(user);
    }
    public int getNewId(){
        return users.size();
    }
    public Vehicle searchVehicle(User user){
        for (int k = 0 ; k < vehicles.size() ; k ++ ){
            if (vehicles.get(k).getId() == user.getId()){
                return vehicles.get(k);
            }
        }
        return null;
    }
    public String myCO2(User user){
        Vehicle vehicle = searchVehicle(user);
        UserNormal usern = (UserNormal) user;
        int CO2D = 2640;//CO2 se necesitan 1920 gramos de oxígeno. Si efectuamos la misma operación y sumamos, obtenemos 2640 gramos de CO2 por cada litro de diesel.
        int CO2G =2392;//un motor necesita unos 1740 gramos de oxígeno por litro. Habría que sumar los 652 gramos del combustible a los 1740 gramos de oxígeno.
        int Total = 0;
        if ( vehicle.getGasType()== "Gasolina"){
            Total = (CO2G*6)/100;
        }
        else if (vehicle.getGasType() == "Diesel"){  
            Total = (CO2D*5)/100;
        }
        return ("Para la ruta normal: \n"+getDistance(usern.getRuta())+"\n"+Total + " gramos de CO2 por cada kilómetro recorrido.\nEl total de gramos por el tramo es "+String.valueOf(Total*cities.distance(usern.getRuta())));
    } 
    public String getOptimusCar(UserNormal user){
        return "";
    }  
    /**
	 * Method to save the db
	 */
	public String saveFile() {
		File userfile = new File ("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Users.csv");
		File vehiclesfile = new File ("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Vehicles.csv");
		try {
			FileWriter pL = new FileWriter(userfile);
			FileWriter pS = new FileWriter(vehiclesfile);
			BufferedWriter pLW = new BufferedWriter(pL);
			BufferedWriter pSW = new BufferedWriter(pS);
			pLW.write("id,name,age,password,route");
			pLW.newLine();
			pSW.write("user_id,plate,vehicle_type,gas_type");
			pSW.newLine();
			for (int k = 0 ; k < users.size(); k++ ) {
				pLW.write(fileUsers(k));
					pLW.newLine();
			}
			for (int k = 0 ; k < vehicles.size() ; k++ ){
				pSW.write(fileVehicles(k));
				pSW.newLine();
			}
			pLW.close();
			pSW.close();
			pL.close();
			pS.close();
			return "La base de datos fue existosamente guardada\n";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "La base de datos no pudo ser guardada\n";
		}
	}
	/**
	 * Method to make a string of file users while saving the db.
	 * @param index
	 * @return string
	 */
	private String fileVehicles(int index ){
		String line = "";
		line += String.valueOf(vehicles.get(index).getId())+",";
		line += vehicles.get(index).getLicensePlate()+",";
		line += vehicles.get(index).getVehicleType()+",";
		line += vehicles.get(index).getGasType();
		return line;
	}
    /**
	 * Method to make a string of file users while saving the db.
	 * @param index
	 * @return string
	 */
	private String fileUsers(int index) {
		String pLfile = "";
		pLfile+= users.get(index).getId()+",";
		pLfile+= users.get(index).getName()+",";
		pLfile+= users.get(index).getAge()+",";
		pLfile+= users.get(index).getPassword()+",";
        String route = "";
        if (users.get(index).getClass()==UserNormal.class){
            UserNormal userNormal = (UserNormal) users.get(index);
            ArrayList<String> ruta = userNormal.getRuta();
            for (int k = 0 ; k < ruta.size()-1 ; k++ ){
                route += ruta.get(k)+" ";
            }
			route += ruta.get(ruta.size()-1);
        }
        else{
            route += "None";
        }
        pLfile+= route;
		return pLfile;
	}
	/**
	 * Metodo para cargar la data
	 * @return
	 */
    public String loadData() {
		File userFile = new File ("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Users.csv");
		File vehiclesFile = new File ("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Vehicles.csv");
		try {
			if (!userFile.createNewFile() && !vehiclesFile.createNewFile() ) {
				BufferedReader pLB = new BufferedReader(new FileReader("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Users.csv"));
				BufferedReader pSB = new BufferedReader(new FileReader("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Vehicles.csv"));
				String line;
				pLB.readLine();
				while ((line = pLB.readLine())!=null){
					String [] pL = line.split(",");
					System.out.println("Normal user");
					System.out.println(pL[pL.length-1]);
					if (!pL[pL.length-1].equals("None")){
						System.out.println("Route");
						String [] route = pL[pL.length-1].split(" ");
						System.out.println(route[0]);
						ArrayList<String> ruta = new ArrayList<>();
						for (int k = 0 ; k < route.length ; k++ ){
							ruta.add(route[k]);
							System.out.println("ruta: "+route[k]);
						}
						int id = Integer.parseInt(pL[0]);
						String name = pL[1];
						int age = Integer.parseInt(pL[2]);
						String password = pL[3];
						// "id,name,age,password,route"
						System.out.println("Create normal user");
						System.out.println(id);
						System.out.println(name);
						System.out.println(age);
						System.out.println(password);
						System.out.println(ruta);
						User newPL = (User) new UserNormal(id,name,age,password,ruta);
						this.users.add(newPL);
					}
					else{
						System.out.println("Admin");
						User newPL = (User) new Admin(Integer.parseInt(pL[0]),pL[1],Integer.parseInt(pL[2]),pL[3]);
						this.users.add(newPL);
					}
				}
				pSB.readLine();
				while ((line = pSB.readLine())!=null){
					String [] ps = line.split(",");
					// "user_id,plate,vehicle_type,gas_type"
					Vehicle vehicle = new Vehicle(Integer.parseInt(ps[0]), ps[1], ps[2], ps[3]);
					this.vehicles.add(vehicle);
				}
				pLB.close();
				pSB.close();
				return ("The db was succesfully loaded\n");
				
			}
			else {
				return ("There is no data yet\n");
			}
			
		}
		catch(Exception e) {
			return ("The data base couldn't be loaded\n");
		}
	}
}
    // Crear persistencia de datos de usuarios
    // Crear funciones de aniadir usuarios
    // Crear funciones de modificar usuarios

