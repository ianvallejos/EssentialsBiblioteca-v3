package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Trabajador;
import pe.upc.model.entity.Usuario;

@Named
public class TrabajadorRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public Long insert(Usuario usuario) throws Exception {
		em.persist(usuario);
		return usuario.getId_usuario();
	}
	
	
	public Long update(Usuario usuario) throws Exception {
		em.merge(usuario);
		return usuario.getId_usuario();
	}
	
	
	public void delete(Usuario usuario) throws Exception {
		em.remove(usuario);
	}
	
	
	public List<Trabajador> findAll() throws Exception{
		List<Trabajador> trabajadores=new ArrayList<>();
		
		TypedQuery<Trabajador> query=em.createQuery("FROM Trabadores p"
				,Trabajador.class);
		trabajadores=query.getResultList();
		
		return trabajadores;
	}
	
	
	public Optional<Trabajador> findById(Long id) throws Exception{
		Trabajador trabajadorFound;
		
		TypedQuery<Trabajador> query=em.createQuery("FROM Trabajador t WHERE p.id=?1"
				,Trabajador.class);
		query.setParameter(1, id);
		trabajadorFound=query.getSingleResult();
		
		return Optional.of(trabajadorFound);
	}
	
	
	public List<Trabajador> findByName(String name) throws Exception{
		List<Trabajador> trabajadores=new ArrayList<>();
		
		TypedQuery<Trabajador> query=em.createQuery("FROM Product p WHERE p.name LIKE ?1"
				,Trabajador.class);
		query.setParameter(1, "%"+name+"%");
		trabajadores=query.getResultList();
		
		return trabajadores;
	}
}
	