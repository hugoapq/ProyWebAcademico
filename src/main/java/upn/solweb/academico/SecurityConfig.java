package upn.solweb.academico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import upn.solweb.academico.servicios.UsuarioService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();
		return bCryptPasswordEncoder;		
	}

	
	protected void configure(AuthenticationManagerBuilder autenticacionMB) throws Exception {
	
		autenticacionMB.userDetailsService(usuarioService).passwordEncoder(bcpe);
	}
	
	
}
