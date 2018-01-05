package com.mytrekadvisor.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.dao.CategoryDAO;
import com.mytrekadvisor.web.dao.Photo;
import com.mytrekadvisor.web.dao.Post;
import com.mytrekadvisor.web.dao.PostDAO;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private PostDAO postDao;

	public List<Category> getAllCategory() {

		return categoryDao.getAllCategory();
	}

	public Category findById(int classID) {

		return categoryDao.findById(classID);
	}

	/*public void saveCategory(Category category) {
		categoryDao.createCategory(category);
	}

	public void deleteCategory(String classID) {
		categoryDao.deleteCategory(classID);
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}*/

	public Category getSpecificCategory(String categoryName) {
		return categoryDao.getSpecificCategory(categoryName);
	}
	
	public Category getSpecificCategory(int categoryID) {
		return categoryDao.findById(categoryID);
	}

	/*public void savePostsToCategory(String categoryName, List<Post> posts, Photo photo) {
		Category category = categoryDao.getSpecificCategory(categoryName);;
		for(Post post : posts) {
			post.setCategory(category);
			post.setPhoto(photo);
			postDao.create(post);
			
		}
		
	}
	
	public void savePostToCategory(String categoryName, Post post, Photo photo) {
		Category category = categoryDao.getSpecificCategory(categoryName);;
			post.setCategory(category);
			post.setPhoto(photo);
			postDao.create(post);
			
		}
		*/
}
