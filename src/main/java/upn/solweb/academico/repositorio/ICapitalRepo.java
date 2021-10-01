package upn.solweb.academico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import upn.solweb.academico.entidades.Capital;

public interface ICapitalRepo extends JpaRepository<Capital,Integer> {

}
