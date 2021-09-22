package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.service.IMercadologoService;

@Named
@RequestScoped
public class MercadologoController {

	//traer metodos
	private IMercadologoService mService;
	
	
	//atributos
	private Mercadologo mercadologo;
	List<Mercadologo> listaMercadologo;
	
	//Constructor

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
		try {
			mService.insert(mercadologo);
			this.listMercadologo();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
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
