package backingbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Entidades.Matricula;
import Entidades.MatriculaPK;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.MatriculaDuplicadaException;

@Named(value="insertarMatriculaBean")
@RequestScoped
public class InsertarMatricula {

	private Long numexp;
	private String date;
	private Integer numarch;
	private Matricula matricula;
	private String ca;
	private Character estado;
	private Character tp;
	private Character ni;
	private static final Logger LOG = Logger.getLogger(InsertarMatricula.class.getCanonicalName());
	
	@Inject
	CrudEJBLocal crud;
	
	public Matricula getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public String doInsertarMatricula() {
	    try {
	    	MatriculaPK pk = new MatriculaPK(ca, numexp);
	    	Expediente e = crud.existeExpedientePorPK(numexp);
	    	Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	    	java.sql.Date dt = new java.sql.Date(d.getTime());
	    	matricula = new Matricula(pk,e,estado, dt);
	    	matricula.setNum_archivo(numarch);
	    	matricula.setTurno_preferente(tp);
	    	matricula.setNuevo_ingreso(ni);
			crud.insertarMatricula(matricula);
	    	List<Matricula> lm = new LinkedList<>();
	    	lm.add(matricula);
	    	e.setMatricula(lm);
		} catch (MatriculaDuplicadaException e) {
			LOG.info("La matricula ya está creada");
		} catch (ExpedienteNoEncontradoException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		LOG.severe(matricula.toString());
		return "listadoAlumnos";
	}

	public Long getNumexp() {
		return numexp;
	}

	public void setNumexp(Long numexp) {
		this.numexp = numexp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getNumarch() {
		return numarch;
	}

	public void setNumarch(Integer numarch) {
		this.numarch = numarch;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Character getTp() {
		return tp;
	}

	public void setTp(Character tp) {
		this.tp = tp;
	}

	public Character getNi() {
		return ni;
	}

	public void setNi(Character ni) {
		this.ni = ni;
	}
}
