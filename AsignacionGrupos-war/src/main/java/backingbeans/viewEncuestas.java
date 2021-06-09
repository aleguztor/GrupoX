package backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Encuesta;

@Named(value="vE")
@RequestScoped
public class viewEncuestas implements Serializable{

	private static final long serialVersionUID = 1232312312L;
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

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}


}