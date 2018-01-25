package com.mytrekadvisor.web.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the post database table.
 * 
 */
@Entity
@Table(name="Post")
public class Post  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(length=1000)
	private String title;
	
	@Column(length=2000)
	private String description;
	
	private String price;

	//bi-directional many-to-one association to Photo
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private Photo photo;

	//bi-directional many-to-one association to Studentclass
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	public Post() {
	}
	

	public Post(String title, String description, String price) {
		this.title = title;
		this.description = description;
		this.price = price;
	}


	public Post(int id, String title, String description, String price, Photo photo, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.photo = photo;
		this.category = category;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}