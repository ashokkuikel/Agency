package com.mytrekadvisor.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.dao.CategoryDAO;
import com.mytrekadvisor.web.dao.Post;
import com.mytrekadvisor.web.dao.PostDAO;

@Service
public class PostService {

	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	public List<Post> getAllPosts() {

		return postDao.getAllPosts();
	}
	
	public Post findById(int postID) {
		return postDao.findById(postID);
	}
	
	public List<Post> getSimilarPost(String categoryName) {
		return postDao.getSimilarPost(categoryName);
	}
	
	/*public void deletePost(String postID) {
		postDao.deletePost(postID);
	}
	
	public void updatePost(Post post) {
		postDao.updatePost(post);
	}*/

	
	public Category getSpecificCategory(String categoryName) {
		return categoryDao.getSpecificCategory(categoryName);
	}
	
	public Category getIdbyname(String categoryName) {
		return postDao.getIdbyname(categoryName);
	}

	
	
	
	
}
