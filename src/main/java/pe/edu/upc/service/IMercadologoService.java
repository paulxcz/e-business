package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoService {
	public void insert(Mercadologo vc);
	public void eliminar(int idMercadologo);
	public List<Mercadologo> list();
	public List<Mercadologo> findByNameMercadologo(Mercadologo mer);
	public void modificar(Mercadologo mercadologo);
}
