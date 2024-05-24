package proyecto.inventarios.model;

import lombok.Data;

@Data
    public class LoginRequest {
        private String email;
        private String password;

        // Getters y setters
        public String getUsername() {
            return email;
        }


        public String getPassword() {
            return password;
        }

        // Getter y setter para email
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }



    }

