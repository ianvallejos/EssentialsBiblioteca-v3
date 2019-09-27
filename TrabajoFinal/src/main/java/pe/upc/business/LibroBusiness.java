package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Libro;
import pe.upc.model.repository.LibroRepository;

@Named
public class LibroBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LibroRepository libroRepository;

	@Transactional
	public Long insert(Libro libro) throws Exception {
		return libroRepository.insert(libro);
	}

	
	@Transactional
	public Long update(Libro libro) throws Exception{
		return libroRepository.update(libro);
	}
	
	
	public List<Libro> getAll() throws Exception {
		return libroRepository.findAll();
	}
	
	
	public List<Libro> getLibrosByName(String name) throws Exception{
		return libroRepository.findByName(name);
	}

}