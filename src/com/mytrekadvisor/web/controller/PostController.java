package com.mytrekadvisor.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.dao.CategoryDAO;
import com.mytrekadvisor.web.dao.Photo;
import com.mytrekadvisor.web.dao.Post;
import com.mytrekadvisor.web.service.CategoryService;
import com.mytrekadvisor.web.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private ServletContext servletContext;

	
	@RequestMapping(method = RequestMethod.GET, value = "viewPosts")
	public String showPosts(Model model) {

		List<Post> postsData = postService.getAllPosts();
		model.addAttribute("posts", postsData);
		return "showPosts";

	}



	@RequestMapping(method = RequestMethod.GET, value = { "/{categoryName}/{postID}" })
	public String viewPost(@PathVariable int postID,@PathVariable String categoryName, Model model) {
		Post post = postService.findById(postID);
		/*List<Post> posts = postService.getSimilarPost(categoryName);
		System.out.println(posts);*/
		System.out.println(post.getId());
		System.out.println(post.getTitle());
		model.addAttribute("post", post);
		model.addAttribute("categoryName", categoryName);
		return "viewPost";
	}
	
	
	/*@RequestMapping(method = RequestMethod.GET, value = { "/{categoryName}" })
	public String categoryPost(@PathVariable String categoryName, Model model) {
		List<Post> posts = postService.getSimilarPost(categoryName);
		System.out.println(posts);
		return "viewPost";
	}*/
	
	@RequestMapping(value = { "/view-{categoryID}" }, method = RequestMethod.GET)
	public String viewbyCategory(@PathVariable int categoryID, ModelMap model) {
		Category category = categoryService.getSpecificCategory(categoryID);
		model.addAttribute("category", "category\t"+ category.getName());
		List<Post> posts = category.getPosts(); // not good practice
		model.addAttribute("posts", posts);
		return "showPosts";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "/{categoryName}" })
	public String getIdbyname(@PathVariable String categoryName, Model model) {
		Category category = postService.getIdbyname(categoryName);
		System.out.println(category);
		return "category";
	}
}
