package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IReviewDao;
import pe.edu.upc.entities.Review;

public class ReviewImpl implements IReviewDao {

	@PersistenceContext(unitName = "e-business")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Review review) {
		try {
			em.persist(review);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> listar() {
		List<Review> lista = new ArrayList<Review>();
		try {
			Query q = em.createQuery("from Review r");
			lista = (List<Review>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idReview) {
		Review rev = new Review();
		try {
			rev = em.getReference(Review.class, idReview);
			em.remove(rev);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> findByNameReview(Review rev) {
		List<Review> lista = new ArrayList<Review>();
		try {
			Query q = em.createQuery("from Review r where r.idReview = ?1");
			q.setParameter(1, (int)rev.getIdReview());
			lista = (List<Review>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
