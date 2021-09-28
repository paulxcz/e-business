package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoDao {
	
	public void insert(Mercadologo vc);
	
	public List<Mercadologo> list();
	
	public void eliminar(int idMercadologo);
	/*public void eliminar(int );*/
	public List<Mercadologo> finByNameMercadologo(Mercadologo mer);
	
	public void modificar(Mercadologo mercadologo);
}
