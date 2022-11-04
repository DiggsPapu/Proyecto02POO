public class Admin implements User {
    private int id;
    private String name;
    private int age;
    private int plate;
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
    public int getPlate() {
        // TODO Auto-generated method stub
        return plate;
    }
    
}
