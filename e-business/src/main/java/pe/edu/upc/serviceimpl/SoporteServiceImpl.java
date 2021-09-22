package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISoporteDao;
import pe.edu.upc.entities.Soporte;
import pe.edu.upc.service.ISoporteService;

@Named
@RequestScoped
public class SoporteServiceImpl implements ISoporteService{
	@Inject
	private ISoporteDao vDao;
	
	@Override
	public void insert(Soporte vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}
	
	
	@Override
	public List<Soporte> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

}
