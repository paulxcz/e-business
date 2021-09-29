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
	public void insert(Soporte sp) {
		// TODO Auto-generated method stub
		try {

			em.persist(sp);

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

			Query q = em.createQuery("select s from Soporte s");
			lista = (List<Soporte>) q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}

		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idSoporte) {
		Soporte med = new Soporte();
		try {
			med = em.getReference(Soporte.class, idSoporte);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Soporte> findByNameSoporte(Soporte sop) {
		List<Soporte> lista = new ArrayList<Soporte>();
		try {
			Query q = em.createQuery("from Soporte s where s.nombreSoporte like ?1");
			q.setParameter(1, "%" + sop.getNombreSoporte() + "%");
			lista = (List<Soporte>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
    @Override
    public void modificar(Soporte soporte) {
        try {
            em.merge(soporte);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}