package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Emprendedor;


public interface IEmprendedorDao {

	public void insert(Emprendedor vc);

	public List<Emprendedor> list();
	
	public void eliminar(int idEmprendedor);
	
	public void modificar(Emprendedor emprendedor);
	
	public List<Emprendedor> findByNameEmprendedor(Emprendedor emp);
}
