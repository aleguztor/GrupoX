package backingbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import AsignacionGrupos.ImportacionExcel;
import Exceptions.ExcelNoEncontradoException;

@Named
@RequestScoped
public class ImportarControllador {
	private Part uploadedFile;
	@Inject
	private ImportacionExcel ie;
	private String folder ="/opt/jboss";

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String importarAlumnos() throws ExcelNoEncontradoException, URISyntaxException {
		if(uploadedFile != null) {
			String filename ="";
			try(InputStream input = uploadedFile.getInputStream()){
				filename = uploadedFile.getSubmittedFileName();
				Files.copy(input, new File(folder,filename).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

					ie.ImportarExcel(folder+"/"+filename);
		}
		
		
		return "index.xhtml";
	}

}
