package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.LibroBusiness;
import pe.upc.model.entity.Libro;
import pe.upc.util.Message;

@Named
@SessionScoped
public class LibroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LibroBusiness libroBusiness;

	private Libro libro;
	private List<Libro> libros;
	private Libro libroSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		libro = new Libro();
		libros = new ArrayList<Libro>();
		getAllLibros();
	}

	public void getAllLibros() {
		try {
			libros = libroBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Libros :" + e.getMessage());
		}
	}

	public String newLibro() {
		resetForm();
		return "insert.xhtml";
	}

	public String listLibro() {
		return "list.xhtml";
	}

	public String saveLibro() {
		String view = "";
		try {

			if (libro.getId_libro() != null) {
				libroBusiness.update(libro);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				libroBusiness.insert(libro);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllLibros();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Libro :" + e.getStackTrace());
		}

		return view;
	}

	public String editLibro() {
		String view = "";
		try {
			if (this.libroSelect != null) {
				this.libro = libroSelect;

				view = "/libro/update";
			} else {
				Message.messageInfo("Debe seleccionar un libro");
			}
		} catch (Exception e) {
			Message.messageError("Error Libro :" + e.getMessage());
		}

		return view;
	}

	public void searchLibroByName() {
		try {

			libros = libroBusiness.getLibrosByName(this.filterName.trim());
			resetForm();
			if (libros.isEmpty()) {
				Message.messageInfo("No se encontraron libros");

			}

		} catch (Exception e) {
			Message.messageError("Error Libro Search :" + e.getMessage());
		}
	}

	public void selectLibro(SelectEvent e) {
		this.libroSelect = (Libro) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.libro = new Libro();
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro getLibroSelect() {
		return libroSelect;
	}

	public void setLibroSelect(Libro libroSelect) {
		this.libroSelect = libroSelect;
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