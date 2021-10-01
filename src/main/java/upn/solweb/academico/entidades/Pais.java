package upn.solweb.academico.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idPais;
	@Column (name="nombre_pais", length=30) 
	private String nombre;
	private int poblacion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="capital_idcapital", referencedColumnName="idcapital")
	private Capital capital;
	

	public Pais() {
		super();
	}

	public Pais(String nombre, int poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}	
	
	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

}
