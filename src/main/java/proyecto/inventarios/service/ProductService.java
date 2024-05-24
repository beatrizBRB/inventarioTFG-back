package proyecto.inventarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.inventarios.model.Producto;
import proyecto.inventarios.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductoRepository productoRepository; //de esta manera la capa de servicio se está comunicando con la capa de repositorio

    @Override
    public List<Producto> ListarProductos() {
        return this.productoRepository.findAll(); //este método me traera todos los objetos de tipo producto de la bd

    }

    @Override
    public Producto buscarProductoPorId(Integer idProduct) {
        Producto producto = this.productoRepository.findById(idProduct).orElse(null);
            return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepository.save(producto);

    }

    @Override
    public void eliminarProductoPorId(Integer idProduct) {
        this.productoRepository.deleteById(idProduct);
    }


   
}
