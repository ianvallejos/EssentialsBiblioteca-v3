package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.PrestamoBusiness;
import pe.upc.model.entity.Prestamo;
import pe.upc.util.Message;

@Named
@SessionScoped
public class PrestamoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PrestamoBusiness prestamoBusiness;

	private Prestamo prestamo;
	private List<Prestamo> prestamos;
	private Prestamo prestamoSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		prestamo = new Prestamo();
		prestamos = new ArrayList<Prestamo>();
		getAllPrestamo();
	}

	public void getAllPrestamo() {
		try {
			prestamos = prestamoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Prestamo :" + e.getMessage());
		}
	}

	public String newPrestamo() {
		resetForm();
		return "insert.xhtml";
	}

	public String listPrestamo() {
		return "list.xhtml";
	}

	public String savePrestamo() {
		String view = "";
		try {

			if (prestamo.getId_prestamo() != null) {
				prestamoBusiness.update(prestamo);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				prestamoBusiness.insert(prestamo);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllPrestamo();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Prestamo :" + e.getStackTrace());
		}

		return view;
	}

	public String editPrestamo() {
		String view = "";
		try {
			if (this.prestamoSelect != null) {
				this.prestamo = prestamoSelect;

				view = "/prestamo/update";
			} else {
				Message.messageInfo("Debe seleccionar un prestamo");
			}
		} catch (Exception e) {
			Message.messageError("Error Prestamo:" + e.getMessage());
		}

		return view;
	}

	public void searchPrestamoByName() {
		try {

			prestamos = prestamoBusiness.getPrestamosByName(this.filterName.trim());
			resetForm();
			if (prestamos.isEmpty()) {
				Message.messageInfo("No se encontraron prestamos");

			}

		} catch (Exception e) {
			Message.messageError("Error Prestamo Search :" + e.getMessage());
		}
	}

	public void selectusPrestamo(SelectEvent e) {
		this.prestamoSelect = (Prestamo) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.prestamo = new Prestamo();
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setLibro(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public List<Prestamo> gePrestamo() {
		return prestamos;
	}

	public void setLibros(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo getLibroSelect() {
		return prestamoSelect;
	}

	public void setUsuarioSelect(Prestamo prestamoSelect) {
		this.prestamoSelect = prestamoSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}