package pe.edu.upc.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idProyecto;

	@Column(name = "nombreProyecto", length = 50, nullable = false)
	private String nombreProyecto;

	@Column(name = "AnuncioProyecto", length = 50, nullable = false)
	private String AnuncioProyecto;

	@Column(name = "Emprendedor", nullable = false)
	private String emprendedor;

	@Column(name = "FechaFinalizacion", length = 50, nullable = false)
	private String fechaFinalizacion;

	@Column(name = "Descripcion", length = 70, nullable = false)
	private String Descripcion;

	@Column(name = "Estado", length = 70, nullable = false)
	private String Estado;

	// constructor
	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor con parámetros
	public Proyecto(int idProyecto, String nombreProyecto, String AnuncioProyecto, String emprendedor, String fechaFinalizacion,
			String Descripcion, String Estado) {
		super();
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.AnuncioProyecto = AnuncioProyecto;
		this.emprendedor = emprendedor;
		this.fechaFinalizacion = fechaFinalizacion;
		this.Descripcion = Descripcion;
		this.Estado = Estado;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getAnuncioProyecto() {
		return AnuncioProyecto;
	}

	public void setAnuncioProyecto(String anuncioProyecto) {
		AnuncioProyecto = anuncioProyecto;
	}

	public String getEm() {
		return emprendedor;
	}

	public void setEm(String emprendedor) {
		this.emprendedor = emprendedor;
	}

	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

}
