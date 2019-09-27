package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Comprobante;
import pe.upc.model.repository.ComprobanteRepository;

@Named
public class ComprobanteBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ComprobanteRepository comprobanteRepository;

	@Transactional
	public Long insert(Comprobante comprobante) throws Exception {
		return comprobanteRepository.insert(comprobante);
	}

	
	@Transactional
	public Long update(Comprobante comprobante) throws Exception{
		return comprobanteRepository.update(comprobante);
	}
	
	
	public List<Comprobante> getAll() throws Exception {
		return comprobanteRepository.findAll();
	}
	
	
	public List<Comprobante> getProductsByName(String name) throws Exception{
		return comprobanteRepository.findByName(name);
	}

}