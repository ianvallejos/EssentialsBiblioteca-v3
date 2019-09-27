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
@Table(name="autor")
public class Autor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_autor;
	private String nombre_autor;
	private String apellido_autor;
	
	 @OneToMany(mappedBy="autor", cascade = CascadeType.ALL)
		private Set<AutorLibro> autorLibro;

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getApellido_autor() {
		return apellido_autor;
	}

	public void setApellido_autor(String apellido_autor) {
		this.apellido_autor = apellido_autor;
	}

	public Set<AutorLibro> getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(Set<AutorLibro> autorLibro) {
		this.autorLibro = autorLibro;
	}




	
}