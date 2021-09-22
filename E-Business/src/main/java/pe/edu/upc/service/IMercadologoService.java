package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoService {
	public void insert(Mercadologo vc);

	public List<Mercadologo> list();
}
