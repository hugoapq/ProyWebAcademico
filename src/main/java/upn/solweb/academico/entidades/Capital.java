package upn.solweb.academico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Capital {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column (name="idcapital")
	private int id;
	@Column (name="nombre_capital", length=45)
	private String nombre;
	
	@OneToOne(mappedBy="capital") 
	private Pais pais;
	
	public Capital() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Capital(String nombre) {
		super();		
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
