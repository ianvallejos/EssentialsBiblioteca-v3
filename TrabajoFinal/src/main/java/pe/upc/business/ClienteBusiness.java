package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Cliente;
import pe.upc.model.entity.Usuario;
import pe.upc.model.repository.ClienteRepository;
import pe.upc.model.repository.UsuarioRepository;


@Named
public class ClienteBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteRepository clienteRepository;
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Long insert(Usuario usuario) throws Exception {
		return usuarioRepository.insert(usuario);
	}

	
	@Transactional
	public Long update(Usuario usuario) throws Exception{
		return usuarioRepository.update(usuario);
	}
	
	
	public List<Cliente> getAll() throws Exception {
		return clienteRepository.findAll();
	}
	
	
	public List<Cliente> getProductsByName(String name) throws Exception{
		return clienteRepository.findByName(name);
	}
}