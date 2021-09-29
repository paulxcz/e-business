package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoService {
	public void insert(Proyecto p);
	public List<Proyecto> list();
	public void modificar(Proyecto proyecto);
	public void eliminar(int idProyecto);
	public List<Proyecto> findByNameProyecto(Proyecto pro);
}
