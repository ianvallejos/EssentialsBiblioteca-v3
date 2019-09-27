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
	@Table(name="prestamo")
	public class Prestamo {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id_prestamo;
		private Date fechaInicio;
		private Date fechaTermina;
		private String observacion;
		private int cantidad;
	
		@ManyToOne
		@JoinColumn(name = "id_usuario", nullable = false)
		private Usuario usuario;
		
		@ManyToOne
		@JoinColumn(name = "prestamo", nullable = false)
		private DetalleLibro detalleLibro;
		
		@OneToMany(mappedBy="prestamo", cascade = CascadeType.ALL)
		private Set<Comprobante> comprobante;

		public Long getId_prestamo() {
			return id_prestamo;
		}

		public void setId_prestamo(Long id_prestamo) {
			this.id_prestamo = id_prestamo;
		}

		public Date getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public Date getFechaTermina() {
			return fechaTermina;
		}

		public void setFechaTermina(Date fechaTermina) {
			this.fechaTermina = fechaTermina;
		}

		public String getObservacion() {
			return observacion;
		}

		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public DetalleLibro getDetalleLibro() {
			return detalleLibro;
		}

		public void setDetalleLibro(DetalleLibro detalleLibro) {
			this.detalleLibro = detalleLibro;
		}

	
		
		
	}