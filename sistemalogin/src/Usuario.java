
/**
 * Usuario con la presentacion de las caracteristicas del usuario
 */
public class Usuario {
    private String Usuario;
    private String contrasenia;
    private String nombres;
    private String apellidos;
    private String correo;

    public Usuario(String usuario, String contrasenia, String nombres, String apellidos, String correo) {
        Usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
