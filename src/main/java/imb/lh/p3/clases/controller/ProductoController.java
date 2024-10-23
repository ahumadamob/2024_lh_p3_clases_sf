package imb.lh.p3.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Producto;
import imb.lh.p3.clases.service.IProductoService;
import imb.lh.p3.clases.util.DTOResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService service;
	
	@GetMapping("/productos")
	DTOResponse<List<Producto>> mostrarTodosLosProductos(){
		DTOResponse<List<Producto>> response = new DTOResponse<>();
		List<Producto> lista = service.mostrarTodos();
		
		if(lista.isEmpty()) {
			//response.setError("No existe ningun producto");			
		}else {
			response.setData(lista);
		}
		
		return response;
	}
	
	@GetMapping("/productos/{id}")
	DTOResponse<Producto> mostrarProductosPorId(@PathVariable("id") Long id){
		DTOResponse<Producto> response = new DTOResponse<>();
		Producto producto = service.mostrarPorId(id);
		
		if(producto == null) {
			//response.setError("No existe el ID " + id.toString());
			
		}else {
			response.setData(producto);
		}		
		return response;
	}
	
	@PostMapping("/productos")
	DTOResponse<Producto> crearRegistro(@RequestBody Producto producto){
		DTOResponse<Producto> response = new DTOResponse<>();
		if(service.existe(producto.getId())) {
			//response.setError("Ya existe este elemento");
		}else {
			Producto productoGuardado = service.guardar(producto);
			response.setData(productoGuardado);
		}
		return response;

		
	}	
	
	@PutMapping("/productos")
	DTOResponse<Producto> actualizarRegistro(@RequestBody Producto producto){
		DTOResponse<Producto> response = new DTOResponse<>();
		if(service.existe(producto.getId())) {
			Producto productoGuardado = service.guardar(producto);
			response.setData(productoGuardado);
		}else {
			//response.setError("El elemento no existe");
		}
		return response;
	}
	
	@DeleteMapping("/productos/{id}")
	DTOResponse<?> eliminarRegistro(@PathVariable("id") Long id){
		if(service.existe(id)) {
			service.eliminar(id);
			return new DTOResponse<>(200, "El producto se eliminó", null);
		}else {
			return new DTOResponse<>(404, "El producto no existe", null);

		}
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	DTOResponse<Producto> controladorDeExcepciones(ConstraintViolationException e){
		List<String> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }
		DTOResponse<Producto> response = new DTOResponse<>(404, errors,null);
		return response;
	}
	
	/*
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<Task>> handleConstraintViolationException(ConstraintViolationException ex) {
    	return ResponseUtil.handleConstraintException(ex);
    } 	*/

}
