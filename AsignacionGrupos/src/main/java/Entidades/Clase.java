package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(Entidades.Clase.Clase_PK.class)
public class Clase implements Serializable {
	public static class Clase_PK implements Serializable{
		private Long grupo;
		@EmbeddedId
		private ClasePK clases;
		private static final long serialVersionUID = 1L;

		public Clase_PK() {}
		
		public Clase_PK(Long g, ClasePK c) {
			grupo = g;
			clases = c;
		}
		
		public ClasePK getClase() {
			return clases;
		}

		public void setClase(ClasePK clase) {
			this.clases = clase;
		}

		public Long getGrupo() {
			return grupo;
		}

		public void setGrupo(Long grupo) {
			this.grupo = grupo;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Clase_PK) {
				if(((Clase_PK) o).clases.equals(clases) && ((Clase_PK) o).grupo.equals(grupo)){
							return true;
						}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return clases.hashCode() + grupo.hashCode();
		}
		
	}
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Id")
	private Grupo grupo;
	@Id
	private ClasePK clases;
	@Temporal(TemporalType.TIME)
	private Date Horafin;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Asignatura asignatura;

	public Clase() {}
	
	public Clase(Grupo g, ClasePK c) {
		grupo = g;
		clases = c;
	}
	
	public ClasePK getClasePK() {
		return clases;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Date getHorafin() {
		return this.Horafin;
	}

	public void setHorafin(Date Horafin) {
		this.Horafin = Horafin;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Clase) {
			if(((Clase) o).asignatura.equals(asignatura) && ((Clase) o).clases.equals(clases) && ((Clase) o).grupo.equals(grupo)
					&& ((Clase) o).Horafin.equals(Horafin)){
						return true;
					}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return clases.hashCode() + grupo.hashCode();
	}
   
}
