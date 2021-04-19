package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Expediente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Num_Expediente;
	@Column(nullable = true)
	private boolean Activo;
	@Column(nullable = true)
	private double Nota_Media_Provisional;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Alumno alumno;
	@ManyToOne
	private Titulacion titulacion;
	@OneToMany(mappedBy="expediente")
	private List<Encuesta> encuesta;
	@OneToMany(mappedBy="expedientes_num_expedientes")
	private List<Matricula> matricula = new LinkedList<>();
	
	public Expediente() {}
	
	public Expediente(Long num_Expediente, boolean activo, double nota_Media_Provisional) {
		Num_Expediente = num_Expediente;
		Activo = activo;
		Nota_Media_Provisional = nota_Media_Provisional;
	}
	public Long getNum_Expediente() {
		return Num_Expediente;
	}
	public void setNum_Expediente(Long num_Expediente) {
		Num_Expediente = num_Expediente;
	}
	public boolean isActivo() {
		return Activo;
	}
	public void setActivo(boolean activo) {
		Activo = activo;
	}
	public double getNota_Media_Provisional() {
		return Nota_Media_Provisional;
	}
	public void setNota_Media_Provisional(double nota_Media_Provisional) {
		Nota_Media_Provisional = nota_Media_Provisional;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno a) {
		alumno = a;
	}
	
	
	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Encuesta> getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(List<Encuesta> encuesta) {
		this.encuesta = encuesta;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Activo ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(Nota_Media_Provisional);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
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
		Expediente other = (Expediente) obj;
		if (Activo != other.Activo)
			return false;
		if (Double.doubleToLongBits(Nota_Media_Provisional) != Double.doubleToLongBits(other.Nota_Media_Provisional))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		return true;
	}
	
	
}
