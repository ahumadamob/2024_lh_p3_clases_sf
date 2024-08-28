package imb.lh.p3.clases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.lh.p3.clases.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	public List<Pokemon> findByNombre(String nombre);

	
	// select * from pokemon where nombre = 'hghghg'
}
