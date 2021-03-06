package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEmprendedorDao;
import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.service.IEmprendedorService;

@Named
@RequestScoped
public class EmprendedorServiceImpl implements IEmprendedorService{
	@Inject
	private IEmprendedorDao vDao;
	
	@Override
	public void insert(Emprendedor vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}
	
	
	@Override
	public void eliminar(int idEmprendedor) {
		vDao.eliminar(idEmprendedor);
	}
	
	@Override
	public List<Emprendedor> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}
	
	@Override
	public List<Emprendedor> findByNameEmprendedor(Emprendedor emp) {
		// TODO Auto-generated method stub
		return vDao.findByNameEmprendedor(emp);
	}
	
	@Override
    public void modificar(Emprendedor emprendedor) {
        vDao.modificar(emprendedor);
    }

}
