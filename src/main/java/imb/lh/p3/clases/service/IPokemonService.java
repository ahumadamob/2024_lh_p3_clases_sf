package imb.lh.p3.clases.service;

import java.util.List;

import imb.lh.p3.clases.entity.Pokemon;

public interface IPokemonService {
	public List<Pokemon> obtenerTodos();
	public Pokemon obtenerPorId(Long id);
	public Pokemon guardar(Pokemon pokemon);
	public void eliminar(Long id);
	public boolean existe(Long id);
}
