package backingbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Titulacion;
@Named
@RequestScoped
public class listaTitulaciones {
	private List<Titulacion> titulaciones;
	
	@Inject
	CrudEJBLocal crud;
	
	@PostConstruct
    public void init() {
        titulaciones = crud.obtenerTitulaciones();
    }

	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}

	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}
	
}
