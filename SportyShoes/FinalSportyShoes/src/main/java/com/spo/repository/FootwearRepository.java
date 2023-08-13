package com.spo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spo.model.Footwear;

public interface FootwearRepository extends JpaRepository<Footwear, Long> {

	List<Footwear> findAllByCategory_Id(int id);
}
