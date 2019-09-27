package pe.upc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")
public class Trabajador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int Salario;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	public int getSalario() {
		return Salario;
	}

	public void setSalario(int salario) {
		Salario = salario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	


	
	
	
}