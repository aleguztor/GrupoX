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
	private Integer titu;
	private static final Logger LOG = Logger.getLogger(insertarAsignatura.class.getCanonicalName());
	
	@Inject 
	private CrudEJBLocal crud;

	public Asignatura getAsignatura() {
		return asignatura;
	}
	@PostConstruct
	public void init() {
	    asignatura = new Asignatura();
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public String doInsertar() throws AsignaturaDuplicadaException, AsignaturaNoEncontradaException, TitulacionException {
		Titulacion t=crud.ObtenerTitulacionPorId(titu);
		
		asignatura.setTitulacion(t);
		
			crud.insertarAsignatura(asignatura);
		
			LOG.info("La asignatura insertarda");
		
		return "index.xhtml";
	}

	public Integer getTitu() {
		return titu;
	}

	public void setTitu(Integer titu) {
		this.titu = titu;
	}
	
	
	
}

