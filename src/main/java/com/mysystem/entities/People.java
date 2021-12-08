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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class People implements Serializable {
	
	private static final long serialVersionUID = 3731823309134471220L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String name;
	private Calendar birth;
	private String phone;
	
    @OneToOne(mappedBy = "userPeople")
    private User user;	
	
    @OneToMany(mappedBy = "hostPeople")
    private List<Lodge> hostLodges;	
    
    @OneToMany(mappedBy = "guestPeoples")
    private List<Booking> guestBookings;	    
    
    @OneToMany(mappedBy = "orderPeople")
    private List<Order> orders;	
    
	@OneToMany
	@JoinColumn(name = "post_id")	
	private List<Post> posts;
	
	@OneToMany
	@JoinColumn(name = "comment_id")	
	private List<Comment> comments;	
    
	@ManyToMany
	@JoinTable(name = "adress_people",
			   joinColumns = @JoinColumn(name = "people_id"),
			   inverseJoinColumns = @JoinColumn(name = "adress_id"))
	private List<Adress> adress;    
	
	public People() {}

	public People(Long id, String email, String name, Calendar birth, String phone) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirth() {
		return birth;
	}

	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public List<Adress> getAdress() {
		return adress;
	}

	public List<Lodge> getHostLodges() {
		return hostLodges;
	}

	public List<Booking> getGuestLodges() {
		return guestBookings;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		People other = (People) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
	
}
