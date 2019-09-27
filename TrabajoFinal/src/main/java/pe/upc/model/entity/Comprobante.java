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
	@Table(name="comprobante")
	public class Comprobante {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id_comprobante;
		private Date fecha_comprobante;
		private int precio_comprobante;

		@ManyToOne
		@JoinColumn(name = "id_prestamo", nullable = false)
		private Prestamo prestamo;

		  @OneToMany(mappedBy="comprobante", cascade = CascadeType.ALL)
			private Set<Delivery> delivery;

		public Long getId_comprobante() {
			return id_comprobante;
		}

		public void setId_comprobante(Long id_comprobante) {
			this.id_comprobante = id_comprobante;
		}

		public Date getFecha_comprobante() {
			return fecha_comprobante;
		}

		public void setFecha_comprobante(Date fecha_comprobante) {
			this.fecha_comprobante = fecha_comprobante;
		}

		public int getPrecio_comprobante() {
			return precio_comprobante;
		}

		public void setPrecio_comprobante(int precio_comprobante) {
			this.precio_comprobante = precio_comprobante;
		}

		public Prestamo getPrestamo() {
			return prestamo;
		}

		public void setPrestamo(Prestamo prestamo) {
			this.prestamo = prestamo;
		}

		public Set<Delivery> getDelivery() {
			return delivery;
		}

		public void setDelivery(Set<Delivery> delivery) {
			this.delivery = delivery;
		}

		
		
	}
	