package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@ModelAttribute
	public HotelForm setyUpHotelForm() {
		return new HotelForm();
	}
	
	@RequestMapping("")
	public String index() {
		
		return "hotelsearch";
	}

	@RequestMapping("/search")
	public String search(Model model,HotelForm form) {
		List<Hotel>hotelList = new ArrayList<>();
		
		if (form.getPrice() == null) {
			hotelList = service.findAll();
		}else {
			hotelList = service.searchByLessThanPrice(form.getPrice());
		}
		
		
		model.addAttribute("hotelList", hotelList);
		
		return "hotelsearch";
	}
}
