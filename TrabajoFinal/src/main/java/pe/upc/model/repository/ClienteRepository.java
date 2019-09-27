package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Cliente;
import pe.upc.model.entity.Usuario;

@Named
public class ClienteRepository implements Serializable{
	
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
	
	
	public List<Cliente> findAll() throws Exception{
		List<Cliente> clientes=new ArrayList<>();
		
		TypedQuery<Cliente> query=em.createQuery("FROM Product p"
				,Cliente.class);
		clientes=query.getResultList();
		
		return clientes;
	}
	
	
	public Optional<Cliente> findById(Long id) throws Exception{
		Cliente clienteFound;
		
		TypedQuery<Cliente> query=em.createQuery("FROM Product p WHERE p.id=?1"
				,Cliente.class);
		query.setParameter(1, id);
		clienteFound=query.getSingleResult();
		
		return Optional.of(clienteFound);
	}
	
	
	public List<Cliente> findByName(String name) throws Exception{
		List<Cliente> clientes=new ArrayList<>();
		
		TypedQuery<Cliente> query=em.createQuery("FROM Product p WHERE p.name LIKE ?1"
				,Cliente.class);
		query.setParameter(1, "%"+name+"%");
		clientes=query.getResultList();
		
		return clientes;
	}
	
	
}
