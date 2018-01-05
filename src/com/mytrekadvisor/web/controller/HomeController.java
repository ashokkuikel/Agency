package com.mytrekadvisor.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Category> categories = new ArrayList<Category>();
		categories = categoryService.getAllCategory();
		model.addAttribute("categories",categories);
		
		return "home";
	}
	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleAllException(Exception ex) {
//
//		ModelAndView model = new ModelAndView("error");
//		model.addObject("exception", ex);
//		return model;
//
//	}

}
