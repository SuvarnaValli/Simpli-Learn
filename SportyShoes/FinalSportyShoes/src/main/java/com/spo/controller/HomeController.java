package com.spo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spo.global.GlobalData;
import com.spo.service.CategoryService;
import com.spo.service.FootwearService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	FootwearService footwearService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("footwear",footwearService.getAllFootwear());
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "shop";
	}
	
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model,@PathVariable int id) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("footwear",footwearService.getAllFootwearByCategoryId(id));
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "shop";
	}
	@GetMapping("/shop/viewfootwear/{id}")
	public String viewFootwear(Model model,@PathVariable long id) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("footwear",footwearService.getFootwearById(id).get());
		return "viewFootwear";
	}
	
	
	
	
}

