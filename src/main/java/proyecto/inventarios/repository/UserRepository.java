package proyecto.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.inventarios.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
