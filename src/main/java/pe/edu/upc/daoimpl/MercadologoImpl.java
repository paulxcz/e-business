package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMercadologoDao;
import pe.edu.upc.entities.Mercadologo;


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
	
	@Transactional
	@Override
	public void eliminar(int idMercadologo) {
		Mercadologo m = new Mercadologo();
		try {
			m = em.getReference(Mercadologo.class, idMercadologo);
			em.remove(m);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercadologo> finByNameMercadologo(Mercadologo mer) {
		List<Mercadologo> lista = new ArrayList<Mercadologo>();
		try {
			Query q = em.createQuery("from Mercadologo m where m.nombreMercadologo like ?1");
			q.setParameter(1, "%" + mer.getNombreMercadologo() + "%");
			lista = (List<Mercadologo>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
