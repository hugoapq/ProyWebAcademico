package upn.solweb.academico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.academico.entidades.Profesor;
import upn.solweb.academico.repositorio.IPaisRepo;
import upn.solweb.academico.repositorio.IProfesorRepo;

@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private IProfesorRepo profesorRepositorio;
	
	@Override
	public void registrar(Profesor profesor) {
		profesorRepositorio.save(profesor);
		
	}

	@Override
	public List<Profesor> obtenerProfesores() {
		return profesorRepositorio.findAll();
	}

	@Override
	public Profesor obtenerProfesorId(Integer id) {
		return profesorRepositorio.getById(id);
	}	

	@Override
	public void eliminar(int id) {
		profesorRepositorio.deleteById(id);
		
	}

}
