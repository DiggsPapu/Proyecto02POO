public class Admin implements User {
    private int id;
    private String name;
    private int age;
    private String password;
    public Admin(int id,String name,int age,String password){
        this.id = id;
        this.name = name;
        this.age = age;
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
