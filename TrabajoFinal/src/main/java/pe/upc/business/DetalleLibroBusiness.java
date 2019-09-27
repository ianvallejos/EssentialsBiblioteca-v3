package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.DetalleLibro;
import pe.upc.model.repository.DetalleLibroRepository;

@Named
public class DetalleLibroBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetalleLibroRepository detalleLibroRepository;

	@Transactional
	public int insert(DetalleLibro  detalleLibro) throws Exception {
		return  detalleLibroRepository.insert( detalleLibro);
	}

	
	@Transactional
	public int update(DetalleLibro  detalleLibro) throws Exception{
		return  detalleLibroRepository.update( detalleLibro);
	}
	
	
	public List<DetalleLibro> getAll() throws Exception {
		return  detalleLibroRepository.findAll();
	}
	
	
	public List<DetalleLibro> getProductsByName(String name) throws Exception{
		return  detalleLibroRepository.findByName(name);
	}

}