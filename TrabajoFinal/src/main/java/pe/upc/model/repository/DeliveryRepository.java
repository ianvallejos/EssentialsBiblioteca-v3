package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Delivery;

@Named
public class DeliveryRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public int insert(Delivery delivery) throws Exception {
		em.persist(delivery);
		return (int) delivery.getId_delivery();
	}
	
	
	public int update(Delivery delivery) throws Exception {
		em.merge(delivery);
		return delivery.getId_delivery();
	}
	
	
	public void delete(Delivery delivery) throws Exception {
		em.remove(delivery);
	}
	
	
	public List<Delivery> findAll() throws Exception{
		List<Delivery> deliverys=new ArrayList<>();
		
		TypedQuery<Delivery> query=em.createQuery("FROM Product p"
				,Delivery.class);
		deliverys=query.getResultList();
		
		return deliverys;
	}
	
	
	public Optional<Delivery> findById(Long id) throws Exception{
		Delivery deliveryFound;
		
		TypedQuery<Delivery> query=em.createQuery("FROM Delivery d WHERE d.id=?1"
				,Delivery.class);
		query.setParameter(1, id);
		deliveryFound=query.getSingleResult();
		
		return Optional.of(deliveryFound);
	}
	
	
	public List<Delivery> findByName(String name) throws Exception{
		List<Delivery> deliverys=new ArrayList<>();
		
		TypedQuery<Delivery> query=em.createQuery("FROM Delivery d WHERE d.name LIKE ?1"
				,Delivery.class);
		query.setParameter(1, "%"+name+"%");
		deliverys=query.getResultList();
		
		return deliverys;
	}
	
}