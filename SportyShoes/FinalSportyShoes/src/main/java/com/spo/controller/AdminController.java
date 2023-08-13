package com.spo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spo.model.Category;
import com.spo.service.CategoryService;
import com.spo.dto.FootwearDTO;
import com.spo.model.Footwear;
import com.spo.service.FootwearService;


@Controller
public class AdminController {

	public static String uploadDir= System.getProperty("user.dir")+"/src/main/resources/static/footwearImages";
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FootwearService footwearService;
	
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {

		Optional<Category> category= categoryService.getCategoryById(id);
		if(category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
			}
		else return "404";
		}

	//FootwearSection


	@GetMapping("/admin/footwear")
	public String footwears(Model  model) {
		model.addAttribute("footwears",footwearService.getAllFootwear());
		return "footwear";
	}
		@GetMapping("/admin/footwear/add")
		public String FootwearAddGet(Model  model) {
			model.addAttribute("footwearDTO",new FootwearDTO());
			model.addAttribute("categories",categoryService.getAllCategory());
			return "footwearAdd";
	}


		@PostMapping("/admin/footwear/add")
		public String footwearAddPost(@ModelAttribute("footwearDTO")FootwearDTO footwearDTO,
										@RequestParam("footwearImage")MultipartFile file,
										@RequestParam("imgName")String imgName)throws IOException
		{
			
			Footwear footwear =new Footwear();
			footwear.setId(footwearDTO.getId());
			footwear.setName(footwearDTO.getName());
			footwear.setCategory((Category)categoryService.getCategoryById(footwearDTO.getCategoryId()).get());
			footwear.setPrice(footwearDTO.getPrice());
			footwear.setSize(footwearDTO.getSize());
			footwear.setDescription(footwearDTO.getDescription());
			String imageUUID;
			
			if(!file.isEmpty()) {
				imageUUID =file.getOriginalFilename();
				Path fileNameAndPath= Paths.get(uploadDir, imageUUID);
						
				Files.write(fileNameAndPath,file.getBytes());
				}
			
			else {
				imageUUID= imgName;
			}
			footwear.setImageName(imageUUID);
			footwearService.addFootwear(footwear);
			
		return"redirect:/admin/footwear";	
		}
		
		@GetMapping("/admin/footwear/delete/{id}")
		public String deleteFootwear(@PathVariable long id) {
			footwearService.removeFootwearById(id);
			return "redirect:/admin/footwear";
		}
		
		@GetMapping("/admin/footwear/update/{id}")
		public String updateProductGet(@PathVariable long id, Model model)
		{
			
		   Footwear footwear= footwearService.getFootwearById(id).get();
		   FootwearDTO footwearDTO = new FootwearDTO();
		   footwearDTO.setId(footwear.getId());
		   footwearDTO.setName(footwear.getName());
		   footwearDTO.setCategoryId((footwear.getCategory().getId()));
		   footwearDTO.setPrice(footwear.getPrice());
		   footwearDTO.setSize(footwear.getSize());
		   footwearDTO.setDescription(footwear.getDescription());
		   footwearDTO.setImageName(footwear.getImageName());
		   model.addAttribute("categories",categoryService.getAllCategory());
		   model.addAttribute("footwearDTO",footwearDTO);
		   
			return "footwearAdd";
			
		}
	}
