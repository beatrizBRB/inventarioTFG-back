package proyecto.inventarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import proyecto.inventarios.model.LoginRequest;
import proyecto.inventarios.model.User;
import proyecto.inventarios.repository.UserRepository;
import proyecto.inventarios.service.AuthService;

import java.util.Optional;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = {"http://localhost:4200"})

public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Buscar el usuario por email y contraseña
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()));
        if (userOptional.isPresent()) {
            // Si se encuentra el usuario, se puede considerar la autenticación exitosa
            return ResponseEntity.ok().build();
        } else {
            // Usuario no encontrado o credenciales inválidas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}