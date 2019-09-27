package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Autor;
import pe.upc.model.repository.AutorRepository;

@Named
public class AutorBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AutorRepository autorRepository;

	@Transactional
	public Long insert(Autor autor) throws Exception {
		return autorRepository.insert(autor);
	}

	
	@Transactional
	public Long update(Autor autor) throws Exception{
		return autorRepository.update(autor);
	}
	

	
	public List<Autor> getAll() throws Exception {
		return autorRepository.findAll();
	}
	
	
	public List<Autor> getAutoresByName(String name) throws Exception{
		return autorRepository.findByName(name);
	}

}