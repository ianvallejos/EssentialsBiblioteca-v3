package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Delivery;
import pe.upc.model.repository.DeliveryRepository;

@Named
public class DeliveryBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeliveryRepository deliveryRepository;

	@Transactional
	public int insert(Delivery delivery) throws Exception {
		return deliveryRepository.insert(delivery);
	}

	
	@Transactional
	public int update(Delivery delivery) throws Exception{
		return deliveryRepository.update(delivery);
	}
	
	
	public List<Delivery> getAll() throws Exception {
		return deliveryRepository.findAll();
	}
	
	
	public List<Delivery> getProductsByName(String name) throws Exception{
		return deliveryRepository.findByName(name);
	}

}