package imb.lh.p3.clases.service.jpa;

import java.util.List;
import java.util.Optional;

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
	public List<Pokemon> obtenerTodos() {
		 return repo.findAll();
	}

	@Override
	public Pokemon obtenerPorId(Long id) {
		Optional<Pokemon> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public Pokemon guardar(Pokemon pokemon) {
		return repo.save(pokemon);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

}
