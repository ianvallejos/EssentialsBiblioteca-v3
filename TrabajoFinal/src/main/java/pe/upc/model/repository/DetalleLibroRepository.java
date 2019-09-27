package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.DetalleLibro;

@Named
public class DetalleLibroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public int insert(DetalleLibro detalleLibro) throws Exception {
		em.persist(detalleLibro);
		return detalleLibro.getId_detalle();
	}
	
	
	public int update(DetalleLibro detalleLibro) throws Exception {
		em.merge(detalleLibro);
		return detalleLibro.getId_detalle();
	}
	
	
	public void delete(DetalleLibro detalleLibro) throws Exception {
		em.remove(detalleLibro);
	}
	
	
	public List<DetalleLibro> findAll() throws Exception{
		List<DetalleLibro> detalleLibros=new ArrayList<>();
		
		TypedQuery<DetalleLibro> query=em.createQuery("FROM DetalleLibro dl"
				,DetalleLibro.class);
		detalleLibros=query.getResultList();
		
		return detalleLibros;
	}
	
	
	public Optional<DetalleLibro> findById(Long id) throws Exception{
		DetalleLibro detalleLibroFound;
		
		TypedQuery<DetalleLibro> query=em.createQuery("FROM DetalleLibro dl WHERE r.id=?1"
				,DetalleLibro.class);
		query.setParameter(1, id);
		detalleLibroFound=query.getSingleResult();
		
		return Optional.of(detalleLibroFound);
	}
	
	
	public List<DetalleLibro> findByName(String name) throws Exception{
		List<DetalleLibro> detalleLibros=new ArrayList<>();
		
		TypedQuery<DetalleLibro> query=em.createQuery("FROM DetalleLibro dl WHERE r.name LIKE ?1"
				,DetalleLibro.class);
		query.setParameter(1, "%"+name+"%");
		detalleLibros=query.getResultList();
		
		return detalleLibros;
	}
}