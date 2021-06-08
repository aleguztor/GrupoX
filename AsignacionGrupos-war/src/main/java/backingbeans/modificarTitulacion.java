package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Titulacion;

@Named
@RequestScoped
public class modificarTitulacion {
	private Integer codigo;
	@Inject
	CrudEJBLocal crud;
	private Titulacion nueva;
	/*public String doModificarTitulacion() {
		nueva=new Titulacion(this.codigo,"",0);
	if(nueva.getCodigo()==)
	}*/
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
