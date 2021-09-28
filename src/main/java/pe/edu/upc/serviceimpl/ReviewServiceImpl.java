package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IReviewDao;
import pe.edu.upc.entities.Review;
import pe.edu.upc.service.IReviewService;

@Named
@RequestScoped
public class ReviewServiceImpl implements IReviewService {

	@Inject
	private IReviewDao rDao;
	
	@Override
	public void insertar(Review review) {
		rDao.insertar(review);
	}
	
	@Override
	public void eliminar(int idReview) {
		rDao.eliminar(idReview);
	}
	
	@Override
	public List<Review> listar(){
		return rDao.listar();
	}
	@Override
	public List<Review> findByNameReview(Review rev) {
		// TODO Auto-generated method stub
		return rDao.findByNameReview(rev);
	}
}
