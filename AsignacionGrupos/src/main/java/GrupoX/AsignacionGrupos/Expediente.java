package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Expediente implements Serializable{

	@Id @GeneratedValue
	public Long Num_Expediente;
	@Column(nullable = true)
	public boolean Activo;
	@Column(nullable = true)
	public double Nota_Media_Provisional;
	
	@ManyToOne @JoinColumn(nullable = false)
	private Long Id_alumno;
	
	@OneToMany (cascade=CascadeType.ALL,mappedBy="expediente_alumno")
	private List<Encuesta> encuesta_alumno;
	
	//Falta completar porque no entiendo matricula
	//OneToMany (cascade=CascadeType.ALL, mappedBy="idExpediente")
	//private List<Matricula> matricula; 
	
	@ManyToOne @JoinColumn(nullable = false)
	private Titulacion titulacion;
	
	
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
	
	@Override
	public boolean equals(Object object) {
		if((object instanceof Expediente)) {
			Expediente obj = (Expediente) object;
			return ((Num_Expediente == obj.Num_Expediente));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Num_Expediente.hashCode();
	}
	
	
	
}
