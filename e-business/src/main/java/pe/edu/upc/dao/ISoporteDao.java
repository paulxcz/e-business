package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Soporte;


public interface ISoporteDao {

	public void insert(Soporte vc);

	public List<Soporte> list();
	
}
