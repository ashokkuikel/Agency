package com.mytrekadvisor.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, value = { "editCategory-{categoryID}" })
	public String editCategory(@PathVariable int categoryID, Model model) {

		Category categories = categoryService.findById(categoryID);
		model.addAttribute("categories", categories);
		return "editCategory";
	}

	@RequestMapping(method = RequestMethod.GET, value = "createCategory")
	public String createCategory() {
		return "createCategory";
	}

	@RequestMapping(method = RequestMethod.POST, value = "saveCategory")
	public String saveCategory(Category category) {
		categoryService.saveCategory(category);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "deleteCategory-{categoryID}" })
	public String deleteCategory(@PathVariable String categoryID, Model model) {
		categoryService.deleteCategory(categoryID);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST, value = "updateCategory")
	public String updateCategory(Category category) {
		categoryService.updateCategory(category);
		return "redirect:/";
	}

	
}
