package com.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Buyer> buyers;
	public Seller(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return firstName;
	}
	public void setName(String name) {
		this.firstName = name;
	}
	public Set<Buyer> getBuyers() {
		return buyers;
	}
	public void setBuyers(Set<Buyer> buyers) {
		this.buyers = buyers;
	}

}
