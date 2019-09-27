package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Prestamo;
import pe.upc.model.repository.PrestamoRepository;

@Named
public class PrestamoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PrestamoRepository prestamoRepository;

	@Transactional
	public Long insert(Prestamo prestamo) throws Exception {
		return prestamoRepository.insert(prestamo);
	}

	
	@Transactional
	public Long update(Prestamo prestamo) throws Exception{
		return prestamoRepository.update(prestamo);
	}
	
	
	public List<Prestamo> getAll() throws Exception {
		return prestamoRepository.findAll();
	}
	
	
	public List<Prestamo> getPrestamosByName(String name) throws Exception{
		return prestamoRepository.findByName(name);
	}

}