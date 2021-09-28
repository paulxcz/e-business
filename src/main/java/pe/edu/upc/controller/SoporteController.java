package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Soporte;
import pe.edu.upc.service.ISoporteService;

@Named
@RequestScoped
public class SoporteController {
	// CDI
	@Inject
	private ISoporteService eService;
	// Atributos
	private Soporte soporte;
	List<Soporte> listaSoportes;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaSoportes = new ArrayList<Soporte>();
		this.soporte = new Soporte();
		this.list();
	}
	// métodos atender peticiones

	public String newSoporte() {
		this.setSoporte(new Soporte());
		return "Soporte.xhtml";
	}

	public void insert() {
		try {
			eService.insert(soporte);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public void eliminar(Soporte soporte) {
		try {
			eService.eliminar(soporte.getIdSoporte());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}


	public void list() {
		listaSoportes = eService.list();
	}
	
	public void clean() {
		this.init();
	}
	
	
	public void findByName() {
		try {
			if (soporte.getNombreSoporte().isEmpty()) {
				this.list();
			} else {

				listaSoportes = this.eService.findByNameSoporte(this.getSoporte());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Getters and Setters
	public Soporte getSoporte() {
		return soporte;
	}

	public void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}

	public List<Soporte> getListaSoportes() {
		return listaSoportes;
	}

	public void setListaSoportes(List<Soporte> listaSoportes) {
		this.listaSoportes = listaSoportes;
	}

}