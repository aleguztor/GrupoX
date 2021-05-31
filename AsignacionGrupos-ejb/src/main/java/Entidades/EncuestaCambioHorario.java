package Entidades;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
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
	private String dameDNI;
	private Date Fecha_envio;
	private String razones;
	private String cursoacambiar;
	private File Documentos;
	@ManyToOne
	private Alumno alumno;
	public EncuestaCambioHorario() {}
	
	public EncuestaCambioHorario(Date d, String cursoacambiar, String r, File f, String dni ) {
		Fecha_envio = d;
		this.cursoacambiar = cursoacambiar;
		razones = r;
		Documentos=f;
		dameDNI=dni;
	}



	public String getDameDNI() {
		return dameDNI;
	}



	public void setDameDNI(String dameDNI) {
		this.dameDNI = dameDNI;
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



	public File getDocumentos() {
		return Documentos;
	}



	public void setDocumentos(File documentos) {
		Documentos = documentos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((dameDNI == null) ? 0 : dameDNI.hashCode());
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
		if (dameDNI == null) {
			if (other.dameDNI != null) {
				return false;
			}
	}
		return true;
	}

	@Override
	public String toString() {
		return "EncuestaCambioHorario [DNI=" + dameDNI + ", Fecha de envio=" + Fecha_envio + ", razones=" + razones + ", curso a cambiar=" + cursoacambiar;
	}

	
}
