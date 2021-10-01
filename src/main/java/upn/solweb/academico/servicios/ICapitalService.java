package upn.solweb.academico.servicios;

import java.util.List;

import upn.solweb.academico.entidades.Capital;

public interface ICapitalService {
	public void registrar(Capital capital);
	
	public List<Capital> obtenerCapitales();
	
	public Capital obtenerCapitalId(Integer id);
	
	public void eliminar(int id);
}
