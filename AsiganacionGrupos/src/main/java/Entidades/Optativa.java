package Entidades;
import javax.persistence.*;

@Entity
@DiscriminatorValue("O")
public class Optativa extends Asignatura{
	private String mencion;
	
	public Optativa() {
		super();
	}
	
	public Optativa(String r, String n, int c, int cred, boolean of, boolean idimp) {
		super(r,n,c,cred,of,idimp);
	}

	public String getMencion() {
		return mencion;
	}

	public void setMencion(String mencion) {
		this.mencion = mencion;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Optativa) {
			if(((Optativa) o).mencion.equals(mencion)){
						return true;
					}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return mencion.hashCode();
	}
	
	
}
