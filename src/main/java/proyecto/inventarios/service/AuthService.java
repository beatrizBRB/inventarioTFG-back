package proyecto.inventarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.inventarios.model.User;
import proyecto.inventarios.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {

       User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            // Verificar si la contraseña y el email coinciden
            return user.getPassword().equals(password) && user.getEmail().equals(email);
        }
        return false;
    }

}
