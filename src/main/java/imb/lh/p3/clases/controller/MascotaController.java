package imb.lh.p3.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Mascota;
import imb.lh.p3.clases.service.IMascotaService;

@RestController
public class MascotaController {

	@Autowired
	private IMascotaService service;
	
	@GetMapping("/mascota")
	public Mascota infoDeMiMascota(){
		Mascota mascota = new Mascota();
		mascota.setNombre("Fido");
		mascota.setRaza("Perro");
		mascota.setEdad(3);
		mascota.setPeludo(true);
		return mascota;
	}
	
	@GetMapping("/mascotas")
	public List<Mascota>infoDeTresMascotas(){
		
		return service.getAllMascotas();
	}
	

}
