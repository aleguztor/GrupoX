package AsignacionGrupos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Asignaturas_matriculas;
import Entidades.Centro;
import Entidades.Clase;
import Entidades.Data;
import Entidades.Encuesta;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Grupos_Por_Asignatura;
import Entidades.Matricula;
import Entidades.Optativa;
import Entidades.Titulacion;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.AsignaturaException;
import Exceptions.AsignaturaMatriculaException;
import Exceptions.CentroException;
import Exceptions.ClaseException;
import Exceptions.DataException;
import Exceptions.EncuestaException;
import Exceptions.ExpedienteDuplicadoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.GrupoAsignaturaException;
import Exceptions.GrupoException;
import Exceptions.MatriculaNoEncontradaException;
import Exceptions.OptativaNoEncontradaExpception;
import Exceptions.TitulacionException;

/**
 * Session Bean implementation class CrudEJB
 */
@Stateless
@LocalBean
public class CrudEJB implements CrudEJBLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="AsignacionGrupos")
	private EntityManager em;
	
    public CrudEJB() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = em.find(Expediente.class, e.getNum_Expediente());
		if(ex==null) {
			throw new ExpedienteNoEncontradoException();
		}
		return ex;
	}

	@Override
	public void modificarExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = existeExpediente(e);
		em.merge(e);
		
	}

	@Override
	public void eliminarExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = existeExpediente(e);
		em.remove(ex);
		
	}

	@Override
	public void insertarExpediente(Expediente e) throws  ExpedienteDuplicadoException {
		Expediente ex = em.find(Expediente.class, e.getNum_Expediente());
		if(ex == null)
			em.persist(ex);
		else 
			throw new ExpedienteDuplicadoException();
	}

	@Override
	public void insertarAlumno(Alumno a) throws  AlumnoDuplicadoException {
		Alumno al = em.find(Alumno.class, a.getId());
		if(al == null)
			em.persist(al);
		else 
			throw new AlumnoDuplicadoException();
		
	}

	@Override
	public void modificarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = existeAlumno(a);
		em.merge(a);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = em.find(Alumno.class, a.getId());
		if(al == null)
			throw new AlumnoNoEncontradoException();
		else
			return al;
	}

	@Override
	public void insertarOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optativa existeOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Matricula existeMatriucla(Matricula m) throws MatriculaNoEncontradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimnarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Grupos_Por_Asignatura existeGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarGrupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarGrupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarGrupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Grupo existeGrupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarTitulacion(Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarTitulacion(Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTitulacion(Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Titulacion existeTitulacion(Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarAsignatura(Asignatura a) throws AsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAsignatura(Asignatura a) throws AsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a) throws AsignaturaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asignatura existeAsignatura(Asignatura a) throws AsignaturaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarAsignaturasMatriculas(Asignaturas_matriculas am) throws AsignaturaMatriculaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAsignaturasMatriculas(Asignaturas_matriculas am) throws AsignaturaMatriculaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAsignaturasMatriculas(Asignaturas_matriculas am) throws AsignaturaMatriculaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asignaturas_matriculas existeAsignaturasMatriculas(Asignaturas_matriculas am)
			throws AsignaturaMatriculaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarCentro(Centro c) throws CentroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCentro(Centro c) throws CentroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Centro existeCentro(Centro c) throws CentroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCentro(Centro c) throws CentroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarEncuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEncuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEncuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Encuesta existeEncuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarData(Data d) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarData(Data d) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarData(Data d) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Data existeData(Data d) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarClase(Clase c) throws ClaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarClase(Clase c) throws ClaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarClase(Clase c) throws ClaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clase existeClase(Clase c) throws ClaseException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
