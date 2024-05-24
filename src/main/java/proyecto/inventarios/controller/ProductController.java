package proyecto.inventarios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import proyecto.inventarios.model.Producto;
import proyecto.inventarios.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

//http://localhost:8080/inventario-app
@RequestMapping("inventario-app")

//es necesario agregar esta notacion para poder dar permisos de que se realicen las peticiones al servidor,
// si no nos daría un error en consola de tipo CORS policity
@CrossOrigin(value = "http://localhost:4200")

public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    //http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> getProducts(){
        List<Producto> productos = this.productService.ListarProductos();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        return this.productService.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id){
        Producto producto = this.productService.buscarProductoPorId(id);

        if(producto != null)
            return ResponseEntity.ok(producto);
        else
            throw new RecursoNoEncontradoExcepcion("no se encontró el id: " + " especificado");

    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido){
        Producto producto = this.productService.buscarProductoPorId(id);
        if ( producto == null)
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        producto.setDescription(productoRecibido.getDescription());
        producto.setPrice(productoRecibido.getPrice());
        producto.setStock(productoRecibido.getStock());
        producto.setTalla(productoRecibido.getTalla());
        this.productService.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(
            @PathVariable int id){
        Producto producto = productService.buscarProductoPorId(id);
        if (producto == null)
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        this.productService.eliminarProductoPorId(producto.getIdProduct());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return  ResponseEntity.ok(respuesta);
    }







}
