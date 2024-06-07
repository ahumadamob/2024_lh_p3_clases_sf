package imb.lh.p3.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.TipoPokemon;
import imb.lh.p3.clases.service.ITipoPokemonService;

@RestController
public class TipoPokemonController {
	
	@Autowired
	private ITipoPokemonService service;
	
	@GetMapping("/tipos")
	public List<TipoPokemon> todosLosTiposDePokemones(){
		return service.getAllTipoPokemones();
	}

}
