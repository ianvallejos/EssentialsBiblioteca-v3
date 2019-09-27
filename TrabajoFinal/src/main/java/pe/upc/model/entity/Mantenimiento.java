package pe.upc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="mantenimiento")
public class Mantenimiento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id_mantenimiento;
	private Date fecha_mantenimiento;
	private String observacion;

	@ManyToOne
	@JoinColumn(name = "id_libro", nullable = false)
	private Libro libro;

	public int getId_mantenimiento() {
		return id_mantenimiento;
	}

	public void setId_mantenimiento(int id_mantenimiento) {
		this.id_mantenimiento = id_mantenimiento;
	}

	public Date getFecha_mantenimiento() {
		return fecha_mantenimiento;
	}

	public void setFecha_mantenimiento(Date fecha_mantenimiento) {
		this.fecha_mantenimiento = fecha_mantenimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	
}