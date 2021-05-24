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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mencion == null) ? 0 : mencion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativa other = (Optativa) obj;
		if (mencion == null) {
			if (other.mencion != null)
				return false;
		} else if (!mencion.equals(other.mencion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Optativa [mencion=" + mencion + "]";
	}
	
	
}
