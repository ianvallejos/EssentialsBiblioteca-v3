package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Mantenimiento;
import pe.upc.model.repository.MantenimientoRepository;

@Named
public class MantenimientoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MantenimientoRepository mantenimientoRepository;

	@Transactional
	public int insert(Mantenimiento mantenimiento) throws Exception {
		return mantenimientoRepository.insert(mantenimiento);
	}

	
	@Transactional
	public int update(Mantenimiento mantenimiento) throws Exception{
		return mantenimientoRepository.update(mantenimiento);
	}
	
	
	public List<Mantenimiento> getAll() throws Exception {
		return mantenimientoRepository.findAll();
	}
	
	
	public List<Mantenimiento> getProductsByName(String name) throws Exception{
		return mantenimientoRepository.findByName(name);
	}

}