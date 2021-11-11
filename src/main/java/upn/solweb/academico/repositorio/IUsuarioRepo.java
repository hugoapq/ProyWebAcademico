package upn.solweb.academico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upn.solweb.academico.entidades.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

	Usuario findByNombre(String nombre);
	
	//Select * from Usuario where nonmbre = :nombre
	
}


