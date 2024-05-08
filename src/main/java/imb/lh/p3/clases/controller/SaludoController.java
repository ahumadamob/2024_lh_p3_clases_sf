package imb.lh.p3.clases.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	@GetMapping("/hola")
	public String holaComoAndas(){
		return "Hola Como Andas";
	}
	

}
