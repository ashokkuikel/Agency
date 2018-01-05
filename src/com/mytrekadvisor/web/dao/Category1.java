package com.mytrekadvisor.web.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studentclass database table.
 * 
 */
@Entity
@Table(name="Category")
public class Category1  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	private List<Post> posts;

	
	public Category1() {
		super();
	}


	public Category1(int id, String name, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.posts = posts;
	}


	public Category1(String name, List<Post> posts) {
		this.name = name;
		this.posts = posts;
	}
	
	
	public Category1(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

//	public Post addPost(Post post) {
//		getPosts().add(post);
//		post.setCategory(this);
//
//		return post;
//	}
//
//	public Post removePost(Post post) {
//		getPosts().remove(post);
//		post.setCategory(null);
//
//		return post;
//	}

}