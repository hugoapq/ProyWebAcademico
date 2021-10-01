package upn.solweb.academico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.academico.entidades.Capital;
import upn.solweb.academico.repositorio.ICapitalRepo;

@Service
public class CapitalService implements ICapitalService {

	@Autowired
	private ICapitalRepo capitalRepositorio;
	
	@Override
	public void registrar(Capital capital) {
		capitalRepositorio.save(capital);
	}

	@Override
	public List<Capital> obtenerCapitales() {
		return capitalRepositorio.findAll();
	}

	@Override
	public Capital obtenerCapitalId(Integer id) {
		return capitalRepositorio.getById(id);
	}

	@Override
	public void eliminar(int id) {
		capitalRepositorio.deleteById(id);

	}

}
