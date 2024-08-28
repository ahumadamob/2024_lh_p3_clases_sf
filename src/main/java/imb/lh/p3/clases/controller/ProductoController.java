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

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService service;
	
	@GetMapping("/productos")
	List<Producto> mostrarTodosLosProductos(){
		return service.mostrarTodos();
	}
	
	@GetMapping("/productos/{id}")
	Producto mostrarProductosPorId(@PathVariable("id") Long id){
		return service.mostrarPorId(id);
	}
	
	@PostMapping("/productos")
	Producto crearRegistro(@RequestBody Producto producto){
		return service.guardar(producto);
	}	
	
	@PutMapping("/productos")
	Producto actualizarRegistro(@RequestBody Producto producto){
		return service.guardar(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	void eliminarRegistro(@PathVariable("id") Long id){
		service.eliminar(id);
	}

}
