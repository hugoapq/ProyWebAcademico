package upn.solweb.academico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column (name="nombreCurso", length=30)
	private String nombre;
	private int creditos;
	
	@ManyToOne
	@JoinColumn(name="profesor_id", nullable=false)
	Profesor profesor;
	
	public Profesor getProfesor() {
		return profesor; 
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Curso() {
		super();		
	}

	public Curso(int id, String nombre, int creditos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	
	public Curso(String nombre, int creditos) {
		super();		
		this.nombre = nombre;
		this.creditos = creditos;
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

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + "]";
	}	
	
}
