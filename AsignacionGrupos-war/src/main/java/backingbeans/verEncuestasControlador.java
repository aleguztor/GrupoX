package backingbeans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Encuesta;

@Named
@ApplicationScoped
public class verEncuestasControlador {
		private Encuesta en;
	    private List<Encuesta> encuestas;
	    @Inject
	    private CrudEJBLocal crud;
	    
	    @PostConstruct
	    public void init() {
	       encuestas= crud.getEncuestas();
	    }

	    public List<Encuesta> getEncuestas() {
	       return encuestas;
	    }

	    public synchronized void setEncuesta(Encuesta e) {
	    	en=e;
	    }
	    public synchronized Encuesta getEncuesta() {
	    	return en;
	    }
}
