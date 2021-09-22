package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.service.IEmprendedorService;

@Named
@RequestScoped
public class EmprendedorController {
	// CDI
	@Inject
	private IEmprendedorService eService;
	// Atributos
	private Emprendedor emprendedor;
	List<Emprendedor> listaEmprendedores;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaEmprendedores = new ArrayList<Emprendedor>();
		this.emprendedor = new Emprendedor();
		this.list();
	}
	// métodos atender peticiones

	public String newEmprendedor() {
		this.setEmprendedor(new Emprendedor());
		return "Emprendedor.xhtml";
	}

	public void insert() {
		try {
			eService.insert(emprendedor);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public void eliminar(Emprendedor emprendedor) {
		try {
			eService.eliminar(emprendedor.getIdEmprendedor());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		listaEmprendedores = eService.list();
	}
	
	public void clean() {
		this.init();
	}
	
	
	public void findByName() {
		try {
			if (emprendedor.getNombreEmprendedor().isEmpty()) {
				this.list();
			} else {

				listaEmprendedores = this.eService.findByNameEmprendedor(this.getEmprendedor());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Getters and Setters
	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}

	public List<Emprendedor> getListaEmprendedores() {
		return listaEmprendedores;
	}

	public void setListaEmprendedores(List<Emprendedor> listaEmprendedores) {
		this.listaEmprendedores = listaEmprendedores;
	}

}
