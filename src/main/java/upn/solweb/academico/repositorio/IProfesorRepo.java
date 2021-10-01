package upn.solweb.academico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import upn.solweb.academico.entidades.Profesor;

public interface IProfesorRepo  extends JpaRepository<Profesor,Integer> {

}
