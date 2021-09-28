package pe.edu.upc.service;

import java.util.List;
import pe.edu.upc.entities.Emprendedor;


public interface IEmprendedorService {

	public void insert(Emprendedor vc);
	
	public void eliminar(int idEmprendedor);

	public List<Emprendedor> list();
	
	public List<Emprendedor> findByNameEmprendedor(Emprendedor emp);
}
