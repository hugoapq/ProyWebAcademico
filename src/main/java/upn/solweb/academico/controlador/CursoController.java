package upn.solweb.academico.controlador;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import upn.solweb.academico.entidades.Capital;
import upn.solweb.academico.entidades.Curso;
import upn.solweb.academico.entidades.Pais;
import upn.solweb.academico.servicios.ICursoService;
import upn.solweb.academico.servicios.IPaisService;


@Controller
@RequestMapping("/curso")
public class CursoController {
	//METODOS DEL PROTOCOLO HTTP:  GET, POST, PUT, DELETE
	
	private static Logger log= LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
	private ICursoService cursoService;	
		
	@GetMapping("/obtenerCursos")
	public String getCursos(@RequestParam(name="curso", required=false, defaultValue="Soluciones Web..") 
			String curso, Model model) 
	{
		List<Curso> listaCursos =  new ArrayList<Curso>();
		
		/*Curso curso1 = new Curso();
		curso1.setId(1);
		curso1.setNombre("Fisica Nuclear");
		curso1.setCreditos(5);
		
		cursoService.registrar(curso1); //INSERT (Si es que no existe) O UN UPDATE(Si ya existe)
		
		Curso curso2 = new Curso(2,"Quimica Avanzada",4);
		
		cursoService.registrar(curso2);*/
		
		listaCursos = cursoService.obtenerCursos();
		
		/*listaCursos.add(curso1);
		listaCursos.add(curso2);
		
		for(Curso c: listaCursos) {
			System.out.println(c.getId());
			System.out.println(c.getNombre());
			System.out.println(c.getCreditos());
		}
		*/
		
		
		model.addAttribute("cursos",listaCursos);		
		
		return "viewCursos";
	}
	
	@GetMapping("/getCurso")
	public String getCurso(@RequestParam(name="idCurso", required=true , defaultValue="1")
			int id, Model model) {
		/*log.info("En el metodo getCurso del controlador CursoController");
		log.info("Id curso : " + id);
		model.addAttribute("nombre","Algebra Lineal");
		model.addAttribute("prereq","Matematica Basica");*/
		
		Curso curso = new Curso();
		curso.setId(1);
		curso.setNombre("Robotica I");
		curso.setCreditos(5);
		
		model.addAttribute("atribCurso",curso);
		
		return "viewCurso";
	}
	
	@GetMapping("/agregarCurso")
	public String agregarCursoGet(Curso curso, Model model) {
		System.out.println("Agregar Curso...");
		
			
		return "viewCursos";
		
	}
	
	@PostMapping("/agregarCurso")
	public String agregarCursoPost(Curso curso, Model model) {
		
		return "confirmaAgregar";
		
	}
}
