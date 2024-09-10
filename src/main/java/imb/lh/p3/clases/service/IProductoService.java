package imb.lh.p3.clases.service;

import java.util.List;

import imb.lh.p3.clases.entity.Producto;

public interface IProductoService {
	public List<Producto>mostrarTodos();
	public Producto mostrarPorId(Long id);
	public Producto guardar(Producto producto);
	public void eliminar(Long id);
	public boolean existe(Long id);
}
