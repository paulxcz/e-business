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
	public void insert(Soporte sp) {
		// TODO Auto-generated method stub
		vDao.insert(sp);

	}
	
	@Override
	public void eliminar(int idSoporte) {
		vDao.eliminar(idSoporte);
	}
	
	
	@Override
	public List<Soporte> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}
	
	@Override
	public List<Soporte> findByNameSoporte(Soporte sop) {
		// TODO Auto-generated method stub
		return vDao.findByNameSoporte(sop);
	}
	
	@Override
    public void modificar(Soporte soporte) {
        vDao.modificar(soporte);
    } 
}