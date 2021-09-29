package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IContratoDao;
import pe.edu.upc.entities.Contrato;
import pe.edu.upc.service.IContratoService;

@Named
@RequestScoped
public class ContratoServiceImpl implements IContratoService{

	@Inject
	private IContratoDao cDao;
	
	@Override
	public void insert(Contrato c) {
		cDao.insert(c);
	}
	
	@Override
	public List<Contrato> list(){
		return cDao.list();
	}
	@Override
	public List<Contrato> findByNameContrato(Contrato con) {
		// TODO Auto-generated method stub
		return cDao.findByNameContrato(con);
	}
}
