package AsignacionGrupos;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.ejb.*;
import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Matricula;
import Exceptions.*;

@Stateless
public class ModificarGrupoEJB implements ModificarGrupoAlumno{
	private EntityManager em;
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) throws MatriculaNoEncontradaException{
		Matricula ma = em.find(Matricula.class, m.getCurso_academico());
		if(ma == null){
			throw new MatriculaNoEncontradaException();
		}
		Expediente e = ma.getExpedientes_num_expedientes();
		return e.getAlumno().getAlumno_Grupos();
	}
	
	//Suponiedo que solo exista el expediente de informatica
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) throws GrupoNoEncontradoException{
		Grupo gr = busquedaGrupo(g.getCurso(), g.getLetra(), g.getTurno_manyana_tarde());
		if(gr == null) {
			throw new GrupoNoEncontradoException();
		}
		List<Alumno> alumnos = gr.getAlumno();
		Iterator<Alumno> it = alumnos.iterator();
		List<Matricula> matriculas = new LinkedList<>();
		while(it.hasNext()) {
			Matricula m = it.next().getExpedientes().get(0).getMatricula().get(0);
			matriculas.add(m);
		}
		return matriculas;
	}
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws  NoExisteGrupoEnAlumno, GrupoNoEncontradoException{
		Grupo ant = busquedaGrupo(antiguo.getCurso(), antiguo.getLetra(), antiguo.getTurno_manyana_tarde());
		Grupo n = busquedaGrupo(nuevo.getCurso(), nuevo.getLetra(), nuevo.getTurno_manyana_tarde());
		if(ant == null) {
			throw new GrupoNoEncontradoException();
		}
		if(n == null) {
			throw new GrupoNoEncontradoException();
		}
		Iterator<Alumno> it = alum.iterator();
		while(it.hasNext()) {
			Alumno al= it.next();
			List<Grupo> grupos= al.getAlumno_Grupos();
			
			if(grupos.indexOf(ant)<0) {
				throw new NoExisteGrupoEnAlumno();
			}
		
			grupos.remove(ant);
			grupos.add(n);	
		}
	}
	@Override
	public void CambioHorarioyGrupo(Alumno alum, Grupo antiguo, Grupo nuevo) throws AsignacionGruposException {
		if(alum==null) {
			throw  new AlumnoNoEncontradoException();
		}
		
		List<Grupo> grupos= alum.getAlumno_Grupos();
		grupos.remove(antiguo);
		grupos.add(nuevo);			
	}
	
	@Override
	public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException {
		TypedQuery<Grupo> q = em.createQuery("SELECT g FROM GRUPO g WHERE g.CURSO= :c AND g.LETRA= :l AND g.TURNO_MANYANA_TARDE= :t", Grupo.class);
		if(q.getSingleResult() == null) {
			throw new GrupoNoEncontradoException();
		}
		return q.getSingleResult();
	}
}
