package AsignacionGrupos;


	

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entidades.*;
import Exceptions.*;


	public class LimitePlazasEJB implements LimitePlazas{
	    @PersistenceContext(unitName="AsignacionGrupos")
	    private EntityManager em;



	    @Override
	    public void limitarPlazasNuevoIngreso (Grupo grupo,Long PlazasNuevas) throws GrupoNoEncontradoException {
	    	Grupo g = busquedaGrupo(grupo.getCurso(), grupo.getLetra(), grupo.getTurno_manyana_tarde());
	        if(g==null) {
	            throw  new GrupoNoEncontradoException();
	        }
	        g.setPlazasNuevoIngreso(PlazasNuevas);
	    }
	    @Override
	    public void limitarPlazasRepetidores (Grupo grupo,Long PlazasRep) throws GrupoNoEncontradoException {
	    	Grupo g = busquedaGrupo(grupo.getCurso(), grupo.getLetra(), grupo.getTurno_manyana_tarde());
	        if(g==null) {
	            throw  new GrupoNoEncontradoException();
	        }
	        g.setPlazasRepetidores(PlazasRep);

	    }
	    @Override
        public List<Alumno> EliminarGrupoPorFaltaDeAlumnos(Grupo g) throws GrupoNoEncontradoException{
            Grupo gr = em.find(Grupo.class, g);
            if(gr == null) {
                throw new GrupoNoEncontradoException();
            }
            List<Alumno> alumnos = gr.getAlumno();
            em.remove(em.merge(gr));

            return alumnos;

        }
	    
	    @Override
		public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException {
			TypedQuery<Grupo> q = em.createQuery("SELECT g FROM GRUPO g WHERE g.CURSO LIKE '"+c+"' AND g.LETRA LIKE '"+l+"'"
					+ " AND g.TURNO_MANYANA_TARDE LIKE '"+t+"'", Grupo.class);
			if(q.getSingleResult() == null) {
				throw new GrupoNoEncontradoException();
			}
			return q.getSingleResult();
		}


}
