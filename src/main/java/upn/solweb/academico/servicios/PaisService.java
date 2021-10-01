package upn.solweb.academico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.academico.entidades.Pais;
import upn.solweb.academico.repositorio.IPaisRepo;

@Service
public class PaisService implements IPaisService{
	@Autowired
	private IPaisRepo paisRepositorio;
	

	@Override
	public void registrar(Pais pais) {
		paisRepositorio.save(pais);
		
	}

	@Override
	public List<Pais> obtenerPaises() {
		return paisRepositorio.findAll();
	}

	@Override
	public Pais obtenerPaisId(Integer id) {
		return paisRepositorio.getById(id);
	}

	@Override
	public void eliminar(int id) {
		paisRepositorio.deleteById(null);
		
	}	
}
