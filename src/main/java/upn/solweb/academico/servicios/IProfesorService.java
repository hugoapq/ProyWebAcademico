package upn.solweb.academico.servicios;

import java.util.List;

import upn.solweb.academico.entidades.Profesor;

public interface IProfesorService {
	
	public void registrar(Profesor profesor);
	
	public List<Profesor> obtenerProfesores();
	
	public Profesor obtenerProfesorId(Integer id);
	
	public void eliminar(int id);
}
