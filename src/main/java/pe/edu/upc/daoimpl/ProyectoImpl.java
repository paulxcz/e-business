package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProyectoDao;
import pe.edu.upc.entities.Proyecto;

public class ProyectoImpl implements IProyectoDao{
	@PersistenceContext(unitName="e-business")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Proyecto p) {
		try {
			em.persist(p);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> list(){
		List<Proyecto> lista = new ArrayList<Proyecto>();
		try {
		
			Query q = em.createQuery("select p from Proyecto p");
			lista = (List<Proyecto>) q.getResultList();		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listarr");
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> findByNameProyecto(Proyecto pro) {
		List<Proyecto> lista = new ArrayList<Proyecto>();
		try {
			Query q = em.createQuery("from Proyecto p where p.nombre like ?1");
			q.setParameter(1, "%" + pro.getNombre() + "%");
			lista = (List<Proyecto>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idProyecto) {
		Proyecto med = new Proyecto();
		try {
			med = em.getReference(Proyecto.class, idProyecto);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Transactional
    @Override
    public void modificar(Proyecto proyecto) {
        try {
            em.merge(proyecto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
