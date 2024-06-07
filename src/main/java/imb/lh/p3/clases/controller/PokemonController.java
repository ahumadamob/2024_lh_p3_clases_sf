package imb.lh.p3.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Pokemon;
import imb.lh.p3.clases.service.IPokemonService;

@RestController
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	@GetMapping("/pokemones")
	public List<Pokemon> buscarPokemones() {
		return service.getAllPokemones();
	}

}
