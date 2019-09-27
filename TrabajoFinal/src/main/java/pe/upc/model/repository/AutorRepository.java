package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Autor;

@Named
public class AutorRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public Long insert(Autor autor) throws Exception {
		em.persist(autor);
		return autor.getId_autor();
	}
	
	
	public Long update(Autor autor) throws Exception {
		em.merge(autor);
		return autor.getId_autor();
	}
	
	
	public void delete(Autor autor) throws Exception {
		em.remove(autor);
	}
	
	
	public List<Autor> findAll() throws Exception{
		List<Autor> autores=new ArrayList<>();
		
		TypedQuery<Autor> query=em.createQuery("FROM Autor a"
				,Autor.class);
		autores=query.getResultList();
		
		return autores;
	}
	
	
	public Optional<Autor> findById(Long id) throws Exception{
		Autor autorFound;
		
		TypedQuery<Autor> query=em.createQuery("FROM Autor a WHERE p.id=?1"
				,Autor.class);
		query.setParameter(1, id);
		autorFound=query.getSingleResult();
		
		return Optional.of(autorFound);
	}
	
	
	public List<Autor> findByName(String name) throws Exception{
		List<Autor> autores=new ArrayList<>();
		
		TypedQuery<Autor> query=em.createQuery("FROM Autor a WHERE p.name LIKE ?1"
				,Autor.class);
		query.setParameter(1, "%"+name+"%");
		autores=query.getResultList();
		
		return autores;
	}
	
	

}