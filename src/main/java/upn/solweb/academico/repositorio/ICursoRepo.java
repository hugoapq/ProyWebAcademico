package upn.solweb.academico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import upn.solweb.academico.entidades.Curso;

public interface ICursoRepo extends JpaRepository<Curso,Integer>{
	
}
