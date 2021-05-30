package backingbeans;

import java.io.File;
import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Encuesta;

@Named
@RequestScoped
public class SolicitudBean {
	
	private File archivo;
	private String razones;
	private String curso;
	private String dni;
	
	
	@Inject 
	CrudEJBLocal crud;
	public String setCrearEncuesta() throws Exception {
		if(archivo==null || razones==null || curso==null) {
			throw new Exception("faltan datos");
		}else {
			Date d = new Date(System.currentTimeMillis());
			Encuesta e= new Encuesta(d,curso,razones,archivo,dni);
			crud.insertarEncuesta(e);
		}
		return "Encuesta enviada";
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	public String getRazones() {
		return razones;
	}
	public void setRazones(String razones) {
		this.razones = razones;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
