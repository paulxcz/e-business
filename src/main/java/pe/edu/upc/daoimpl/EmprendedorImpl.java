package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEmprendedorDao;
import pe.edu.upc.entities.Emprendedor;


public class EmprendedorImpl implements IEmprendedorDao {
	@PersistenceContext(unitName = "e-business")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Emprendedor vc) {
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
	public List<Emprendedor> list() {
		// TODO Auto-generated method stub
		List<Emprendedor> lista = new ArrayList<Emprendedor>();

		try {

			Query q = em.createQuery("select v from Emprendedor v");
			lista = (List<Emprendedor>) q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}

		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idEmprendedor) {
		Emprendedor med = new Emprendedor();
		try {
			med = em.getReference(Emprendedor.class, idEmprendedor);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emprendedor> findByNameEmprendedor(Emprendedor emp) {
		List<Emprendedor> lista = new ArrayList<Emprendedor>();
		try {
			Query q = em.createQuery("from Emprendedor v where v.nombreEmprendedor like ?1");
			q.setParameter(1, "%" + emp.getNombreEmprendedor() + "%");
			lista = (List<Emprendedor>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
    @Override
    public void modificar(Emprendedor emprendedor) {
        try {
            em.merge(emprendedor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
