package backingbeans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Matricula;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.MatriculaNoEncontradaException;

@Named(value="mat")
@RequestScoped
public class matriculaController implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Matricula> matriculas;
	Long num_exp ;
	
	@Inject
	private CrudEJBLocal crud;
	
	/*
	 * @PostConstruct public void init() { try { matriculas =
	 * crud.buscarMatriculasPorExpediente(num_exp); } catch
	 * (MatriculaNoEncontradaException e) { e.printStackTrace(); } }
	 */

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public long getNum_exp() {
		return num_exp;
	}

	public void setNum_exp(long num_exp) {
		this.num_exp = num_exp;
	}
	
	public String outcome() throws ExpedienteNoEncontradoException, MatriculaNoEncontradaException {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.num_exp = getAlumnoParam(fc);
		this.matriculas =crud.buscarMatriculasPorExpediente(num_exp);
		return "matriculaAlumno";
	}
	public Long getAlumnoParam(FacesContext fc)  {
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 
		return Long.parseLong(params.get("numexp"));
	}
}
