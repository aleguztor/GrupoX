package backingbeans;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Entidades.Matricula;
import Entidades.MatriculaPK;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.MatriculaDuplicadaException;

@Named("insertarMatriculaBean")
@RequestScoped
public class InsertarMatricula {

	private Matricula matricula = new Matricula();
	private Long numexp;
	
	private static final Logger LOG = Logger.getLogger(InsertarMatricula.class.getCanonicalName());
	
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
	    	MatriculaPK pk = new MatriculaPK(matricula.getCurso_academico(), numexp);
	    	LOG.severe(pk.toString());
	    	Expediente e = crud.existeExpedientePorPK(numexp);
	    	matricula = new Matricula(pk,e,matricula.getEstado(), matricula.getFecha_matricula());
			crud.insertarMatricula(matricula);
		} catch (MatriculaDuplicadaException e) {
			LOG.info("La matricula ya está creada");
		} catch (ExpedienteNoEncontradoException e1) {
			e1.printStackTrace();
		}
		
		return "listadoAlumnos.xhtml";
	}

	public Long getNumexp() {
		return numexp;
	}

	public void setNumexp(Long numexp) {
		this.numexp = numexp;
	}
}
