package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idProyecto;
	
	@Column(name = "nombre", length = 60 , nullable = false)
	private String nombre;
	@Column(name="anuncio", length = 160, nullable = false)
	private String anuncio;
	
	@ManyToOne
	@JoinColumn(name="idEmprendedor", nullable = false)
	private Emprendedor emprendedor;
	
	/*@Column(name="emprendedor", length = 60, nullable = false)
	private String emprendedor;*/

	@Column(name="descripcion", length = 160, nullable = false)
	private String descripcion;
	@Column(name="estado", length = 60, nullable = false)
	private String estado;
	
	private Date fechaFinalizacion;
	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proyecto(int idProyecto, String nombre, String anuncio, Emprendedor emprendedor,Date fechaFinalizacion, String descripcion,
			String estado) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.anuncio = anuncio;
		this.emprendedor = emprendedor;
		this.fechaFinalizacion = fechaFinalizacion;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}
	/*public String getEmprendedor() {
		return emprendedor;
	}
	public void setEmprendedor(String emprendedor) {
		this.emprendedor = emprendedor;
	}
	*/
	
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public Emprendedor getEmprendedor() {
		return emprendedor;
	}
	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
