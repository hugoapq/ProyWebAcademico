package upn.solweb.academico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	@Column (name="nombreCurso", length=30)
	@Size(min=5, max=30, message="El nombre del Curos debe tener como minimo 5 caracteres y como maximo 30")
	@Pattern(regexp="'^[a-zA-Z0-9]{3}'", message="El nombre del Curso debe tener solo letras y numeros" )
	@NotNull(message="El nombre del curso es obligatorio")
	private String nombre;
	
	@Min( 1)
	@Max( 30)
	@NotNull(message="Los creditos son obligatorios")
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
