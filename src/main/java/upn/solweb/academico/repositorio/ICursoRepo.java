package upn.solweb.academico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upn.solweb.academico.entidades.Curso;

public interface ICursoRepo extends JpaRepository<Curso,Integer>{
	
	@Query("SELECT c FROM Curso c WHERE c.nombre=?1")
	Curso buscarCurso(String nombre);
}
