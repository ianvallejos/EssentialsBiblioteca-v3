package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Comprobante;

@Named
public class ComprobanteRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public Long insert(Comprobante product) throws Exception {
		em.persist(product);
		return product.getId_comprobante();
	}
	
	
	public Long update(Comprobante comprobante) throws Exception {
		em.merge(comprobante);
		return comprobante.getId_comprobante();
	}
	
	
	public void delete(Comprobante product) throws Exception {
		em.remove(product);
	}
	
	
	public List<Comprobante> findAll() throws Exception{
		List<Comprobante> comprobantes=new ArrayList<>();
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Product p"
				,Comprobante.class);
		comprobantes=query.getResultList();
		
		return comprobantes;
	}
	
	
	public Optional<Comprobante> findById(Long id) throws Exception{
		Comprobante comprobanteFound;
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Product p WHERE p.id=?1"
				,Comprobante.class);
		query.setParameter(1, id);
		comprobanteFound=query.getSingleResult();
		
		return Optional.of(comprobanteFound);
	}
	
	
	public List<Comprobante> findByName(String name) throws Exception{
		List<Comprobante> products=new ArrayList<>();
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Product p WHERE p.name LIKE ?1"
				,Comprobante.class);
		query.setParameter(1, "%"+name+"%");
		products=query.getResultList();
		
		return products;
	}
	
}