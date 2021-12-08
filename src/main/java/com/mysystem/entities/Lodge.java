package com.mysystem.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lodge")
public class Lodge implements Serializable {
	
	private static final long serialVersionUID = 5155941273226937030L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	private String description;
	private Double price;
			
	@ManyToOne
	@JoinColumn(name = "people_id")
	private People hostPeople;	
	
	@OneToOne
	@JoinColumn(name = "adress_id")
	private Adress adress;		
	
	@OneToMany
	@JoinColumn(name = "valuation_id")
	private List<Valuation> valuations;
	
	@OneToMany
	@JoinColumn(name = "booking_id")
	private List<Booking> bookings;	
	
	public Lodge() {
		
	}

	public Lodge(Long id, String description, Double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public People getHostPeople() {
		return hostPeople;
	}

	public Adress getAdress() {
		return adress;
	}

	public List<Valuation> getValuations() {
		return valuations;
	}

	public List<Booking> getBookings() {
		return bookings;
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
		Lodge other = (Lodge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
