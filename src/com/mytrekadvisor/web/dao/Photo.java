package com.mytrekadvisor.web.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the photo database table.
 * 
 */
@Entity
@Table(name="Photo")
public class Photo  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String location;

	private String name;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="photo", cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Post> posts;

	public Photo() {
	}
	

	public Photo(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	



	public Photo(int id, String name, String location) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setPhoto(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setPhoto(null);

		return post;
	}

}