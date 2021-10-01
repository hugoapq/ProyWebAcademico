package upn.solweb.academico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import upn.solweb.academico.entidades.Curso;
import upn.solweb.academico.entidades.Profesor;
import upn.solweb.academico.servicios.ICursoService;
import upn.solweb.academico.servicios.IProfesorService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@Autowired
	private ICursoService cursoService;
	
	@GetMapping("/getProfesor")
	public String obtenerProfesor() {
		
		Profesor profesor = new Profesor();
		profesor.setApPaterno("Arana");
		profesor.setApMaterno("Pelaez");
		profesor.setNombres("Luis Manuel");
		profesor.setProfesion("Ingeniero");		
		
		Curso curso1 = new Curso();
		curso1.setNombre("Fisica I");
		curso1.setCreditos(4);
		curso1.setProfesor(profesor);
		
		Curso curso2 = new Curso();
		curso2.setNombre("Quimia I");
		curso2.setCreditos(3);
		curso2.setProfesor(profesor);
		
		profesorService.registrar(profesor);
		cursoService.registrar(curso1);
		cursoService.registrar(curso2);
		
		return "viewCursos";
		
	}
	
	@GetMapping("/agregarPais")
	public String agregarPaisGet(Model model) {
		/*System.out.println("Agregar Pais...");
		
		Capital capital = new Capital("Lima");
		
		Pais pais = new Pais();
		
		pais.setNombre("Peru");
		pais.setPoblacion(15000);
		pais.setCapital(capital);
		
		paisService.registrar(pais);*/
		
		
		return "viewCursos";
		
	}

}
