package upn.solweb.academico.servicios;

import java.util.List;

import upn.solweb.academico.entidades.Pais;

public interface IPaisService {
	
	public void registrar(Pais pais);
	
	public List<Pais> obtenerPaises();
	
	public Pais obtenerPaisId(Integer id);
	
	public void eliminar(int id);

}
