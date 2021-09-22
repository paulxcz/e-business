package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IProyectoDao;
import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.service.IProyectoService;

@Named
@RequestScoped
public class ProyectoServiceImpl implements IProyectoService{
	@Inject
	private IProyectoDao vDao;
	
	@Override
	public void insert(Proyecto vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}
	
	public void eliminar(int idEmprendedor) {
		vDao.eliminar(idEmprendedor);
	}
	@Override
	public List<Proyecto> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}


}
