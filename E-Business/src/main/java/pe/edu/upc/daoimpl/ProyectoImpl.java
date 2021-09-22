package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProyectoDao;
import pe.edu.upc.entities.Proyecto;

public class ProyectoImpl implements IProyectoDao {
	@PersistenceContext(unitName = "e-business")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Proyecto vc) {
		// TODO Auto-generated method stub
		try {
			
			em.persist(vc);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> list() {
		// TODO Auto-generated method stub
		List<Proyecto> lista = new ArrayList<Proyecto>();
		
		try {
			
			Query q = em.createQuery("select v from Proyecto v");
			lista = (List<Proyecto>) q.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
