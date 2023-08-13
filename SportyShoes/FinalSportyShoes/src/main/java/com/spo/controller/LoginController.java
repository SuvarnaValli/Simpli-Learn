package com.spo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spo.global.GlobalData;
import com.spo.model.Role;
import com.spo.model.User;
import com.spo.repository.RoleRepository;
import com.spo.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder ;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	

	@GetMapping("/login")
	public String login() {
		
		GlobalData.cart.clear();
		return "login";
	}


	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user,HttpServletRequest request)throws ServletException{
		String password=user.getPassword();
		user.setPassword(bcryptPasswordEncoder.encode(password));
		List<Role>roles=new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
		
	}
	

}