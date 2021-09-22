package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

import pe.edu.upc.dao.IMercadologoDao;
import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.service.IMercadologoService;

@Named
@RequestScoped
public class MercadologoServiceImpl implements IMercadologoService{

	private IMercadologoDao vDao;
	
	@Override
	public void insert(Mercadologo vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}
	
	@Override
	public List<Mercadologo> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

}
