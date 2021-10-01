package upn.solweb.academico.servicios;

import java.util.List;

import upn.solweb.academico.entidades.Curso;

public interface ICursoService {

	public void registrar(Curso curso);
	
	public List<Curso> obtenerCursos();
	
	public Curso obtenerCursoId(Integer id);
	
	public void eliminar(int id);
}
