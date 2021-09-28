package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Review;

public interface IReviewDao {
	
	public void insertar(Review review);
	
	public List<Review> listar();
	
	public void eliminar(int idReview);
	
	public List<Review> findByNameReview(Review rev);
}
