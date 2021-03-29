package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long Id;
	private String Curso;
	private String Letra;
	private String Turno_mañana_tarde;
	private String Ingles;
	private String Visible;
	private String Asignar;
	private Long Plazas;
	private static final long serialVersionUID = 1L;

	public Grupo() {
		super();
	}   
	public Long getId() {
		return this.Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}   
	public String getCurso() {
		return this.Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}   
	public String getLetra() {
		return this.Letra;
	}

	public void setLetra(String Letra) {
		this.Letra = Letra;
	}   
	public String getTurno_mañana_tarde() {
		return this.Turno_mañana_tarde;
	}

	public void setTurno_mañana_tarde(String Turno_mañana_tarde) {
		this.Turno_mañana_tarde = Turno_mañana_tarde;
	}   
	public String getIngles() {
		return this.Ingles;
	}

	public void setIngles(String Ingles) {
		this.Ingles = Ingles;
	}   
	public String getVisible() {
		return this.Visible;
	}

	public void setVisible(String Visible) {
		this.Visible = Visible;
	}   
	public String getAsignar() {
		return this.Asignar;
	}

	public void setAsignar(String Asignar) {
		this.Asignar = Asignar;
	}   
	public Long getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Long Plazas) {
		this.Plazas = Plazas;
	}
   
}
