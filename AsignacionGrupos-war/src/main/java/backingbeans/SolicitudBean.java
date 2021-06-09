package backingbeans;

import java.io.File;
import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.EncuestaCambioHorario;

@Named
@RequestScoped
public class SolicitudBean {
	
	private File archivo;
	private String razones;
	private String curso;
	private String dni;

    private UploadedFile file;
	
	@Inject 
	CrudEJBLocal crud;
	
	
	public String CrearEncuesta() throws Exception {
		
		Date d = new Date(System.currentTimeMillis());
		EncuestaCambioHorario e= new EncuestaCambioHorario(d,curso,dni);
		e.setDocumentos(file.getContent());
		e.setRazones(razones);
			crud.insertarEncuestaCambioHorario(e);
		return "Alumno.html";
		
	}

	public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
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
