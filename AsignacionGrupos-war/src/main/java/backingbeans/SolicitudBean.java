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
	
	File archivo;
	String razones;
	String curso;
	@Inject 
	CrudEJBLocal crud;
	public void crearEncuesta() throws Exception {
		if(archivo==null || razones==null || curso==null) {
			throw new Exception("faltan datos");
		}else {
			Date d = new Date(System.currentTimeMillis());
			Encuesta e= new Encuesta(d,curso,razones,archivo);
			crud.insertarEncuesta(e);
		}
	
	}
	public void nuevoCurso(String c) {
		curso=c;
	}
	public void razones(String r) {
		razones=r;
	}
	public void uploadedFile(File f) {
		archivo=f;
	}
}
