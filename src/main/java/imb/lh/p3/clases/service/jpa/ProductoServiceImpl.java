package imb.lh.p3.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.lh.p3.clases.entity.Producto;
import imb.lh.p3.clases.repository.ProductoRepository;
import imb.lh.p3.clases.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository repo;

	@Override
	public List<Producto> mostrarTodos() {
		
		/*List<Producto> miLista = null;
		miLista = repo.findAll();
		return miLista;
		*/
		return repo.findAll();
		
	}

	@Override
	public Producto mostrarPorId(Long id) {
		/*
		Optional<Producto> miOpcional;
		miOpcional = repo.findById(id);
		if(miOpcional.isPresent()) {
			return miOpcional.get();
		}else {
			return null;
		}
		*/
		return repo.findById(id).orElse(null);

	}

	@Override
	public Producto guardar(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
