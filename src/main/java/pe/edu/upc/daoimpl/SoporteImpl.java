package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISoporteDao;
import pe.edu.upc.entities.Soporte;


public class SoporteImpl implements ISoporteDao {
	@PersistenceContext(unitName = "e-business")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Soporte vc) {
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
	public List<Soporte> list() {
		// TODO Auto-generated method stub
		List<Soporte> lista = new ArrayList<Soporte>();

		try {

			Query q = em.createQuery("select v from Emprendedor v");
			lista = (List<Soporte>) q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}

		return lista;
	}
}