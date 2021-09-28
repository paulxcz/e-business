package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Contrato;

public interface IContratoDao {
	public void insert(Contrato c);
	
	public List<Contrato> list();
	
	public List<Contrato> findByNameContrato(Contrato con);
}
