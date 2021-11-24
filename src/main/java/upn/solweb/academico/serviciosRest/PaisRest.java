package upn.solweb.academico.serviciosRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upn.solweb.academico.entidades.Pais;
import upn.solweb.academico.repositorio.IPaisRepo;

@RestController
@RequestMapping("pais")
public class PaisRest {
	
	//Protocolo HTTP: get, post, put, delete
	@Autowired
	private IPaisRepo paisRepo;
	
	@GetMapping("/listar")
	public List<Pais> listar() {
		return paisRepo.findAll();		
	}
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Pais pais) {
		paisRepo.save(pais);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Pais pais) {
		paisRepo.save(pais);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		paisRepo.deleteById(id);
		
	}
}
