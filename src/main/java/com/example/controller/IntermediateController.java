package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.IntermediateService;

@Controller
@RequestMapping("/inter")
public class IntermediateController {

	@Autowired
	IntermediateService service;
	
	@RequestMapping("")
	public String index(Model model) {
		
		List<Team>teamList = service.showList();
		model.addAttribute("teamList", teamList);
		return "index.html";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		
		Team team = service.showDetail(id);
		
		model.addAttribute("team", team);
		
		return "detail";
	}
	
}
