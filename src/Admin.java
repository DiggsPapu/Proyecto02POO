public class Admin implements User {
    private int id;
    private String name;
    private int age;
    private Vehicle vehicle;
    private String password ;
    public String getPassword() {
        return password;
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
    public Vehicle getVehicle() {
        // TODO Auto-generated method stub
        return vehicle;
    }
    
}
