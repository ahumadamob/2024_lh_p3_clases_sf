package imb.lh.p3.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/mascota")
	public Mascota crearMascota(@RequestBody Mascota mascota){
		return service.guardar(mascota);
	}	
	
	@PutMapping("/mascota")
	public Mascota actualizarMascota(@RequestBody Mascota mascota) {
		return service.guardar(mascota);
	}
	
	@DeleteMapping("/mascota/{id}")
	public void eliminarMascota(@PathVariable("id") Long id){
		service.eliminar(id);
	}

	

}
