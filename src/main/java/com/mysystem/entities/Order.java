package com.mysystem.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1674566466827409713L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar issue;
	private Calendar paid;
	private Calendar shipping;
	private Calendar delivered;
	private String status;
	private String adress;
	private Double discount;
	private Double addition;
	
	@ManyToMany
	@JoinTable(name = "order_item",
			   joinColumns = @JoinColumn(name = "order_id"),
			   inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> orderItems;
	
	@ManyToOne
	@JoinColumn(name = "people_id")
	private People orderPeople;		
	
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;	

	public Order() {
	}

	public Order(Long id, Calendar issue, Calendar paid, Calendar shipping, Calendar delivered, String status,
			String adress, Double discount, Double addition) {
		this.id = id;
		this.issue = issue;
		this.paid = paid;
		this.shipping = shipping;
		this.delivered = delivered;
		this.status = status;
		this.adress = adress;
		this.discount = discount;
		this.addition = addition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getIssue() {
		return issue;
	}

	public void setIssue(Calendar issue) {
		this.issue = issue;
	}

	public Calendar getPaid() {
		return paid;
	}

	public void setPaid(Calendar paid) {
		this.paid = paid;
	}

	public Calendar getShipping() {
		return shipping;
	}

	public void setShipping(Calendar shipping) {
		this.shipping = shipping;
	}

	public Calendar getDelivered() {
		return delivered;
	}

	public void setDelivered(Calendar delivered) {
		this.delivered = delivered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public List<Item> getItems() {
		return orderItems;
	}

	public People getOrderPeople() {
		return orderPeople;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
	
}
