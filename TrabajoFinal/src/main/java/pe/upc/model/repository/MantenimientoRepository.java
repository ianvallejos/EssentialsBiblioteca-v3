package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Mantenimiento;

@Named
public class MantenimientoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public int insert(Mantenimiento mantenimiento) throws Exception {
		em.persist(mantenimiento);
		return mantenimiento.getId_mantenimiento();
	}
	
	
	public int update(Mantenimiento mantenimiento) throws Exception {
		em.merge(mantenimiento);
		return mantenimiento.getId_mantenimiento();
	}
	
	
	public void delete(Mantenimiento mantenimiento) throws Exception {
		em.remove(mantenimiento);
	}
	
	
	public List<Mantenimiento> findAll() throws Exception{
		List<Mantenimiento> mantenimientos=new ArrayList<>();
		
		TypedQuery<Mantenimiento> query=em.createQuery("FROM Product p"
				,Mantenimiento.class);
		mantenimientos=query.getResultList();
		
		return mantenimientos;
	}
	
	
	public Optional<Mantenimiento> findById(Long id) throws Exception{
		Mantenimiento mantenimientoFound;
		
		TypedQuery<Mantenimiento> query=em.createQuery("FROM Product p WHERE p.id=?1"
				,Mantenimiento.class);
		query.setParameter(1, id);
		mantenimientoFound=query.getSingleResult();
		
		return Optional.of(mantenimientoFound);
	}
	
	
	public List<Mantenimiento> findByName(String name) throws Exception{
		List<Mantenimiento> mantenimientos=new ArrayList<>();
		
		TypedQuery<Mantenimiento> query=em.createQuery("FROM Product p WHERE p.name LIKE ?1"
				,Mantenimiento.class);
		query.setParameter(1, "%"+name+"%");
		mantenimientos=query.getResultList();
		
		return mantenimientos;
	}
	
}