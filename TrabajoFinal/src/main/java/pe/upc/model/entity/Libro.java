package pe.upc.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="libro")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id_libro;
	private String nombre_libro;
    private Date fecha_Ingreso;
	
    @OneToMany(mappedBy="libro", cascade = CascadeType.ALL)
	private Set<AutorLibro> autorLibro;
    
    @OneToMany(mappedBy="libro", cascade = CascadeType.ALL)
   	private Set<Mantenimiento> mantenimiento;
    
    @OneToMany(mappedBy="libro", cascade = CascadeType.ALL)
   	private Set<DetalleLibro> detalleLibro;

	public Long getId_libro() {
		return id_libro;
	}

	public void setId_libro(Long id_libro) {
		this.id_libro = id_libro;
	}

	public String getNombre_libro() {
		return nombre_libro;
	}

	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}

	public Date getFecha_Ingreso() {
		return fecha_Ingreso;
	}

	public void setFecha_Ingreso(Date fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public Set<AutorLibro> getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(Set<AutorLibro> autorLibro) {
		this.autorLibro = autorLibro;
	}

	public Set<Mantenimiento> getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Set<Mantenimiento> mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public Set<DetalleLibro> getDetalleLibro() {
		return detalleLibro;
	}

	public void setDetalleLibro(Set<DetalleLibro> detalleLibro) {
		this.detalleLibro = detalleLibro;
	}

	



}