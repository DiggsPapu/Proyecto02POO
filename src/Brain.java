import java.util.ArrayList;

public class Brain {
    private ArrayList<User> users = new ArrayList<>();
    private Cities cities = new Cities();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<String> getRoute(String city1, String city2){
        return cities.getRouteArrayList(city1, city2);
    }
    public String getDistance(ArrayList<String> route){
        return cities.distance(route);
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
    // Crear persistencia de datos de usuarios
    // Crear funciones de aniadir usuarios
    // Crear funciones de modificar usuarios
}
