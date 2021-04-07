package GrupoX.AsignacionGrupos;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
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
	private int Telefono;
	private int Movil;
	private String Direccion_notificacion;
	private String Localidad_notificacion;
	private String Provincia_notificacion;
	private String CP_notificacion;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Id_alumno")
	private List<Expediente> alumno_expedientes;
	
	
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

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getMovil() {
		return Movil;
	}

	public void setMovil(int movil) {
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
	
	
	public List<Expediente> getAlumno_expedientes() {
		return alumno_expedientes;
	}

	public void setAlumno_expedientes(List<Expediente> alumno_expedientes) {
		this.alumno_expedientes = alumno_expedientes;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Alumno) {
			if(((Alumno) o).DNI.equals(DNI) && ((Alumno) o).Nombre.equals(Nombre) && ((Alumno) o).Email_institucional.equals(Email_institucional)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Id.hashCode()+DNI.hashCode()+Nombre.hashCode()+Apellido1.hashCode()+Email_institucional.hashCode();
	}
	
	@Override
	public String toString() {
		return "Alumno "+Id+"\nNombre: "+Nombre+"Apellido1: "+Apellido1+"DNI: "+DNI;
	}
}
