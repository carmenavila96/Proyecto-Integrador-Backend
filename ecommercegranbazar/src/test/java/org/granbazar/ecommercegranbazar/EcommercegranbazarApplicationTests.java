package org.granbazar.ecommercegranbazar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.granbazar.ecommercegranbazar.model.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class EcommercegranbazarApplicationTests {
   
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Disabled("Para deshabilitarlo")
	@DisplayName("Se prueba el enpoint http://localhost:8080/api/productos/3")
	void pruebaGET() throws Exception {
		
		this.mockMvc.perform(get("/api/productos/3"))
		        .andDo(print())
		        .andExpect(status().isOk())
		        .andExpect(content().string(
		        		containsString("Tostadora rosa")
		        		));
		
	}//pruebaGET
	
	
	@Test
	//@Disabled("Desabilitado una vez que ha sido probado")
	@DisplayName("Se borrá el producto en el enpoint http://localhost:8080/api/productos/8")
	void pruebaDELETE() throws Exception {
		
		this.mockMvc.perform(delete("/api/productos/8"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(
        		containsString("Cuaderno Profesional")
        		));
		
	}//pruebaDELETE
	
	
	@Test
	@Disabled("Para deshabilitarlo")
	@DisplayName("Se agrega un nuevo producto")
	void pruebaPOST() throws Exception {
		Producto p = new Producto();
		p.setNombre("Cuaderno Profesional vintage");
		p.setEstadoProducto("Nuevo con eqtiqueta");
		p.setDescripcion("Hermoso cuaderno vintage");
		p.setPrecio(500.0);
		p.setImagen("cuaderno.jpg");
		p.setEnvio("Fedex");
	
		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				//.header("Authorization", Bearer: Token")
                .content(asJsonString(p)   ))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(
        		containsString("Cuaderno Profesional vintage")//Debe ser igual que el de setNombre();
        		));
	}//pruebaPOST
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

	
	
	@Test
	@Disabled("Para deshabilitarlo")
	@DisplayName("Se modifica el producto 9 con un nuevo precio")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/productos/9")
				.queryParam("precio", "52.25"))// La base de datos recorta .20 (decimales con 0) a .2 por ejemplo, escribirlo así. En los otros como .25 si lo respeta.
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(
        		containsString("52.25")
        		));
	}//pruebaPUT
	
	

}//class
