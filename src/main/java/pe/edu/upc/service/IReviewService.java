package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Review;

public interface IReviewService {

	public void insertar(Review review);
	public void eliminar(int idReview);
	
	public List<Review> listar();
	
	public List<Review> findByNameReview(Review rev);
}
