package backingbeans;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Titulacion;
import Exceptions.TitulacionException;

@Named
@RequestScoped
public class insertarTitulacion {
	private Titulacion titulacion;
	private static final Logger LOG = Logger.getLogger(insertarTitulacion.class.getCanonicalName());
	@Inject
	private CrudEJBLocal crud;
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	
	public String doInsertar() throws TitulacionException {
		crud.insertarTitulacion(titulacion);
		LOG.info("Titulacion insertarda");
		return "index.xhtml";
	}
}
