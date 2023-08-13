package com.spo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spo.global.GlobalData;
import com.spo.model.Footwear;
import com.spo.service.FootwearService;

@Controller
public class CartController {
	@Autowired
	FootwearService footwearService;


		@GetMapping("/addToCart/{id}")
		public String addToCart(@PathVariable long id ) {
		
			GlobalData.cart.add(footwearService.getFootwearById(id).get());
			return "redirect:/shop";
		}
		
		@GetMapping("/cart")
		
		public String cartGet(Model model) {
			model.addAttribute("cartCount",GlobalData.cart.size());
			model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Footwear::getPrice).sum());
			model.addAttribute("cart", GlobalData.cart);
			return "cart";
		}
		
		@GetMapping("/cart/removeItem/{index}")
		public String cartItemRemove(@PathVariable int index) {
			GlobalData.cart.remove(index);
			return "redirect:/cart";
		}
		
		@GetMapping("/checkout")
		public String checkout(Model model) {
			model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Footwear::getPrice).sum());
			return "checkout";
		}
	//	@GetMapping("/payNow")
		//public String payNow(Model model) {
		//	model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Footwear::getPrice).sum());
			//return "payNow";
		//}
	}

