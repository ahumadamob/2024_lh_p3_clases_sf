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

import imb.lh.p3.clases.entity.Pokemon;
import imb.lh.p3.clases.service.IPokemonService;

@RestController
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	@GetMapping("/pokemones")
	public List<Pokemon> buscarPokemones() {
		return service.obtenerTodos();
	}
	
	@GetMapping("/pokemon/{id}")
	public Pokemon buscarPokemonesPorId(@PathVariable("id") Long id){
		return service.obtenerPorId(id);
	}
	
	@PostMapping("/pokemon")
	public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
		return service.guardar(pokemon);
	}
	
	@PutMapping("/pokemon")
	public Pokemon actualizarPokemon(@RequestBody Pokemon pokemon){
		return service.guardar(pokemon);
	}
	
	@DeleteMapping("/pokemon/{id}")
	public String eliminarPokemon(@PathVariable("id") Long id) {
		service.eliminar(id);
		return "El proceso de eliminación se completó";
	}

}
