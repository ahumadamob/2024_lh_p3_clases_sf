package imb.lh.p3.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.ahumada.todo.util.APIResponse;

import imb.lh.p3.clases.entity.Pokemon;
import imb.lh.p3.clases.service.IPokemonService;
import imb.lh.p3.clases.util.ApiResponse;

@RestController
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	@GetMapping("/pokemones")
	public ApiResponse<List<Pokemon>> buscarPokemones() {
		ApiResponse<List<Pokemon>> dto = new ApiResponse<>();
		List<Pokemon> listadoPokemon = service.obtenerTodos();
		
		dto.setStatus(200);
		dto.setError(null);
		dto.setData(listadoPokemon);
		return dto;
		//return service.obtenerTodos();
	}
	
	@GetMapping("/pokemon/{id}")
	public ApiResponse<Pokemon> buscarPokemonesPorId(@PathVariable("id") Long id){
		ApiResponse<Pokemon> dto = new ApiResponse<>();		
		if(service.existe(id)) {
			dto.setStatus(200);
			dto.setData(service.obtenerPorId(id));
		}else {
			dto.setStatus(404);
			List<String> errores = new ArrayList();
			errores.add("No existe este Pokemon.");
			errores.add("Vuelva mas tarde");
			dto.setError(errores);
			
		}
		return dto;
		//return service.obtenerPorId(id);
	}
	
	@PostMapping("/pokemon")
	public ApiResponse<Pokemon> crearPokemon(@RequestBody Pokemon pokemon) {
		if(service.existe(pokemon.getId())) {
			// Error
			ApiResponse<Pokemon> dto = new ApiResponse<Pokemon>(
														404, 
														"El id " + pokemon.getId().toString() + " SI existe",
														null);
			return dto;
		}else {
			// Exito
			ApiResponse<Pokemon> dto = new ApiResponse<Pokemon>(
					200, 
					"",
					service.guardar(pokemon));
			return dto;
		}
	}
	
	@PutMapping("/pokemon")
	public ResponseEntity<ApiResponse<Pokemon>> actualizarPokemon(@RequestBody Pokemon pokemon){
		if(service.existe(pokemon.getId())) {
			ApiResponse<Pokemon> dto = new ApiResponse<Pokemon>(200,"",service.guardar(pokemon));
			return ResponseEntity.ok().body(dto);
		}else {
			ApiResponse<Pokemon> dto = new ApiResponse<Pokemon>(404,"El id " + pokemon.getId().toString() + " SI existe",null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
			//ResponseEntity.accepted().body(null);
		}
		//return service.guardar(pokemon);
		
		//APIResponse<T> response = new APIResponse<>(HttpStatus.NOT_FOUND.value(), message(message.replace("{0}", id.toString())), null);
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@DeleteMapping("/pokemon/{id}")
	public String eliminarPokemon(@PathVariable("id") Long id) {
		service.eliminar(id);
		return "El proceso de eliminación se completó";
	}

}
