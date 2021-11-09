package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	public ClothForm setUpClothForm() {
		return new ClothForm();
	}

	@Autowired
	ClothService service;
	
	@RequestMapping("")
	public String index() {
		return "clothes";
	}
	
	@RequestMapping("/find")
	public String find(ClothForm form,Model model) {
		
		List<Cloth>list = service.find(form);
		
		model.addAttribute("resultList", list);
		
		return index();
	}
}
