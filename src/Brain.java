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
}
    // Crear persistencia de datos de usuarios
    // Crear funciones de aniadir usuarios
    // Crear funciones de modificar usuarios

