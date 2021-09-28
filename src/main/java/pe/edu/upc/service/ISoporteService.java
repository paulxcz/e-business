package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Soporte;


public interface ISoporteService {

	public void insert(Soporte sp);
	
	public void eliminar(int idSoporte);

	public List<Soporte> list();
	
	public List<Soporte> findByNameSoporte(Soporte sop);
	
	public void modificar(Soporte soporte);
	
}