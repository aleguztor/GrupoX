package backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Asignatura;
import Exceptions.AsignaturaNoEncontradaException;

@Named(value="la")
@RequestScoped
public class listadoAsignaturasController implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Asignatura> asignaturas;
	
	@Inject
	private CrudEJBLocal crud;
	
	@PostConstruct
	public void init() {
		asignaturas = crud.getAsignaturas();
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public String doBorrarAsignatura(String ref) {
		try {
			crud.eliminarAsignaturaPorReferencia(ref);
		} catch (AsignaturaNoEncontradaException e) {
			e.printStackTrace();
		}
		asignaturas = crud.getAsignaturas();
		return "insertarAsignatura.xhtml";
	}
}
