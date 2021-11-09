package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String search(Model model,
			@Validated HotelForm form,
			BindingResult result
			){

		if (result.hasErrors()) {
			return index();
		}
		
		
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

/////重い処理はサービスで行うことが理想なため、サービスでif文を使い、リポジトリを使い分ける処理を書く
