package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Prestamo;

@Named
public class PrestamoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public long insert(Prestamo prestamo) throws Exception {
		em.persist(prestamo);
		return prestamo.getId_prestamo();
	}
	
	
	public long update(Prestamo prestamo) throws Exception {
		em.merge(prestamo);
		return prestamo.getId_prestamo();
	}
	
	
	public void delete(Prestamo prestamo) throws Exception {
		em.remove(prestamo);
	}
	
	
	public List<Prestamo> findAll() throws Exception{
		List<Prestamo> prestamos=new ArrayList<>();
		
		TypedQuery<Prestamo> query=em.createQuery("FROM Prestamo p"
				,Prestamo.class);
		prestamos=query.getResultList();
		
		return prestamos;
	}
	
	
	public Optional<Prestamo> findById(Long id) throws Exception{
		Prestamo prestamoFound;
		
		TypedQuery<Prestamo> query=em.createQuery("FROM Prestamo p WHERE r.id=?1"
				,Prestamo.class);
		query.setParameter(1, id);
		prestamoFound=query.getSingleResult();
		
		return Optional.of(prestamoFound);
	}
	
	
	public List<Prestamo> findByName(String name) throws Exception{
		List<Prestamo> prestamos=new ArrayList<>();
		
		TypedQuery<Prestamo> query=em.createQuery("FROM Prestamo p WHERE r.name LIKE ?1"
				,Prestamo.class);
		query.setParameter(1, "%"+name+"%");
		prestamos=query.getResultList();
		
		return prestamos;
	}
}