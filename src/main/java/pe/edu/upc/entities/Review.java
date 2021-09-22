package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Review")

public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;
	
	@Column(name = "Date", length = 45, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DateReview;

	
	@Column(name = "Rating", nullable = false)
	private int RatingReview;
	

	//constructor sin parámetros
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
