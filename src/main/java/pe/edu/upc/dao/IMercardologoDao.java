package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;


public interface IMercardologoDao {

	public void insert(Mercadologo m);
	
	List<Mercadologo> list();
}
