package pe.edu.upc.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.OneToOne;

@Entity
@Table(name = "Emprendedor")
public class Emprendedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmprendedor;
	
	@Column(name = "nombreEmprendedor", length = 50, nullable = false)
	private String nombreEmprendedor;
	@Column(name = "nombreEmpresa", length = 50, nullable=false)
	private String nombreEmpresa;
	@Column(name = "giroNegocio", length = 70, nullable=false)
	private String giroNegocio;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "emprendedor")
	private User user;
	
	// constructor
	public Emprendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor con parámetros
	public Emprendedor(int idEmprendedor, String nombreEmprendedor, String nombreEmpresa,
			String giroNegocio) {
		super();
		this.idEmprendedor = idEmprendedor;
		this.nombreEmprendedor = nombreEmprendedor;
		this.nombreEmpresa = nombreEmpresa;
		this.giroNegocio = giroNegocio;
	}

	// getters and setters
	public int getIdEmprendedor() {
		return idEmprendedor;
	}

	public void setIdEmprendedor(int idEmprendedor) {
		this.idEmprendedor = idEmprendedor;
	}

	public String getNombreEmprendedor() {
		return nombreEmprendedor;
	}

	public void setNombreEmprendedor(String nombreEmprendedor) {
		this.nombreEmprendedor = nombreEmprendedor;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getGiroNegocio() {
		return giroNegocio;
	}

	public void setGiroNegocio(String giroNegocio) {
		this.giroNegocio = giroNegocio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmprendedor;
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
		Emprendedor other = (Emprendedor) obj;
		if (idEmprendedor != other.idEmprendedor)
			return false;
		return true;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
