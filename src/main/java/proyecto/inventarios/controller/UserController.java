package proyecto.inventarios.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.inventarios.dto.UserDTO;
import proyecto.inventarios.model.User;
import proyecto.inventarios.repository.UserRepository;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

        log.error("enpoint para registro");

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}
