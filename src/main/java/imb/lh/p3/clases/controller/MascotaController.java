package imb.lh.p3.clases.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Mascota;

@RestController
public class MascotaController {
	
	@GetMapping("/mascota")
	public Mascota miMascota() {
		Mascota mascota = new Mascota();
		mascota.setNombre("Fido");
		mascota.setRaza("Perro");
		mascota.setEdad(6);
		mascota.setPeludo(true);
		return mascota;
	}

}
