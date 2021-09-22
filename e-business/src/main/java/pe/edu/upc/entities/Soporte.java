package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Soporte")
public class Soporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSoporte;
	
	@Column(name = "DescripcionProblema", length = 50, nullable=false)
	private String DescripcionProblema;
	

	// constructor
	public Soporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor con parámetros
	public Soporte(int idSoporte, String DescripcionProblema) {
		super();
		this.idSoporte = idSoporte;
		this.DescripcionProblema = DescripcionProblema;
		
	}
	
	public int getIdSoporte() {
		return idSoporte;
	}

	public void setIdSoporte(int idSoporte) {
		this.idSoporte = idSoporte;
	}

	public String getDescripcionProblema() {
		return DescripcionProblema;
	}

	public void setDescripcionProblema(String DescripcionProblema) {
		this.DescripcionProblema = DescripcionProblema;
	}
}