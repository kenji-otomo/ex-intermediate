package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.IntermediateService;

@Controller
@RequestMapping("/intermadiate")
public class IntermediateController {

	@Autowired
	IntermediateService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
