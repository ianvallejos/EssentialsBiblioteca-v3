package pe.upc.model.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_usuario;
	private String nombre;
	private String apellido;
	private Long dni;
	private String correo;
	private String contrasena;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private Set<Cliente> cliente;
	  
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private Set<Trabajador> trabajador;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Set<Trabajador> getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Set<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}
	  

	
}