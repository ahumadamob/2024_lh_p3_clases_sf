package imb.lh.p3.clases.service;

import java.util.List;

import org.springframework.stereotype.Service;

import imb.lh.p3.clases.entity.Mascota;

@Service
public interface IMascotaService {
	public List<Mascota> getAllMascotas();
	public Mascota getMascotasById(Long id);
	public Mascota guardar(Mascota mascota);
	public void eliminar(Long id);
}
