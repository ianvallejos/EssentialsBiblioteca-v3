package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.AutorBusiness;
import pe.upc.model.entity.Autor;
import pe.upc.util.Message;

@Named
@SessionScoped
public class AutorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AutorBusiness autorBusiness;

	private Autor autor;
	private List<Autor> autores;
	private Autor autorSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		autor = new Autor();
		autores = new ArrayList<Autor>();
		getAllAutores();
	}

	public void getAllAutores() {
		try {
			autores = autorBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Autores :" + e.getMessage());
		}
	}

	public String newAutor() {
		resetForm();
		return "insert.xhtml";
	}

	public String listAutor() {
		return "list.xhtml";
	}

	public String saveAutor() {
		String view = "";
		try {

			if (autor.getId_autor() != null) {
				autorBusiness.update(autor);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				autorBusiness.insert(autor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllAutores();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Autor :" + e.getStackTrace());
		}

		return view;
	}

	public String editAutor() {
		String view = "";
		try {
			if (this.autorSelect != null) {
				this.autor = autorSelect;

				view = "/autor/update";
			} else {
				Message.messageInfo("Debe seleccionar un autor");
			}
		} catch (Exception e) {
			Message.messageError("Error Autor :" + e.getMessage());
		}

		return view;
	}

	public void searchAutorByName() {
		try {

			autores = autorBusiness.getAutoresByName(this.filterName.trim());
			resetForm();
			if (autores.isEmpty()) {
				Message.messageInfo("No se encontraron productos");

			}

		} catch (Exception e) {
			Message.messageError("Error Autor Search :" + e.getMessage());
		}
	}

	public void selectAutor(SelectEvent e) {
		this.autorSelect = (Autor) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.autor = new Autor();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Autor getAutorSelect() {
		return autorSelect;
	}

	public void setAutorSelect(Autor autorSelect) {
		this.autorSelect = autorSelect;
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