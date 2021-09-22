package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoDao {
	public void insert(Mercadologo vc);
	public List<Mercadologo> list();
}
