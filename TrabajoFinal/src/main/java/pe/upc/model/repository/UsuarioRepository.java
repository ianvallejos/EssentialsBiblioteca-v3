package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Usuario;

@Named
public class UsuarioRepository implements Serializable{
	
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
	
	
	public List<Usuario> findAll() throws Exception{
		List<Usuario> usuarios=new ArrayList<>();
		
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u"
				,Usuario.class);
		usuarios=query.getResultList();
		
		return usuarios;
	}
	
	
	public Optional<Usuario> findById(Long id) throws Exception{
		Usuario usuarioFound;
		
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE r.id=?1"
				,Usuario.class);
		query.setParameter(1, id);
		usuarioFound=query.getSingleResult();
		
		return Optional.of(usuarioFound);
	}
	
	
	public List<Usuario> findByName(String name) throws Exception{
		List<Usuario> usuarios=new ArrayList<>();
		
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE r.name LIKE ?1"
				,Usuario.class);
		query.setParameter(1, "%"+name+"%");
		usuarios=query.getResultList();
		
		return usuarios;
	}
}