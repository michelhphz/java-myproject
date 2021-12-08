package com.mysystem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
	

	private static final long serialVersionUID = -3951111185381605246L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	private String method;
	private String noteKey;
	private String comments;
	
	@OneToOne
	@JoinColumn(name = "order_id")	
	private Order order;	
	
	@OneToOne
	@JoinColumn(name = "booking_id")	
	private Booking booking;

	public Payment() {
	}

	public Payment(Long id, String method, String noteKey, String comments) {
		this.id = id;
		this.method = method;
		this.noteKey = noteKey;
		this.comments = comments;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getNoteKey() {
		return noteKey;
	}


	public void setNoteKey(String noteKey) {
		this.noteKey = noteKey;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Order getOrder() {
		return order;
	}


	public Booking getBooking() {
		return booking;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
