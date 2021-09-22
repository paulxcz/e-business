package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.service.IProyectoService;


@Named
@RequestScoped
public class ProyectoController {
	
	private IProyectoService pService;
	
	// Atributos
		private Proyecto proyecto;
		List<Proyecto> listaProyecto;

		// Constructor	
		public void init() {
			this.listaProyecto = new ArrayList<Proyecto>();
			this.proyecto = new Proyecto();
			this.list();
		}
		// métodos atender peticiones
		public String newProyecto() {
			this.setProyecto(new Proyecto());
			return "Proyecto.xhtml";
		}
		
		public void insert() {
			try {
				pService.insert(proyecto);
				this.list();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		public void eliminar(Proyecto p) {
			try {
				pService.eliminar(p.getIdProyecto());
				list();
			} catch(Exception e){
				e.getMessage();
			}
		}
		public void list() {
			try {
			listaProyecto = pService.list();
			}catch(Exception e) {
				e.getMessage();
			}
		}
		//getter and setter
		public Proyecto getProyecto() {
			return proyecto;
		}

		public void setProyecto(Proyecto proyecto) {
			this.proyecto = proyecto;
		}

		public List<Proyecto> getListaProyecto() {
			return listaProyecto;
		}

		public void setListaEmprendedores(List<Proyecto> listaProyecto) {
			this.listaProyecto = listaProyecto;
		}

}
