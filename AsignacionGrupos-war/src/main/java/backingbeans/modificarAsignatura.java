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
public class modificarAsignatura {

	private Asignatura asignatura;
	
	private static final Logger LOG = Logger.getLogger(modificarAsignatura.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public String doModificar() {
		try {
			crud.modificarAsignatura(asignatura);
		} catch (AsignaturaNoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.info("La asignatura no esta encontrada");
		}
		return "index.xhtml";
	}
	
	
	
}

