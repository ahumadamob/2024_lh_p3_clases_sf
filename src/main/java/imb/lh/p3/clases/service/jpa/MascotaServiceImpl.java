package imb.lh.p3.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.lh.p3.clases.entity.Mascota;
import imb.lh.p3.clases.repository.MascotaRepository;
import imb.lh.p3.clases.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private MascotaRepository repo;
	
	@Override
	public List<Mascota> getAllMascotas() {	
		return repo.findAll();
	}

	@Override
	public Mascota getMascotasById(Long id) {
		Optional<Mascota> o = repo.findById(id);
		if(o.isPresent()) {
			return o.get();
		}else {
			return null;
		}
	}

	@Override
	public Mascota guardar(Mascota mascota) {
		return repo.save(mascota);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);	
	}



}
