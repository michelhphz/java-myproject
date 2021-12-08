package com.mysystem.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valuation")
public class Valuation implements Serializable {
	

	private static final long serialVersionUID = 5111487067832990239L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	private Double valuation;
	private Calendar date;
	private String comment;
	
	@ManyToOne	
	@JoinColumn(name = "user_id")
	private User user;	
	
	@ManyToOne	
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne	
	@JoinColumn(name = "media_id")
	private Media media;
	
	@ManyToOne	
	@JoinColumn(name = "project_id")
	private Project project;	
	
	@ManyToOne	
	@JoinColumn(name = "lodge_id")
	private Lodge lodge;	
	
	public Valuation() {
	}

	public Valuation(Long id, Double valuation, Calendar date, String comment) {
		this.id = id;
		this.valuation = valuation;
		this.date = date;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValuation() {
		return valuation;
	}

	public void setValuation(Double valuation) {
		this.valuation = valuation;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Item getItem() {
		return item;
	}

	public Media getMedia() {
		return media;
	}

	public Project getProject() {
		return project;
	}

	public User getUser() {
		return user;
	}		

	public Lodge getLodge() {
		return lodge;
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
		Valuation other = (Valuation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
