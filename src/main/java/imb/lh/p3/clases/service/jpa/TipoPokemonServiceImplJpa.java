package imb.lh.p3.clases.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.lh.p3.clases.entity.TipoPokemon;
import imb.lh.p3.clases.repository.ITipoPokemonRepository;
import imb.lh.p3.clases.service.ITipoPokemonService;

@Service
public class TipoPokemonServiceImplJpa implements ITipoPokemonService {
	
	@Autowired
	private ITipoPokemonRepository repo;

	@Override
	public List<TipoPokemon> getAllTipoPokemones() {
		return repo.findAll();
	}

}
