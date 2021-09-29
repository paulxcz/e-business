package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Soporte;

public interface ISoporteDao {

    public void insert(Soporte sp);

    public List<Soporte> list();
    
	public void modificar(Soporte soporte);

    public void eliminar(int idSoporte);

    public List<Soporte> findByNameSoporte(Soporte sop);

}