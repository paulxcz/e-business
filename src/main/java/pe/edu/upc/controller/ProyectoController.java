package pe.edu.upc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.service.IEmprendedorService;
import pe.edu.upc.service.IProyectoService;

@Named
@RequestScoped
public class ProyectoController {
	
	@Inject
	private IProyectoService pService;
	@Inject
	private IEmprendedorService eService;
	
	private Proyecto proyecto;
	List<Proyecto> listaProyecto;
	
	private Emprendedor emprendedor;
	List<Emprendedor> listEmprendedores;
	
	@PostConstruct
	public void init() {
		this.listaProyecto = new ArrayList<Proyecto>();
		this.proyecto = new Proyecto();
		this.listEmprendedores = new ArrayList<Emprendedor>();
		this.emprendedor = new Emprendedor();
		this.listProyecto();
		this.listarEmprendedores();
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
	public void listarEmprendedores() {
		try {
			listEmprendedores = eService.list();
		}catch(Exception e) {
			e.getMessage();
		}
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
	// modificar
    public void modificar() {
        try {
            pService.modificar(this.proyecto);
            this.listProyecto();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String Modifpre(Proyecto pro) {
        this.setProyecto(pro);
        return "ProyectoMod.xhtml";

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

	public IEmprendedorService geteService() {
		return eService;
	}

	public void seteService(IEmprendedorService eService) {
		this.eService = eService;
	}

	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}

	public List<Emprendedor> getListEmprendedores() {
		return listEmprendedores;
	}

	public void setListEmprendedores(List<Emprendedor> listEmprendedores) {
		this.listEmprendedores = listEmprendedores;
	}
	
	
}
