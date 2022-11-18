import java.util.ArrayList;

public class UserNormal implements User{
    private int id;
    private String name;
    private int age;
    private String password;
    private ArrayList<String> ruta;
    public UserNormal(int id,String name,int age,String password, ArrayList<String> ruta){
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.ruta = ruta;
    }
    /**
     * Metodos retornadores de rutas, id, nombre, edad, contrasenia, setters y getters.
     */
    public ArrayList<String> getRuta() {
        return ruta;
    }
    public void setRuta(ArrayList<String> ruta) {
        this.ruta = ruta;
    }
    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        return age;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    @Override
    public void setId(int id) {
        // TODO Auto-generated method stub
        this.id = id;   
    }
    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }
    @Override
    public void setAge(int age) {
        // TODO Auto-generated method stub
        this.age = age ;
    }
    @Override
    public void setPassword(String password) {
        // TODO Auto-generated method stub
        this.password = password;
    }
    
    
    
    
}