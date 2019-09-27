package pe.upc.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "detalleLibro")
public class DetalleLibro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id_detalle;
	private Date fechaIngreso;
	private String nombre;
	private int stock;

	@OneToMany(mappedBy="detalleLibro", cascade = CascadeType.ALL)
	private Set<Prestamo> prestamo;

	@ManyToOne
	@JoinColumn(name = "id_libro", nullable = false)
	private Libro libro;

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Set<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Set<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	
}