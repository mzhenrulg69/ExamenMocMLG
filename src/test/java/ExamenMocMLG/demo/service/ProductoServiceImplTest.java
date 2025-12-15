package ExamenMocMLG.demo.service;

import ExamenMocMLG.demo.Entity.Producto;
import ExamenMocMLG.demo.repository.ProductoRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    public void addProducto() {
        Producto producto = new Producto();
        producto.setNombre("Teclado");

        productoService.addProducto(producto);

        verify(productoRepository).save(producto);
    }

    @Test
    public void eliminarProductoById() {
        productoService.eliminarProductoById(1L);

        verify(productoRepository).findById(1L);
    }

    @Test
    public void findAllProductos_llamaAFindAll() {
        productoService.findAllProductos();

        verify(productoRepository).findAll();
    }
}