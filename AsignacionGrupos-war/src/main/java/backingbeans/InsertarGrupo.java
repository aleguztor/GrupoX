package backingbeans;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Grupo;
import Exceptions.GrupoDuplicadoException;

@Named("grupoBean")
@RequestScoped
public class InsertarGrupo {

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
	
	public String doInsertar() {
			try {
			
				Random r = new Random();
				grupo.setId(r.nextLong());
				crud.insertarGrupo(grupo);
			} catch (GrupoDuplicadoException e) {
				// TODO Auto-generated catch block
				LOG.info("El grupo ya esta en la Base de datos incluido");
			}
		
		return "index.xhtml";
	}
}