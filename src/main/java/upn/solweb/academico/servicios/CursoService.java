package upn.solweb.academico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.academico.entidades.Curso;
import upn.solweb.academico.repositorio.ICursoRepo;

@Service
public class CursoService implements ICursoService{
	

	@Autowired
	private ICursoRepo cursoRepositorio;

	@Override
	public void registrar(Curso curso) {
		cursoRepositorio.save(curso);
		
	}

	@Override
	public List<Curso> obtenerCursos() {
		return cursoRepositorio.findAll();
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		return cursoRepositorio.getById(id);		
	}

	@Override
	public void eliminar(int id) {
		cursoRepositorio.deleteById(id);
	}

	

}
