import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.math3.stat.descriptive.summary.Product;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.*;

@Named(value = "dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Alumno> alumnos;

    @EJB
    private CrudEJBLocal crud;

    @PostConstruct
    public void init() {
        alumnos = crud.getAlumnos();
    }

    public List<Alumno> getProducts() {
        return alumnos;
    }

    public void setService(CrudEJBLocal crud) {
        this.crud = crud;
    }
}