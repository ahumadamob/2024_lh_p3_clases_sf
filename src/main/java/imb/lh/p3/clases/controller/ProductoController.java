package imb.lh.p3.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Producto;
import imb.lh.p3.clases.service.IProductoService;
import imb.lh.p3.clases.util.ApiResponse;

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService service;
	
	@GetMapping("/productos")
	ApiResponse<List<Producto>> mostrarTodosLosProductos(){
		ApiResponse<List<Producto>> response = new ApiResponse<>();
		List<Producto> lista = service.mostrarTodos();
		
		if(lista.isEmpty()) {
			//response.setError("No existe ningun producto");			
		}else {
			response.setData(lista);
		}
		
		return response;
	}
	
	@GetMapping("/productos/{id}")
	ApiResponse<Producto> mostrarProductosPorId(@PathVariable("id") Long id){
		ApiResponse<Producto> response = new ApiResponse<>();
		Producto producto = service.mostrarPorId(id);
		
		if(producto == null) {
			//response.setError("No existe el ID " + id.toString());
			
		}else {
			response.setData(producto);
		}		
		return response;
	}
	
	@PostMapping("/productos")
	ApiResponse<Producto> crearRegistro(@RequestBody Producto producto){
		ApiResponse<Producto> response = new ApiResponse<>();
		if(service.existe(producto.getId())) {
			//response.setError("Ya existe este elemento");
		}else {
			Producto productoGuardado = service.guardar(producto);
			response.setData(productoGuardado);
		}
		return response;
	}	
	
	@PutMapping("/productos")
	ApiResponse<Producto> actualizarRegistro(@RequestBody Producto producto){
		ApiResponse<Producto> response = new ApiResponse<>();
		if(service.existe(producto.getId())) {
			Producto productoGuardado = service.guardar(producto);
			response.setData(productoGuardado);
		}else {
			//response.setError("El elemento no existe");
		}
		return response;
	}
	
	@DeleteMapping("/productos/{id}")
	String eliminarRegistro(@PathVariable("id") Long id){
		if(service.existe(id)) {
			service.eliminar(id);
			return "El producto se eliminó";
		}else {
			return "El id no existe";
		}
		
	}

}
