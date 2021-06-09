package Entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EncuestaCambioHorario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 291391231293892L;
	@Id
	private String DNI;
	@Column(nullable = false)
	private Date Fecha_envio;
	private String razones;
	@Column(nullable = false)
	private String cursoacambiar;
	private byte[] Documentos;
	@ManyToOne
	private Alumno alumno;
	public EncuestaCambioHorario() {}
	
	public EncuestaCambioHorario(Date d, String cursoacambiar, String dni ) {
		Fecha_envio = d;
		this.cursoacambiar = cursoacambiar;
		DNI=dni;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dameDNI) {
		this.DNI = dameDNI;
	}



	public Date getFecha_envio() {
		return Fecha_envio;
	}



	public void setFecha_envio(Date fecha_envio) {
		Fecha_envio = fecha_envio;
	}



	public String getRazones() {
		return razones;
	}



	public void setRazones(String razones) {
		this.razones = razones;
	}



	public String getCursoacambiar() {
		return cursoacambiar;
	}



	public void setCursoacambiar(String cursoacambiar) {
		this.cursoacambiar = cursoacambiar;
	}



	public byte[] getDocumentos() {
		return Documentos;
	}



	public void setDocumentos(byte[] documentos) {
		Documentos = documentos;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
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
		EncuestaCambioHorario other = (EncuestaCambioHorario) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EncuestaCambioHorario [DNI=" + DNI + ", Fecha de envio=" + Fecha_envio + ", razones=" + razones + ", curso a cambiar=" + cursoacambiar;
	}

	
}
