package pe.upc.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "autorLibro")
public class AutorLibro   {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_autorlibro;
	
	@ManyToOne
	@JoinColumn
	private Libro libro;
	
	
	@ManyToOne
	@JoinColumn
	private Autor autor;


	public Long getId_autorlibro() {
		return id_autorlibro;
	}


	public void setId_autorlibro(Long id_autorlibro) {
		this.id_autorlibro = id_autorlibro;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

	

	
}