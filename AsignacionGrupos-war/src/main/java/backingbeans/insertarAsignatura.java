package backingbeans;


import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.*;

import Exceptions.*;



@Named
@RequestScoped
public class insertarAsignatura {

	private Asignatura asignatura;
	
	private static final Logger LOG = Logger.getLogger(insertarAsignatura.class.getCanonicalName());
	
	@Inject 
	private CrudEJBLocal crud;

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public String doInsertar() throws AsignaturaDuplicadaException, AsignaturaNoEncontradaException {
		
			crud.insertarAsignatura(asignatura);
		
			LOG.info("La asignatura insertarda");
		
		return "index.xhtml";
	}
	
	
	
}

