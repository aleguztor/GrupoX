package backingbeans;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;

@Named
@RequestScoped
public class SolicitudBean {
	private File archivo;
	private String curso;
	private String razones;
	@Inject 
	CrudEJBLocal crud;
	
	public void nuevoCurso(String c) {
		
	}
	public void razones(String r) {
		
	}
	public void uploadedFile(File f) {
		
	}
}
