package proyecto.inventarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

/*aqui es donde se crea la cabecera de la tabla*/

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer idProduct;
    String description;
    String talla;
    Double price;
    Integer stock;

}
