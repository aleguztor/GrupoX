package Entidades;


import javax.persistence.*;


public class Data {
	
	private String grupos_asignados;
	private int nota_media;
	private int creditos_superados;
	private int creditos_FB;
	private int creditos_OB;
	private int creditos_OP;
	private int creditos_CF;
	private int creditos_TF;
	
	public Data() {}

	public String getGrupos_asignados() {
		return grupos_asignados;
	}

	public void setGrupos_asignados(String grupos_asignados) {
		this.grupos_asignados = grupos_asignados;
	}

	public int getNota_media() {
		return nota_media;
	}

	public void setNota_media(int nota_media) {
		this.nota_media = nota_media;
	}

	public int getCreditos_superados() {
		return creditos_superados;
	}

	public void setCreditos_superados(int creditos_superados) {
		this.creditos_superados = creditos_superados;
	}

	public int getCreditos_FB() {
		return creditos_FB;
	}

	public void setCreditos_FB(int creditos_FB) {
		this.creditos_FB = creditos_FB;
	}

	public int getCreditos_OB() {
		return creditos_OB;
	}

	public void setCreditos_OB(int creditos_OB) {
		this.creditos_OB = creditos_OB;
	}

	public int getCreditos_OP() {
		return creditos_OP;
	}

	public void setCreditos_OP(int creditos_OP) {
		this.creditos_OP = creditos_OP;
	}

	public int getCreditos_CF() {
		return creditos_CF;
	}

	public void setCreditos_CF(int creditos_CF) {
		this.creditos_CF = creditos_CF;
	}

	public int getCreditos_TF() {
		return creditos_TF;
	}

	public void setCreditos_TF(int creditos_TF) {
		this.creditos_TF = creditos_TF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditos_CF;
		result = prime * result + creditos_FB;
		result = prime * result + creditos_OB;
		result = prime * result + creditos_OP;
		result = prime * result + creditos_TF;
		result = prime * result + creditos_superados;
		result = prime * result + ((grupos_asignados == null) ? 0 : grupos_asignados.hashCode());
		result = prime * result + nota_media;
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
		Data other = (Data) obj;
		if (creditos_CF != other.creditos_CF)
			return false;
		if (creditos_FB != other.creditos_FB)
			return false;
		if (creditos_OB != other.creditos_OB)
			return false;
		if (creditos_OP != other.creditos_OP)
			return false;
		if (creditos_TF != other.creditos_TF)
			return false;
		if (creditos_superados != other.creditos_superados)
			return false;
		if (grupos_asignados == null) {
			if (other.grupos_asignados != null)
				return false;
		} else if (!grupos_asignados.equals(other.grupos_asignados))
			return false;
		if (nota_media != other.nota_media)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [grupos_asignados=" + grupos_asignados + ", nota_media=" + nota_media + ", creditos_superados="
				+ creditos_superados + ", creditos_FB=" + creditos_FB + ", creditos_OB=" + creditos_OB
				+ ", creditos_OP=" + creditos_OP + ", creditos_CF=" + creditos_CF + ", creditos_TF=" + creditos_TF
				+ "]";
	}

	
}
