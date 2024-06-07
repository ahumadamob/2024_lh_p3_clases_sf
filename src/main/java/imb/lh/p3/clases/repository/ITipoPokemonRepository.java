package imb.lh.p3.clases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.lh.p3.clases.entity.TipoPokemon;

public interface ITipoPokemonRepository extends JpaRepository<TipoPokemon, Long> {

}
