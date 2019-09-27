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
	@Table(name="delivery")
	public class Delivery {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	
		private int id_delivery;
		private Date fechaPedido;
		private Date fechaEntrega;
		private int precio_delivery;
		private String direccion;
	

		@ManyToOne
		@JoinColumn(name = "id_comprobante", nullable = false)
		private Comprobante comprobante;


		public int getId_delivery() {
			return id_delivery;
		}


		public void setId_delivery(int id_delivery) {
			this.id_delivery = id_delivery;
		}


		public Date getFechaPedido() {
			return fechaPedido;
		}


		public void setFechaPedido(Date fechaPedido) {
			this.fechaPedido = fechaPedido;
		}


		public Date getFechaEntrega() {
			return fechaEntrega;
		}


		public void setFechaEntrega(Date fechaEntrega) {
			this.fechaEntrega = fechaEntrega;
		}


		public int getPrecio_delivery() {
			return precio_delivery;
		}


		public void setPrecio_delivery(int precio_delivery) {
			this.precio_delivery = precio_delivery;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public Comprobante getComprobante() {
			return comprobante;
		}


		public void setComprobante(Comprobante comprobante) {
			this.comprobante = comprobante;
		}



		
		
}
