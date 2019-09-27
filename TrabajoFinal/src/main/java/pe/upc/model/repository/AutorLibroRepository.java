package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.upc.model.entity.AutorLibro;

@Named
public class AutorLibroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	
	public Long insert(AutorLibro autorlibro) throws Exception {
		em.persist(autorlibro);
		return autorlibro.getId_autorlibro();
	}
	
	
	public Long update(AutorLibro autorlibro) throws Exception {
		em.merge(autorlibro);
		return autorlibro.getId_autorlibro();
	}
	
	
	public void delete(AutorLibro autorlibro) throws Exception {
		em.remove(autorlibro);
	}
	
	public List<AutorLibro> findAll() throws Exception{
		List<AutorLibro> autoreslibro=new ArrayList<>();
		
		TypedQuery<AutorLibro> query=em.createQuery("FROM AutorLibro aut"
				,AutorLibro.class);
		autoreslibro=query.getResultList();
		
		return autoreslibro;
	}
	
	
	public Optional<AutorLibro> findById(Long id) throws Exception{
		AutorLibro autorlibroFound;
		
		TypedQuery<AutorLibro> query=em.createQuery("FROM AutorLibro aut WHERE aut.id=?1"
				,AutorLibro.class);
		query.setParameter(1, id);
		autorlibroFound=query.getSingleResult();
		
		return Optional.of(autorlibroFound);
	}
	
	
	public List<AutorLibro> findByName(String name) throws Exception{
		List<AutorLibro> autoreslibro=new ArrayList<>();
		
		TypedQuery<AutorLibro> query=em.createQuery("FROM AutorLibro aut WHERE aut.name LIKE ?1"
				,AutorLibro.class);
		query.setParameter(1, "%"+name+"%");
		autoreslibro=query.getResultList();
		
		return autoreslibro;
	}
	
	

}
