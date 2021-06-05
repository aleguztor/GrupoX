package backingbeans;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Matricula;
import Exceptions.MatriculaNoEncontradaException;

@Named("modificarMatriculaBean")
@RequestScoped
public class ModificarMatricula {

	private Matricula matricula;
	
	private static final Logger LOG = Logger.getLogger(modificarAsignatura.class.getCanonicalName());
	
	@Inject
	CrudEJBLocal crud;
	
	public Matricula getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public String doModificarMatricula() {
		try {
			crud.modificarMatricula(matricula);
		} catch (MatriculaNoEncontradaException e) {
			e.printStackTrace();
			LOG.info("Matricula no encontrada");
		}
		return "index.xhtml";
	}
}
