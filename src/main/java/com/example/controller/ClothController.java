package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	public String index(Model model) {
		
Map<Integer,String>genderList = new LinkedHashMap<>();
		
		genderList.put(0, "男性");
		genderList.put(1, "女性");
		
		model.addAttribute("genderList", genderList);
		
		List<String>colorList = new ArrayList<>();
		
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");
		
		model.addAttribute("colorList", colorList);
		
		return "clothes";
	}
	
	@RequestMapping("/find")
	public String find(ClothForm form,Model model) {
		
		List<Cloth>list = service.find(form);
		
		model.addAttribute("resultList", list);
		
		return index(model);
	}
}
