package ExamenMocMLG.demo.Controller;

import ExamenMocMLG.demo.service.ProductoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.reflect.Array.get;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoServiceImpl;

    @Test
    public void getProductos() throws Exception {
        mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) get("/apirest/productos"))
                .andExpect(status().isOk());
    }

    private Object get(String path) {
        return null;
    }


    @Test
    public void addProducto() throws Exception {
        mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) post("/apirest/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf("""
                    {
                      "nombre": "Teclado",
                      "descripcion": "USB",
                      "categoria": "Electronica",
                      "precio": 20
                    }
                """)))
                .andExpect(status().isOk());
    }



}