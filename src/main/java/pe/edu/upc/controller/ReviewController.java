package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Review;
import pe.edu.upc.service.IReviewService;

@Named
@RequestScoped
public class ReviewController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IReviewService rService;
	private Review review;
	List<Review> listaReviews;
	
	@PostConstruct
	public void init() {
		this.listaReviews = new ArrayList<Review>();
		this.review = new Review();
		this.listar();
	}
	
	//metodos
	
	public String nuevoReview() {
		this.setReview(new Review());
		return "Review.xhtml";
	}
	
	public void insertar() {
		try {
			rService.insertar(review);
			this.listar();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void eliminar(Review review) {
		try {
			rService.eliminar(review.getIdReview());
			listar();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void listar() {
		try {
			listaReviews = rService.listar();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void clean() {
		this.init();
	}
	public void findByName() {
		try {
			if (review.getIdReview()==0) {
				this.listar();
			} else {
				listaReviews = this.rService.findByNameReview(this.getReview());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//get y set

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public List<Review> getListaReviews() {
		return listaReviews;
	}

	public void setListaReviews(List<Review> listaReviews) {
		this.listaReviews = listaReviews;
	}
	
}
