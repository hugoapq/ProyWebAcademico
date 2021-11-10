package upn.solweb.academico.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Facultad {
	@Id
	private int id;
	private String nonbre;
	
	public Facultad(int id, String nonbre) {
		super();
		this.id = id;
		this.nonbre = nonbre;
	}

	public Facultad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNonbre() {
		return nonbre;
	}

	public void setNonbre(String nonbre) {
		this.nonbre = nonbre;
	}
	
	
	
	

}
