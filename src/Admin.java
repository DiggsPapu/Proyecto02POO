public class Admin implements User {
    private int id;
    private String name;
    private int age;
    private String plate;
    private String password;
    public Admin(int id,String name,int age,String plate,String password){
        this.id = id;
        this.name = name;
        this.age = age;
        this.plate = plate;
        this.password = password;
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
    public String getPlate() {
        // TODO Auto-generated method stub
        return plate;
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
        
    }
    @Override
    public void setPlate(String plate) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void setAge(int age) {
        // TODO Auto-generated method stub
        this.age = age ;
    }
    
}
