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

	
	@RequestMapping(method = RequestMethod.GET, value = "createPost")
	public String createPost(Model model) {
		List<Category> category = new ArrayList<Category>();
		category = categoryService.getAllCategory();
		model.addAttribute("post", new Post());
		model.addAttribute("categories", category);
		
		return "createPost";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "savePost")
	public String savePost(HttpServletRequest request,@RequestParam("categoryName") String categoryName, Model model, Post post) throws Exception, IOException 
	{	
		String relativeFolder = "resources/images/" ;
		 System.out.println("relativeFolder"+relativeFolder);
		Photo photo = new Photo( "default-icon.png","C:\\Users\\PC\\Springtest\\springmvc\\WebContent\\resources\\images\\");
		 //Photo photo = new Photo( "default-icon.png",relativeFolder);
		
		 
		 categoryService.savePostToCategory(categoryName, post, photo);
		return "redirect:/viewPosts";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "viewPosts")
	public String showPosts(Model model) {

		List<Post> postsData = postService.getAllPosts();
		model.addAttribute("posts", postsData);
		return "showPosts";

	}

	@RequestMapping(method = RequestMethod.GET, value = { "editPost-{postID}" })
	public String editPost(@PathVariable int postID, Model model) {

		List<Category> category = new ArrayList<Category>();
		category = categoryService.getAllCategory();

		model.addAttribute("categories", category);

		Post post = postService.findById(postID);
		System.out.println(post.getId());
		System.out.println(post.getTitle());
		model.addAttribute("post", post);
		return "editPost";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "deletePost-{postID}" })
	public String deletePost(@PathVariable String postID) {

		postService.deletePost(postID);
		return "redirect:/viewPosts";
	}

	@RequestMapping(method = RequestMethod.POST, value = "updatePost")
	public String updatePost(HttpServletRequest request, @RequestParam CommonsMultipartFile[] photoUpload,
			@RequestParam("categoryName") String categoryName, @RequestParam("id") int id, Model model, Post post) throws Exception, IOException {

		
//		String webappRoot = servletContext.getRealPath("/");
//		String relativeFoldersave = "C:\\Users\\PC\\Springtest\\springmvc\\WebContent\\resources\\images\\";
		//String path = servletContext.getRealPath("/resources");
		//String relativeFoldersave = webappRoot + "resources/images/" ;
//		System.out.println("testpath"+servletContext.getContextPath());
//		System.out.println("relativeFoldersave "+relativeFoldersave);
		String saveDirectory = "C:\\Users\\PC\\Springtest\\springmvc\\WebContent\\resources\\images\\";
		//String saveDirectory = "resources/images/";
		String fileName = "";
		String fileLocation = "";	

		if (photoUpload != null && photoUpload.length > 0) {
			for (CommonsMultipartFile aFile : photoUpload) {

				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
					fileName = aFile.getOriginalFilename();
					fileLocation = saveDirectory;
				}
			}
		}
		
		Post persistentPost = postService.findById(id);
		Category persistentCategory = categoryService.getSpecificCategory(categoryName);
		persistentPost.setTitle(post.getTitle());
		persistentPost.setDescription(post.getDescription());
		persistentPost.setPrice(post.getPrice());
		persistentPost.setCategory(persistentCategory);
		if (photoUpload != null && photoUpload.length > 0) {
		Photo photo = new Photo(fileName, fileLocation);
		persistentPost.setPhoto(photo);
		}
		
		postService.updatePost(persistentPost);

		return "redirect:/viewPosts";
	}
	
	
	@RequestMapping(value = { "/view-{categoryID}" }, method = RequestMethod.GET)
	public String viewbyCategory(@PathVariable int categoryID, ModelMap model) {
		Category category = categoryService.getSpecificCategory(categoryID);
		model.addAttribute("category", "category\t"+ category.getName());
		List<Post> posts = category.getPosts(); // not good practice
		model.addAttribute("posts", posts);
		return "showPosts";
	}

}
