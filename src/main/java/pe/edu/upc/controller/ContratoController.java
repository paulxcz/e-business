package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Contrato;
import pe.edu.upc.service.IContratoService;


@Named
@RequestScoped
public class ContratoController {

	@Inject
	//traer metodos
	private IContratoService cService;
	
	//atributos
	private Contrato contrato;
	List<Contrato> listaContrato;
	
	//constructor
	@PostConstruct
	public void init() {
		this.listaContrato = new ArrayList<Contrato>();
		this.contrato = new Contrato();
		this.listContrato();
	}
	
	
	//Metodos personalizados
	public String newContrato() {
		this.setContrato(new Contrato());
		return "Contrato.xhtml";
	}

	public void insertContrato() {
		try {
			cService.insert(contrato);
			this.listContrato();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void listContrato() {
		listaContrato = cService.list();
	}

	public Contrato getContrato() {
		return contrato;
	}


	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}


	public List<Contrato> getListaContrato() {
		return listaContrato;
	}


	public void setListaContrato(List<Contrato> listaContrato) {
		this.listaContrato = listaContrato;
	}
	public void clean() {
		this.init();
	}
	public void findByName() {
		try {
			if (contrato.getIdContrato()==0) {
				this.listContrato();
			} else {
				listaContrato = this.cService.findByNameContrato(this.getContrato());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
}
