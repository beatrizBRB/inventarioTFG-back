package proyecto.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.inventarios.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
