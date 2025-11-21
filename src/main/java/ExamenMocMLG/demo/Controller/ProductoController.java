package ExamenMocMLG.demo.Controller;

import ExamenMocMLG.demo.Entity.Producto;
import ExamenMocMLG.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductoController {

    @Autowired
    private ProductoService productoServiceImpl;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoServiceImpl.addProducto(producto);

    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        this.productoServiceImpl.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoServiceImpl.modificarProducto(productoId,producto);
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {
        /*
            - Si no se indica ni precio ni categoría -> obtener todos los productos.
            - Si se indica el precio -> obtener los productos con ese precio.
            - Si se indica la categoria -> obtener los productos con esa categoria.
         */


    }

    @GetMapping(value = "/producto/{productoId}")
    public List<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoServiceImpl.findAllProductos();
    }

}
