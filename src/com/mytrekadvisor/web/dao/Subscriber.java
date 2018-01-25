package com.mytrekadvisor.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscriber")
public class Subscriber  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String fullname;
	
	private String email;
	
	private String contact;

	private String categories;

	public Subscriber() {
	}
	
	
	public Subscriber(String fullname, String email, String contact, String categories) {
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.categories = categories;
	}
	
	public Subscriber(int id, String fullname, String email, String contact, String categories) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.categories = categories;
	}


	public int getId() {
		return this.id;
	}

	public String getFullname() {
		return this.fullname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getContact() {
		return this.contact;
	}

	public String getCategories() {
		return this.categories;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public void setCategories(String categories) {
		this.categories = categories;
	}


	@Override
	public String toString() {
		return "Subscriber1 [id=" + id + ", fullname=" + fullname + ", email=" + email + ", contact=" + contact
				+ ", categories=" + categories + "]";
	}

}