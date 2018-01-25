package com.mytrekadvisor.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.dao.Subscriber;
/*import com.mytrekadvisor.web.dao.subscriber;*/
import com.mytrekadvisor.web.service.CategoryService;
import com.mytrekadvisor.web.service.SubscriberService;



@Controller
@RequestMapping("/subscribe")
@SessionAttributes("subscriber")
public class SubscriberController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubscriberService subscriberService;

	
	@RequestMapping(method = RequestMethod.GET, value = "viewSubscribers")
	public String showPosts(Model model) {

		List<Subscriber> subscribersData = subscriberService.getAllSubscriber();
		model.addAttribute("subscribers", subscribersData);
		return "showSubscribers";

	}
	
	@RequestMapping("/addsubscriber")
	public String add(Model model) {
		List<Category> category = new ArrayList<Category>();
		category = categoryService.getAllCategory();
		model.addAttribute("categories", category);
		return "subscriber_add";
	}
	
	@ModelAttribute("subscriber")
	public Subscriber getResource(){
		System.out.println("Adding a new subscriber to the model");
		return new Subscriber();
	}

	@RequestMapping("/reviewsubscriber")
	public String review(@ModelAttribute Subscriber subscriber){
		System.out.println("Invoking review()");
		return "subscriber_review";
	}
	
	@RequestMapping("/savesubscriber")
	public String saveCategory(@ModelAttribute Subscriber subscriber) {
		subscriberService.saveSubscriber(subscriber);
		return "redirect:/subscribe/viewSubscribers";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "editSubscriber-{subscriberID}" })
	public String editPost(@PathVariable int subscriberID, Model model) {

		List<Category> category = new ArrayList<Category>();
		category = categoryService.getAllCategory();

		model.addAttribute("categories", category);

		Subscriber subscriber = subscriberService.findById(subscriberID);
		System.out.println(subscriber.getId());
		System.out.println(subscriber.getFullname());
		model.addAttribute("subscriber", subscriber);
		return "editSubscriber";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "deleteSubscriber-{subscriberID}" })
	public String deletePost(@PathVariable String subscriberID) {
		subscriberService.deleteSubscriber(subscriberID);
		return "redirect:/subscribe/viewSubscribers";
	}

	@RequestMapping(method = RequestMethod.POST, value = "updateSubscriber")
	public String updateCategory(Subscriber subscriber) {
		subscriberService.updateSubscriber(subscriber);
		return "redirect:/subscribe/viewSubscribers";
	}
}
