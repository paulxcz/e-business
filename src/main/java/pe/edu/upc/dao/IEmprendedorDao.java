package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Emprendedor;

public interface IEmprendedorDao {

	public void insert(Emprendedor vc);
	
	public void eliminar(int idEmprendedor);

	public List<Emprendedor> list();
}
