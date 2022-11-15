/**
 * Clase padre usuario con caracteristicas iniciales.
 */
public interface User {
    public int getId();
    public String getName();
    public int getAge();
    public String getPassword();
    public void setId(int id);
    public void setName(String name);
    public void setAge(int age);
    public void setPassword(String password);
}
