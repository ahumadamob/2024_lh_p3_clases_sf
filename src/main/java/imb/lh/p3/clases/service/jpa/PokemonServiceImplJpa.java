package imb.lh.p3.clases.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.lh.p3.clases.entity.Pokemon;
import imb.lh.p3.clases.repository.PokemonRepository;
import imb.lh.p3.clases.service.IPokemonService;

@Service
public class PokemonServiceImplJpa implements IPokemonService {
	
	@Autowired
	private PokemonRepository repo;

	@Override
	public List<Pokemon> getAllPokemones() {
		return repo.findAll();
	}

}
