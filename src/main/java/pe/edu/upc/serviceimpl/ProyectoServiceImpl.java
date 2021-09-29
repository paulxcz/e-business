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
	private IProyectoDao pDao;
	
	@Override
	public void insert(Proyecto p) {
		pDao.insert(p);
	}
	
	@Override
	public void eliminar(int idProyecto) {
		pDao.eliminar(idProyecto);
	}
	
	@Override
	public List<Proyecto> list(){
		return pDao.list();
	}
	@Override
	public List<Proyecto> findByNameProyecto(Proyecto pro) {
		// TODO Auto-generated method stub
		return pDao.findByNameProyecto(pro);
	}
	@Override
    public void modificar(Proyecto proyecto) {
        pDao.modificar(proyecto);
    } 
}
