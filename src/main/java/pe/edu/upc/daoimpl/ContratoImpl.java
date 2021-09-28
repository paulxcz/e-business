package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IContratoDao;
import pe.edu.upc.entities.Contrato;

public class ContratoImpl implements IContratoDao {
	
	@PersistenceContext(unitName = "e-business")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Contrato c) {
		try {
			em.persist(c);
		} catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> list() {
		
		List<Contrato>  lista = new ArrayList<Contrato>();
		try {
			Query q = em.createQuery("select c from Contrato c");
			lista = (List<Contrato>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> findByNameContrato(Contrato con) {
		List<Contrato> lista = new ArrayList<Contrato>();
		try {
			Query q = em.createQuery("from Contrato c where c.idContrato like ?1");
			q.setParameter(1, con.getIdContrato());
			lista = (List<Contrato>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
