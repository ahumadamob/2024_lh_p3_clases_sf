package imb.lh.p3.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import imb.lh.p3.clases.entity.Mascota;
import imb.lh.p3.clases.service.IMascotaService;

@RestController
public class MascotaController {

	@Autowired
	private IMascotaService service;
	

	@GetMapping("/mascotas")
	public List<Mascota>buscarMascotas(){
		
		return service.getAllMascotas();
	}
	
	@GetMapping("/mascota/{id}")
	public Mascota buscarMascotaPorId(@PathVariable("id") Long id) {
		return service.getMascotasById(id);
	}
	

}
