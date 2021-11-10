package upn.solweb.academico.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import upn.solweb.academico.entidades.Capital;
import upn.solweb.academico.entidades.Curso;
import upn.solweb.academico.entidades.Pais;
import upn.solweb.academico.entidades.Profesor;
import upn.solweb.academico.servicios.ICursoService;
import upn.solweb.academico.servicios.IPaisService;
import upn.solweb.academico.servicios.IProfesorService;


@Controller
@RequestMapping("/curso")
public class CursoController {
	//METODOS DEL PROTOCOLO HTTP:  GET, POST, PUT, DELETE
	
	private static Logger log= LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
	private ICursoService cursoService;	
	
	@Autowired
	private IProfesorService profesorService;	
		
	@GetMapping("/obtenerCursos")
	public String getCursos(@RequestParam(name="curso", required=false, defaultValue="Soluciones Web..") 
			String curso, Model model) 
	{
		List<Curso> listaCursos =  new ArrayList<Curso>();		
		
		listaCursos = cursoService.obtenerCursos();
				
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
	
	
	@GetMapping("/getCursosProfesor")
	public String getCursosProfeso(Model model) {
		
		Profesor profesor = profesorService.obtenerProfesorId(13);
		
		Set<Curso> cursos = profesor.getCursos();
		
		System.out.println("Profesor: " + profesor.getApPaterno() + " " +profesor.getApMaterno() + " " + profesor.getNombres() );
		
		for (Curso c : cursos) {
			System.out.println(c.getNombre());
		}
		
		//model.addAttribute("mensaje", "Ok");
		model.addAttribute("cursos", cursos);
		return "viewCursos";
	}
	
	@GetMapping("/agregarCurso")
	public String agregarCursoGet(Curso curso, Model model) {
		System.out.println("Agregar Curso...");
		
			
		return "administraCurso";
		
	}
	
	@PostMapping("/agregarCurso")
	public String agregarCursoPost(@Valid Curso curso,BindingResult resultado, Model model) {
		String mensaje="";
		
		if(resultado.hasErrors()) {			
			return "administraCurso";
		}
		
		Profesor profesor = profesorService.obtenerProfesorId(12);
		
		curso.setProfesor(profesor);
		
		Curso cursoBD = cursoService.obtenerCursoPorNombre(curso.getNombre());
		
		if(cursoBD==null) {
			cursoBD=cursoService.registrar(curso);
			mensaje= "Registro cond ID : " + cursoBD.getId() +" CREADO...";
		}  else {
			mensaje = "El curso con nombre " + cursoBD.getNombre() + " ya esta registrado";
		}
		
		model.addAttribute("mensaje", mensaje);
		
		return "confirmaAgregar";
		
	}
	
	@PostMapping("/agregarCurso1")
	public String agregarCursoPost1(Curso curso, Model model) {
		String mensaje="";
		System.out.println("Metodo para insertar un curso.");
		
		System.out.println("ID. Curso: " + curso.getId());
		System.out.println("Nombre Curso: " + curso.getNombre());
		System.out.println("Creditos: " + curso.getCreditos());
		
		Profesor profesor = profesorService.obtenerProfesorId(12);
		
		curso.setProfesor(profesor);
		
		Curso cursoBD = cursoService.obtenerCursoPorNombre(curso.getNombre());
		
		/*System.out.println(" --------------------- CURSO EN BASE DE DATOS ----------------------");
		System.out.println("ID. Curso: " + cursoBD.getId());
		System.out.println("Nombre Curso: " + cursoBD.getNombre());
		System.out.println("Creditos: " + cursoBD.getCreditos());*/
		
		if(cursoBD==null) {
			cursoBD=cursoService.registrar(curso);
			mensaje= "Registro cond ID : " + cursoBD.getId() +" CREADO...";
		}  else {
			mensaje = "El curso con nombre " + cursoBD.getNombre() + " ya esta registrado";
		}
		
		model.addAttribute("mensaje", mensaje);
		
		
		return "confirmaAgregar";
		
	}
}
