package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoDao {
public void insert(Proyecto p);
public List<Proyecto>list();
public List<Proyecto> findByNameProyecto(Proyecto pro);
}
