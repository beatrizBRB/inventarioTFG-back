package proyecto.inventarios.dto;

public class UserDTO {

    private String email;
    private String password;

    // Constructor vacío
    public UserDTO() {
    }

    // Getters y setters para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters y setters para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
