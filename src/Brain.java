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
    public User logIn(int id, String passwrod){
        for (int k = 0 ; k < users.size() ; k++ ){
            if (users.get(k).getId()== id && users.get(k).getPassword().equals(passwrod)){
                return users.get(k);
            } 
        }
        return null;
    }
    public void createUser(User user){
        users.add(user);
    }
    public int getNewId(){
        return users.size();
    }
    // Crear persistencia de datos de usuarios
    // Crear funciones de aniadir usuarios
    // Crear funciones de modificar usuarios
}
