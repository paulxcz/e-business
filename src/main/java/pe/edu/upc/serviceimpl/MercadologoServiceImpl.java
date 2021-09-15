package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMercardologoDao;
import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.service.IMercadologoService;

@Named
@RequestScoped
public class MercadologoServiceImpl implements IMercadologoService{

	@Inject
	private IMercardologoDao mDao;
	
	@Override
	public void insert(Mercadologo m) {
		mDao.insert(m);
	}
	
	@Override
	public List<Mercadologo> list(){
		return mDao.list();
	}
	
	
}
