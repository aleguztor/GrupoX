package backingbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Centro;
import Exceptions.CentroException;
@Named
@RequestScoped
public class CentroController {
	
	private Long id;
	private String nombre;
	private String direccion;
	private String tlfConserjeria;
	private List<Centro> centros;
	

	@Inject 
	CrudEJBLocal crud;
	
	@PostConstruct
	public void init() {
		centros = crud.getCentros();
	}
	
	
	public String CrearCentro() throws CentroException {
		Centro c= new Centro(id, nombre, direccion, tlfConserjeria);
		crud.insertarCentro(c);
		return "Main.html";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTlfConserjeria() {
		return tlfConserjeria;
	}
	public void setTlfConserjeria(String tlfConserjeria) {
		this.tlfConserjeria = tlfConserjeria;
	}


	public List<Centro> getCentros() {
		return centros;
	}


	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}

	
}
