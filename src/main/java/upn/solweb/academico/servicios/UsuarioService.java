package upn.solweb.academico.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import upn.solweb.academico.entidades.Usuario;
import upn.solweb.academico.repositorio.IUsuarioRepo;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private BCryptPasswordEncoder bcpe;

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	public Usuario insertar(Usuario usuario) {
		
		usuario.setClave(bcpe.encode(usuario.getClave()));
		Usuario user =usuarioRepo.save(usuario);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		try {
			
			Usuario usuario = usuarioRepo.findByNombre(username);		
			
			
			roles.add(new SimpleGrantedAuthority("Administrador"));
									
			UserDetails userDetails = new User(usuario.getNombre(),usuario.getClave(),roles);
			
			return userDetails;
			
		}catch(Exception exception) {
			
			return  new User("error","error",roles);
		}
		
		
		
	}
	
	
	
	
	
}
