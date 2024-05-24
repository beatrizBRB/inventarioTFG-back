/*aqui se agregan los métodos básicos para recuperar los datos de la base de datos*/

package proyecto.inventarios.service;

import proyecto.inventarios.model.Producto;

import java.util.List;

public interface IProductService {
    public List<Producto> ListarProductos();

    public Producto buscarProductoPorId(Integer idProduct);

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProduct);


}
