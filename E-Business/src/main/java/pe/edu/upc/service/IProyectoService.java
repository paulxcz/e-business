package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoService {
	public void insert(Proyecto vc);
	
	public void eliminar(int idEProyecto);

	public List<Proyecto> list();
}
