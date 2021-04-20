package AsignacionGrupos;


	

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.*;
import Exceptions.*;


	public abstract class LimitePlazasEJB implements LimitePlazas,CrudEJBLocal{

	    /**
	     * Default constructor. 
	     */
	    @PersistenceContext(unitName="AsignacionGrupos")
	    private EntityManager em;



	    public void limitarPlazasNuevoIngreso (Grupo grupo,Long PlazasNuevas) throws GrupoException {
	        if(grupo==null) {
	            throw  new GrupoNoEncontradoException();
	        }
	        Grupo g=em.find(Grupo.class, grupo.getId()); //vinculo con la bd

	        existeGrupo(g);
	        g.setPlazasNuevoIngreso(PlazasNuevas);



	        //q mi grupo este
	        //Entro al grupo
	        //cambio plazas



	        em.persist(g);
	    }
	    public void limitarPlazasRepetidores (Grupo grupo,Long PlazasRep) throws GrupoException {
	        if(grupo==null) {
	            throw  new GrupoNoEncontradoException();
	        }
	        Grupo g=em.find(Grupo.class, grupo.getId()); //vinculo con la bd

	        existeGrupo(g);
	        g.setPlazasRepetidores(PlazasRep);




	        //q mi grupo este
	        //Entro al grupo
	        //cambio plazas


	        em.persist(g);
	    }

	    //eliminar grupo saber nplazas libres totales y el grupo con menos alumnos
	    // en tarde y en mañana

}
