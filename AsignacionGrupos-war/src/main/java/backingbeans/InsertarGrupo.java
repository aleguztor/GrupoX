package backingbeans;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Grupo;
import Entidades.Titulacion;
import Exceptions.GrupoDuplicadoException;

@Named("grupoBean")
@RequestScoped
public class InsertarGrupo {
	private List<Grupo> grupos;
	private Grupo grupo = new Grupo();

	private static final Logger LOG = Logger.getLogger(InsertarGrupo.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;

	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	@PostConstruct
    public void init() {
        grupos = crud.obtenerGrupos();
    }
	
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public String doInsertar() throws GrupoDuplicadoException{
			
				crud.insertarGrupo(grupo);
			
		return "Main.html";
	}
	
}