package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Contrato;

public interface IContratoService {
	public void insert(Contrato c);
	public List<Contrato> list();
	public List<Contrato> findByNameContrato(Contrato con);
	
}
