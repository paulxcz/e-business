package pe.edu.upc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.service.IProyectoService;

@Named
@RequestScoped
public class ProyectoController {
	
	@Inject
	private IProyectoService pService;
	
	private Proyecto proyecto;
	List<Proyecto> listaProyecto;
	
	@PostConstruct
	public void init() {
		this.listaProyecto = new ArrayList<Proyecto>();
		this.proyecto = new Proyecto();
		this.listProyecto();
	}
	
	public String newProyecto() {
		this.setProyecto(new Proyecto());
		return "Proyecto.xhtml";
	}
	
	public void insertProyecto() {
		try {
			pService.insert(proyecto);
			this.listProyecto();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void eliminar(Proyecto proyecto) {
		try {
			pService.eliminar(proyecto.getIdProyecto());
			listProyecto();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listProyecto() {
		listaProyecto = pService.list();
	}
	public void clean() {
		this.init();
	}
	
	public void findByName() {
		try {
			if (proyecto.getNombre().isEmpty()) {
				this.listProyecto();
			} else {
				listaProyecto = this.pService.findByNameProyecto(this.getProyecto());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public IProyectoService getpService() {
		return pService;
	}

	public void setpService(IProyectoService pService) {
		this.pService = pService;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Proyecto> getListaProyecto() {
		return listaProyecto;
	}

	public void setListaProyecto(List<Proyecto> listaProyecto) {
		this.listaProyecto = listaProyecto;
	}
	
	
}
