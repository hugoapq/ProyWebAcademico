package upn.solweb.academico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyWebAcademicoApplication implements CommandLineRunner{
	
	private static Logger log= LoggerFactory.getLogger(ProyWebAcademicoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyWebAcademicoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion academica");
		
		log.info("Aplicacion academica");
		log.warn("Aplicacion academica");
		log.error("Aplicacion academica");
		
	}

}


