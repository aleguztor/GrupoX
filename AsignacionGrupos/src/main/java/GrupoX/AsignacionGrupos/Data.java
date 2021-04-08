package GrupoX.AsignacionGrupos;
import java.util.List;

import javax.persistence.*;

@Entity
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

	
}
