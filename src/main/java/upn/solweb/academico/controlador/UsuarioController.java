package upn.solweb.academico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import upn.solweb.academico.entidades.Usuario;
import upn.solweb.academico.servicios.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@GetMapping("/inserta")
	private String isertaUsuario(Model modelo) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Usuario3");
		usuario.setClave("clave3");
		
		Usuario user = usuarioService.insertar(usuario);
		
		modelo.addAttribute("mensaje", "Usuario agregado : " + user.getNombre() + 
				" clave: " + user.getClave());
		
		return "confirmaAgregar";
	}
	

}
