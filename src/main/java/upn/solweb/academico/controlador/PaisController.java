package upn.solweb.academico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upn.solweb.academico.entidades.Capital;
import upn.solweb.academico.entidades.Pais;
import upn.solweb.academico.servicios.IPaisService;

@Controller
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private IPaisService paisService;
	
	@GetMapping("/getPais")
	public String obtenerPais() {
		
		Pais pais=null;
		
		pais = paisService.obtenerPaisId(10);
		
		System.out.println("Datos de pais");
		System.out.println("Id: " + pais.getIdPais());
		System.out.println("Nombre: " + pais.getNombre());
		System.out.println("Pobalacion: " + pais.getPoblacion());
		System.out.println("Capital: " + pais.getCapital().getNombre());
		
		return "viewCursos";
		
	}
	
	@GetMapping("/agregarPais")
	public String agregarPaisGet(Model model) {
		System.out.println("Agregar Pais...");
		
		Capital capital = new Capital("Lima");
		
		Pais pais = new Pais();
		
		pais.setNombre("Peru");
		pais.setPoblacion(15000);
		pais.setCapital(capital);
		
		paisService.registrar(pais);
		
		
		return "viewCursos";
		
	}

}
