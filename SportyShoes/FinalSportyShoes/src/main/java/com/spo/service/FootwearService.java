package com.spo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spo.model.Footwear;
import com.spo.repository.FootwearRepository;

@Service
public class FootwearService  {
	@Autowired
	FootwearRepository footwearRepository;
	
	public List<Footwear> getAllFootwear(){
		return footwearRepository.findAll();
	}
	
	public void addFootwear(Footwear footwear) {
		footwearRepository.save(footwear);
	}
	
	public void removeFootwearById(Long id) {
		footwearRepository.deleteById(id);
	}
		
	public Optional<Footwear> getFootwearById(Long id){
		return footwearRepository.findById(id);
	}
		
	public List<Footwear>getAllFootwearByCategoryId(int id){
		
		return footwearRepository.findAllByCategory_Id(id);
		
	
	}
}

