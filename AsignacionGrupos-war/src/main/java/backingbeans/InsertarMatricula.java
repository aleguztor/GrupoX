package backingbeans;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Matricula;
import Exceptions.MatriculaDuplicadaException;
import Exceptions.MatriculaNoEncontradaException;

@Named("insertarMatriculaBean")
@RequestScoped
public class InsertarMatricula {

	private Matricula matricula = new Matricula();
	
	private static final Logger LOG = Logger.getLogger(modificarAsignatura.class.getCanonicalName());
	
	@Inject
	CrudEJBLocal crud;
	
	public Matricula getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public String doInsertarMatricula() {
		
	    try {
			crud.insertarMatricula(matricula);
		} catch (MatriculaDuplicadaException e) {
			// TODO Auto-generated catch block
			LOG.info("La matricula ya está creada");
		}
		
		return "index.xhtml";
	}
}
