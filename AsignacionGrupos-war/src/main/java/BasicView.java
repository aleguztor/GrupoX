import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Exceptions.AlumnoNoEncontradoException;

@Named(value = "listado")
@RequestScoped
public class BasicView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Alumno a;
	
	private List<Alumno> alumnos;

    @Inject
    private CrudEJBLocal crud;
//
//    @PostConstruct
//    public void init() {
//        alumnos = crud.getAlumnos();
//   }
//    
//    public List<Alumno> getAlumnos() {
//        return alumnos;
//    }
    
    public String getSaludo() {
    	return "HOLA";

    }
	
}