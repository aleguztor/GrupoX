package Entidades;
import java.io.File;
import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Alumno implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705146396193434357L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column(nullable = false, unique = true)
	private String DNI;
	@Column(nullable = false)
	private String Nombre;
	@Column(nullable = false)
	private String Apellido1;
	private String Apellido2;
	@Column(nullable = false)
	private String Email_institucional;
	private String Email_personal;
	private String Telefono;
	private String Movil;
	private String Direccion_notificacion;
	private String Localidad_notificacion;
	private String Provincia_notificacion;
	private String CP_notificacion;
	@OneToMany (mappedBy="alumno", cascade = CascadeType.ALL)
	private List<Expediente> expedientes;
	@ManyToMany
	private List<Grupo> grupos;
	private File pdf;
	
	

	public Alumno() {}
	
	public Alumno(String n, String ap1, String dni, String ei) {
		Nombre = n;
		Apellido1 = ap1;
		DNI = dni;
		Email_institucional = ei;		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}

	public String getEmail_institucional() {
		return Email_institucional;
	}

	public void setEmail_institucional(String email_institucional) {
		Email_institucional = email_institucional;
	}

	public String getEmail_personal() {
		return Email_personal;
	}

	public void setEmail_personal(String email_personal) {
		Email_personal = email_personal;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getMovil() {
		return Movil;
	}

	public void setMovil(String movil) {
		Movil = movil;
	}

	public String getDireccion_notificacion() {
		return Direccion_notificacion;
	}

	public void setDireccion_notificacion(String direccion_notificacion) {
		Direccion_notificacion = direccion_notificacion;
	}

	public String getLocalidad_notificacion() {
		return Localidad_notificacion;
	}

	public void setLocalidad_notificacion(String localidad_notificacion) {
		Localidad_notificacion = localidad_notificacion;
	}

	public String getProvincia_notificacion() {
		return Provincia_notificacion;
	}

	public void setProvincia_notificacion(String provincia_notificacion) {
		Provincia_notificacion = provincia_notificacion;
	}

	public String getCP_notificacion() {
		return CP_notificacion;
	}

	public void setCP_notificacion(String cP_notificacion) {
		CP_notificacion = cP_notificacion;
	}
		
	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public List<Grupo> getAlumno_Grupos() {
		return grupos;
	}

	public void setAlumno_Grupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((CP_notificacion == null) ? 0 : CP_notificacion.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion_notificacion == null) ? 0 : Direccion_notificacion.hashCode());
		result = prime * result + ((Email_institucional == null) ? 0 : Email_institucional.hashCode());
		result = prime * result + ((Email_personal == null) ? 0 : Email_personal.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Localidad_notificacion == null) ? 0 : Localidad_notificacion.hashCode());
		result = prime * result + ((Movil == null) ? 0 : Movil.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Provincia_notificacion == null) ? 0 : Provincia_notificacion.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((pdf == null) ? 0 : pdf.hashCode());
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
		Alumno other = (Alumno) obj;
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (CP_notificacion == null) {
			if (other.CP_notificacion != null)
				return false;
		} else if (!CP_notificacion.equals(other.CP_notificacion))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Direccion_notificacion == null) {
			if (other.Direccion_notificacion != null)
				return false;
		} else if (!Direccion_notificacion.equals(other.Direccion_notificacion))
			return false;
		if (Email_institucional == null) {
			if (other.Email_institucional != null)
				return false;
		} else if (!Email_institucional.equals(other.Email_institucional))
			return false;
		if (Email_personal == null) {
			if (other.Email_personal != null)
				return false;
		} else if (!Email_personal.equals(other.Email_personal))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Localidad_notificacion == null) {
			if (other.Localidad_notificacion != null)
				return false;
		} else if (!Localidad_notificacion.equals(other.Localidad_notificacion))
			return false;
		if (Movil == null) {
			if (other.Movil != null)
				return false;
		} else if (!Movil.equals(other.Movil))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Provincia_notificacion == null) {
			if (other.Provincia_notificacion != null)
				return false;
		} else if (!Provincia_notificacion.equals(other.Provincia_notificacion))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (pdf == null) {
			if (other.pdf != null)
				return false;
		} else if (!pdf.equals(other.pdf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [Id=" + Id + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2="
				+ Apellido2 + ", Email_institucional=" + Email_institucional + ", Email_personal=" + Email_personal
				+ ", Telefono=" + Telefono + ", Movil=" + Movil + ", Direccion_notificacion=" + Direccion_notificacion
				+ ", Localidad_notificacion=" + Localidad_notificacion + ", Provincia_notificacion="
				+ Provincia_notificacion + ", CP_notificacion=" + CP_notificacion + ", expedientes=" + expedientes
				+ ", grupos=" + grupos + ", pdf=" + pdf + "]";
	}

	
}
