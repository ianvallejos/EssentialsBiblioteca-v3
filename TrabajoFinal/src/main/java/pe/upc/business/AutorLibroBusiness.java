package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.AutorLibro;
import pe.upc.model.repository.AutorLibroRepository;

@Named
public class AutorLibroBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AutorLibroRepository autorlibroRepository;

	@Transactional
	public Long insert(AutorLibro autorlibro) throws Exception {
		return autorlibroRepository.insert(autorlibro);
	}

	
	@Transactional
	public Long update(AutorLibro autorlibro) throws Exception{
		return autorlibroRepository.update(autorlibro);
	}
	

	
	public List<AutorLibro> getAll() throws Exception {
		return autorlibroRepository.findAll();
	}
	
	
	public List<AutorLibro> getAutorLibrosByName(String name) throws Exception{
		return autorlibroRepository.findByName(name);
	}

}