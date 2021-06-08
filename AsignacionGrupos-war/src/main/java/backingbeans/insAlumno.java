package backingbeans;


import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Titulacion;
import Exceptions.*;



@Named("alumnoBean")
@RequestScoped
public class insAlumno {

	
	private Alumno alumno = new Alumno();
	private Expediente expediente = new Expediente();
	private static final Logger LOG = Logger.getLogger(insAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Expediente getExpediente() {
		return expediente;
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public String doCrearAlumno() throws TitulacionException {
		try {
			
			crud.insertarAlumno(alumno);
			try {
				
				expediente.setTitulacion(crud.obtenerTitulacionPorId(1041));
				expediente.setAlumno(alumno);
				expediente.setActivo(true);
				expediente.setNota_Media_Provisional(0);
				crud.insertarExpediente(expediente);
			} catch (ExpedienteDuplicadoException e) {
				// TODO Auto-generated catch block
				LOG.info("El expediente ya ha sido creado antes");
			}
		} catch (AlumnoDuplicadoException e) {
				LOG.info("El alumno ya esta en Base de datos incluido");
		}
		return "index";
	}
	
	public List<Alumno> listaAlumnos(){
		 return crud.getAlumnos();
	}

	
	
}
