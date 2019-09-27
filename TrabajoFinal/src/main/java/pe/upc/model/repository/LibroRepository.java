package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Libro;

@Named
public class LibroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="biPU")
	private EntityManager em;
	
	public Long insert(Libro libro) throws Exception {
		em.persist(libro);
		return libro.getId_libro();
	}
	
	
	public Long update(Libro libro) throws Exception {
		em.merge(libro);
		return libro.getId_libro();
	}
	
	
	public void delete(Libro libro) throws Exception {
		em.remove(libro);
	}
	
	
	public List<Libro> findAll() throws Exception{
		List<Libro> libros=new ArrayList<>();
		
		TypedQuery<Libro> query=em.createQuery("FROM Libro l"
				,Libro.class);
		libros=query.getResultList();
		
		return libros;
	}
	
	
	public Optional<Libro> findById(Long id) throws Exception{
		Libro libroFound;
		
		TypedQuery<Libro> query=em.createQuery("FROM Libro l WHERE l.id=?1"
				,Libro.class);
		query.setParameter(1, id);
		libroFound=query.getSingleResult();
		
		return Optional.of(libroFound);
	}
	
	
	public List<Libro> findByName(String name) throws Exception{
		List<Libro> libros=new ArrayList<>();
		
		TypedQuery<Libro> query=em.createQuery("FROM Libro l WHERE l.name LIKE ?1"
				,Libro.class);
		query.setParameter(1, "%"+name+"%");
		libros=query.getResultList();
		
		return libros;
	}
	
}