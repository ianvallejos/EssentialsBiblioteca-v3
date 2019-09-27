package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.AutorLibroBusiness;
import pe.upc.business.AutorBusiness;
import pe.upc.business.LibroBusiness;
import pe.upc.model.entity.AutorLibro;
import pe.upc.model.entity.Libro;
import pe.upc.model.entity.Autor;
import pe.upc.util.Message;

@Named
@SessionScoped
public class AutorLibroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AutorLibroBusiness autorlibroBusiness;
	
	@Inject
	private AutorBusiness autorBusiness;
	
	@Inject
	private LibroBusiness libroBusiness;

	private AutorLibro autorlibro;
	private List<AutorLibro> autorlibros;
	private AutorLibro autorlibroSelect;
	
	private Autor autor;
	private List<Autor> autores;
	
	private Libro libro;
	private List<Libro> libros;

	private String filterName;

	@PostConstruct
	public void init() {
		autorlibro = new AutorLibro();
		autorlibros = new ArrayList<AutorLibro>();
		getAllAutorLibros();
		
		autor = new Autor();
		autores = new ArrayList<>();
		
		libro = new Libro();
		libros = new ArrayList<>();
	}

	public void getAllAutorLibros() {
		try {
			autorlibros = autorlibroBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de AutorLibros :" + e.getMessage());
		}
	}

	public String newAutorLibro() {
		try {
			this.libros = libroBusiness.getAll();
			this.autores = autorBusiness.getAll();
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "insert.xhtml";
	}

	public String listAutorLibro() {
		return "list.xhtml";
	}

	public String saveAutorLibro() {
		String view = "";
		try {

			if (autorlibro.getId_autorlibro() != null) {
				autorlibro.setLibro(libro);
				autorlibro.setAutor(autor);
				autorlibroBusiness.update(autorlibro);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				autorlibro.setLibro(libro);
				autorlibro.setAutor(autor);
				autorlibroBusiness.insert(autorlibro);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllAutorLibros();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error AutorLibro :" + e.getStackTrace());
		}

		return view;
	}

	public String editAutorLibro() {
		String view = "";
		try {
			if (this.autorlibroSelect != null) {
				this.autorlibro = autorlibroSelect;

				view = "/autorlibro/update";
			} else {
				Message.messageInfo("Debe seleccionar un autorlibro");
			}
		} catch (Exception e) {
			Message.messageError("Error AutorLibro :" + e.getMessage());
		}

		return view;
	}

	public void searchAutorLibroByName() {
		try {

			autorlibros = autorlibroBusiness.getAutorLibrosByName(this.filterName.trim());
			resetForm();
			if (autorlibros.isEmpty()) {
				Message.messageInfo("No se encontraron productos");

			}

		} catch (Exception e) {
			Message.messageError("Error AutorLibro Search :" + e.getMessage());
		}
	}

	public void selectAutorLibro(SelectEvent e) {
		this.autorlibroSelect = (AutorLibro) e.getObject();
	}

	public void resetForm() {
		this.filterName="";
		this.autorlibro = new AutorLibro();
	}

	public AutorLibro getAutorLibro() {
		return autorlibro;
	}

	public void setAutorLibro(AutorLibro autorlibro) {
		this.autorlibro = autorlibro;
	}

	public List<AutorLibro> getAutorLibros() {
		return autorlibros;
	}

	public void setAutorLibros(List<AutorLibro> autorlibros) {
		this.autorlibros = autorlibros;
	}

	public AutorLibro getAutorLibroSelect() {
		return autorlibroSelect;
	}

	public void setAutorLibroSelect(AutorLibro autorlibroSelect) {
		this.autorlibroSelect = autorlibroSelect;
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
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro supplier) {
		this.libro = supplier;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
}