package com.mysystem.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
	
	private static final long serialVersionUID = -4396676060403159326L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	private Calendar checkin;
	private Calendar checkout;
	private Double discount;
	private Double addition;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "lodge_id")	
	private Lodge lodge;
		
	@ManyToOne
	@JoinColumn(name = "people_id")	
	private People guestPeoples;
	
    @OneToOne
    @JoinColumn(name = "payment_id")	
    private Payment payment;	

	public Booking() {
	}

	public Booking(Long id, Calendar checkin, Calendar checkout, Double discount, Double addition, String status) {
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.discount = discount;
		this.addition = addition;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCheckin() {
		return checkin;
	}

	public void setCheckin(Calendar checkin) {
		this.checkin = checkin;
	}

	public Calendar getCheckout() {
		return checkout;
	}

	public void setCheckout(Calendar checkout) {
		this.checkout = checkout;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getAddition() {
		return addition;
	}

	public void setAddition(Double addition) {
		this.addition = addition;
	}		

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Lodge getLodge() {
		return lodge;
	}

	public People getGuestPeoples() {
		return guestPeoples;
	}		

	public Payment getPayment() {
		return payment;
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
		Booking other = (Booking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
			
}
