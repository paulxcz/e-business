package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.dao.IMercadologoDao;


public class MercadologoImpl implements IMercadologoDao {

	@PersistenceContext(unitName = "e-business")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Mercadologo m) {
		try {

			em.persist(m);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercadologo> list() {

		List<Mercadologo> lista = new ArrayList<Mercadologo>();
		try {

			Query q = em.createQuery("select m from Mercadologo m");
			lista = (List<Mercadologo>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}
	
}
