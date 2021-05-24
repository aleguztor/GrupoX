package Entidades;

import java.io.Serializable;
import java.lang.Character;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity

@IdClass(MatriculaPK.class)
public class Matricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2166598667074502398L;
	@Id
	private String curso_academico;
	@Column(nullable = false)
	private Character estado;
	private Integer num_archivo;
	private Character turno_preferente;
	@Column(nullable = false)
	private Date fecha_matricula;
	private Character nuevo_ingreso;
	private String listado_asignaturas;   
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Num_Expediente")
	private Expediente expedientes_num_expedientes;
	@OneToMany(mappedBy="matricula")
	private List<Asignaturas_matriculas> am;
	
	
	public Matricula() {}
	
	public Matricula(MatriculaPK pk, Expediente e, Character c, Date fm) {
		expedientes_num_expedientes = e;
		curso_academico = pk.getCurso_academico();
		estado = c;
		fecha_matricula = fm;
	}
	
	public String getCurso_academico() {
		return this.curso_academico;
	}

	public void setCurso_academico(String curso_academico) {
		this.curso_academico = curso_academico;
	}   
	public Character getEstado() {
		return this.estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}   
	public Integer getNum_archivo() {
		return this.num_archivo;
	}

	public void setNum_archivo(Integer num_archivo) {
		this.num_archivo = num_archivo;
	}   
	public Character getTurno_preferente() {
		return this.turno_preferente;
	}

	public void setTurno_preferente(Character turno_preferente) {
		this.turno_preferente = turno_preferente;
	}   
	public Date getFecha_matricula() {
		return this.fecha_matricula;
	}

	public void setFecha_matricula(Date fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}   
	public Character getNuevo_ingreso() {
		return this.nuevo_ingreso;
	}

	public void setNuevo_ingreso(Character nuevo_ingreso) {
		this.nuevo_ingreso = nuevo_ingreso;
	}   
	public String getListado_asignaturas() {
		return this.listado_asignaturas;
	}

	public void setListado_asignaturas(String listado_asignaturas) {
		this.listado_asignaturas = listado_asignaturas;
	}   
	public Expediente getExpedientes_num_expedientes() {
		return this.expedientes_num_expedientes;
	}

	public void setExpedientes_num_expedientes(Expediente expedientes_num_expedientes) {
		this.expedientes_num_expedientes = expedientes_num_expedientes;
	}

	
	
	public List<Asignaturas_matriculas> getAm() {
		return am;
	}

	public void setAm(List<Asignaturas_matriculas> am) {
		this.am = am;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((am == null) ? 0 : am.hashCode());
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((expedientes_num_expedientes == null) ? 0 : expedientes_num_expedientes.hashCode());
		result = prime * result + ((fecha_matricula == null) ? 0 : fecha_matricula.hashCode());
		result = prime * result + ((listado_asignaturas == null) ? 0 : listado_asignaturas.hashCode());
		result = prime * result + ((nuevo_ingreso == null) ? 0 : nuevo_ingreso.hashCode());
		result = prime * result + ((num_archivo == null) ? 0 : num_archivo.hashCode());
		result = prime * result + ((turno_preferente == null) ? 0 : turno_preferente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (am == null) {
			if (other.am != null)
				return false;
		} else if (!am.equals(other.am))
			return false;
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (expedientes_num_expedientes == null) {
			if (other.expedientes_num_expedientes != null)
				return false;
		} else if (!expedientes_num_expedientes.equals(other.expedientes_num_expedientes))
			return false;
		if (fecha_matricula == null) {
			if (other.fecha_matricula != null)
				return false;
		} else if (!fecha_matricula.equals(other.fecha_matricula))
			return false;
		if (listado_asignaturas == null) {
			if (other.listado_asignaturas != null)
				return false;
		} else if (!listado_asignaturas.equals(other.listado_asignaturas))
			return false;
		if (nuevo_ingreso == null) {
			if (other.nuevo_ingreso != null)
				return false;
		} else if (!nuevo_ingreso.equals(other.nuevo_ingreso))
			return false;
		if (num_archivo == null) {
			if (other.num_archivo != null)
				return false;
		} else if (!num_archivo.equals(other.num_archivo))
			return false;
		if (turno_preferente == null) {
			if (other.turno_preferente != null)
				return false;
		} else if (!turno_preferente.equals(other.turno_preferente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [curso_academico=" + curso_academico + ", estado=" + estado + ", num_archivo=" + num_archivo
				+ ", turno_preferente=" + turno_preferente + ", fecha_matricula=" + fecha_matricula + ", nuevo_ingreso="
				+ nuevo_ingreso + ", listado_asignaturas=" + listado_asignaturas + ", expedientes_num_expedientes="
				+ expedientes_num_expedientes + ", am=" + am + "]";
	}
	
}
