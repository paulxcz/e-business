package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Emprendedor;

public interface IEmprendedorService {

	public void insert(Emprendedor vc);

	public List<Emprendedor> list();
}
