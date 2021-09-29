package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMercadologoDao;
import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.service.IMercadologoService;

@Named
@RequestScoped
public class MercadologoServiceImpl implements IMercadologoService{
	@Inject
	private IMercadologoDao vDao;
	
	@Override
	public void insert(Mercadologo vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}
	public void eliminar(int idMercadologo) {
		vDao.eliminar(idMercadologo);
	}
	@Override
	public List<Mercadologo> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}
	
	@Override
	public List<Mercadologo> findByNameMercadologo(Mercadologo mer) {
		// TODO Auto-generated method stub
		return vDao.finByNameMercadologo(mer);
	}
	@Override
    public void modificar(Mercadologo mercadologo) {
        vDao.modificar(mercadologo);
    }
}
