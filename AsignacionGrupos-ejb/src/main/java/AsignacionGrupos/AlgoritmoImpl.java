package AsignacionGrupos;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Encuesta;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Matricula;

@Stateless
public class AlgoritmoImpl implements AlgoritmoIntf{
	
	static class comparatorAlumno implements Comparator<Alumno>{

		@Override
		public int compare(Alumno a1, Alumno a2) {
			Matricula m1 = a1.getExpedientes().get(0).getMatricula().get(0);
			Matricula m2 = a2.getExpedientes().get(0).getMatricula().get(0);
			Encuesta e1 = a1.getExpedientes().get(0).getEncuesta().get(0);
			Encuesta e2 = a2.getExpedientes().get(0).getEncuesta().get(0);
			if(m1.getEstado() == 'I' && m2.getEstado() != 'I') {		
				return 1;
			}else if(e1.getFecha_envio().compareTo(e2.getFecha_envio())<0) {
				return 1;
			}
			return 0;
		}
		
	}
	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	private boolean eq = true;
	private CrudEJBLocal crud;
	//Actualizar cosas en base con los metodos del CRUD
	//Inicialmente tenemos un grupo de mañana y uno de tarde.
	//PORCENTAJES DE ALUMNOS POR TITULACION NO LO TENEMOS EN CUENTA DE MOMENTO.
	//Tener en cuenta el estado. Esto es el algoritmo sin tener en cuenta las plazas.
	// Suponemos que el alumno de primera matricula no tiene activada la matricula hasta el inicio del curso.
	// Hay que preguntar si es asi o no. Matricula Activa = A 	Inactiva = I
	
	// Orden de preferencia --> Fecha envio encuesta, turno y equitativo. Mirar comparator.
	@Override
	public void asignacionGrupos(){
		List<Alumno> alumnos; int grupoMinimo = 30;
		TypedQuery<Alumno> q = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
		alumnos = q.getResultList();
		Collections.sort(alumnos, new comparatorAlumno());
		Iterator<Alumno> it = alumnos.iterator();
		while(it.hasNext()) {
			Alumno a = it.next();
			Matricula ma = a.getExpedientes().get(0).getMatricula().get(a.getExpedientes().get(0).getMatricula().size()-1);
			Character estado = ma.getEstado();
			String listadoasig = ma.getListado_asignaturas();
			String[] asigs = listadoasig.split(", ");
			Expediente e = a.getExpedientes().get(0);
			String turno = e.getEncuesta().get(0).getTurno_Preferente();
			String[] asigres = new String[asigs.length];
			List<Grupo> grupos = null;
			for(int i = 0; i<asigs.length; i++) {
				String asigact = asigs[0].substring(0, 3);
				Asignatura as = buscarAsignaturaPorCodigo(asigact);
				String curso = asigact.substring(0,1);
				boolean idioma = as.isIdioma_de_imparticion();
				Grupo g = buscarGrupoConCondiciones(turno, idioma, curso);
				if(a.getAlumno_Grupos() == null) {
					grupos = new LinkedList<>();
					grupos.add(g);
				}else {
					grupos = a.getAlumno_Grupos();
					grupos.add(g);
				}
				a.setAlumno_Grupos(grupos);
				asigact += g.getLetra();
				asigres[i] = asigact;
			}
			ma.setListado_asignaturas(Arrays.toString(asigres));
			e.getMatricula().remove(0);
			e.getMatricula().add(ma);
			a.getExpedientes().remove(0);
			a.getExpedientes().add(e);
			try {
				crud.modificarAlumno(a);
				crud.modificarMatricula(ma);
				crud.modificarExpediente(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	private Grupo buscarGrupoConCondiciones(String turno, boolean idioma, String curso){
		int idiomaint;
		if(idioma)  idiomaint = 1;
		else  idiomaint = 0;
		TypedQuery<Grupo> q = em.createQuery("SELECT g FROM Grupo g WHERE g.Turno_manyana_tarde LIKE '"+turno+"' AND g.idiomaIngles = '"+idiomaint+"' AND"
				+ " g.Curso = "+Integer.parseInt(curso), Grupo.class);
		List<Grupo> gr = q.getResultList();
		if(idioma) {
			return gr.get(0);
		}else {
			if(eq == true) {
				eq = !eq;
				return gr.get(0);
			}else {
				eq = !eq;
				return gr.get(1);
			}
		}	
	}
	
	
	
	private void asignacionAuxiliar(String curso, Grupo g, String[] asigres, String asigact, int i) {
		switch (curso){
			case "1":
				if(g.getCurso().equals("1º") && g.getPlazasRepetidores()>0) {
					asigact += g.getLetra();
					asigres[i] = asigact;
					g.setPlazasRepetidores(g.getPlazasRepetidores()-1);
				}
				break;
			case "2":
				if(g.getCurso().equals("2º") && g.getPlazasRepetidores()>0) {
					asigact += g.getLetra();
					asigres[i] = asigact;
					g.setPlazasRepetidores(g.getPlazasRepetidores()-1);
				}
				break;
			case "3":
				if(g.getCurso().equals("3º") && g.getPlazasRepetidores()>0) {
					asigact += g.getLetra();
					asigres[i] = asigact;
					g.setPlazasRepetidores(g.getPlazasRepetidores()-1);
				}
				break;
			case "4":
				if(g.getCurso().equals("4º") && g.getPlazasRepetidores()>0) {
					asigact += g.getLetra();
					asigres[i] = asigact;
					g.setPlazasRepetidores(g.getPlazasRepetidores()-1);
				}
				break;
			}
	}
	
	@Override
	public List<Grupo> buscarGrupos(){
		return em.createQuery("SELECT g FROM Grupo g", Grupo.class).getResultList();
	}

	@Override
	public Asignatura buscarAsignaturaPorCodigo(String codigo) {
		TypedQuery<Asignatura> q = em.createQuery("SELECT a FROM Asignatura a WHERE a.Codigo = "+Integer.parseInt(codigo), Asignatura.class);
		return q.getSingleResult();
	}
	
	/*
	 * while(ite.hasNext()) {
				Grupo g = ite.next().getGrupo();
				if(g.getPlazas()>0) {
					String turno = e.getEncuesta().get(0).getTurno_Preferente();
					if(turno.equalsIgnoreCase("manyana") && g.getTurno_manyana_tarde().equalsIgnoreCase("manyana")) {
						if(ma.getEstado() == 'I' && g.getCurso().equals("1º")) {
							if(g.getPlazasNuevoIngreso()>0) {
								asigact += g.getLetra();
								asigres[i] = asigact;
								g.setPlazasNuevoIngreso(g.getPlazasNuevoIngreso()-1);
							}
						}else if(ma.getEstado() == 'A') {
							String curso = asigact.substring(0,1);
							asignacionAuxiliar(curso, g, asigres, asigact, i);
						}
					}else if(turno.equalsIgnoreCase("tarde") && g.getTurno_manyana_tarde().equalsIgnoreCase("tarde")) {
						if(ma.getEstado() == 'I' && g.getCurso().equals("1º")) {
							if(g.getPlazasNuevoIngreso()>0) {
								asigact += g.getLetra();
								asigres[i] = asigact;
								g.setPlazasNuevoIngreso(g.getPlazasNuevoIngreso()-1);
							}
						}else if(ma.getEstado() == 'A') {
							String curso = asigact.substring(0,1);
							asignacionAuxiliar(curso, g, asigres, asigact, i);
						}
					}
				}else {
					
				}
	 */
}
