package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.service.IMercadologoService;

@Named
@RequestScoped
public class MercadologoController {

	//traer metodos
	@Inject
	private IMercadologoService mService;
	
	
	//atributos
	List<Mercadologo> listaMercadologo;
	
	private Mercadologo mercadologo;

	//Constructor
	@PostConstruct
	public void init() {
		this.listaMercadologo = new ArrayList<Mercadologo>();
		this.mercadologo = new Mercadologo();
		this.listMercadologo();
	}

	//Metodos personalizados
	public String newMercadologo() {
		this.setMercadologo(new Mercadologo());
		return "Mercadologo.xhtml";
	}
	
	public void insertMercadologo() {
		mService.insert(mercadologo);
		
	}
	
	public void listMercadologo() {
		listaMercadologo = mService.list();
		
	}

	//GET Y SET
	public List<Mercadologo> getListaMercadologo() {
		return listaMercadologo;
	}

	public void setListaMercadologo(List<Mercadologo> listaMercadologo) {
		this.listaMercadologo = listaMercadologo;
	}

	public Mercadologo getMercadologo() {
		return mercadologo;
	}

	public void setMercadologo(Mercadologo mercadologo) {
		this.mercadologo = mercadologo;
	}	
	
}
