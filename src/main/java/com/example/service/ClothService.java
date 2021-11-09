package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.repository.ClothRepository;

@Service
@Transactional
public class ClothService {

	@Autowired
	ClothRepository repository;
	
	public List<Cloth> find(ClothForm form) {
		
		List<String>colorList = new ArrayList<>();
		for (Integer colorCode : form.getColorList()) {
			switch(colorCode) {
			case 1:
				colorList.add("赤");
				break;
			case 2:
				colorList.add("青");
				break;
			case 3:
				colorList.add("白");
				break;
			case 4:
				colorList.add("黄");
				break;
			}
		}
		
		return repository.findByGenderAndColor(form.getGenderList().get(0),colorList.get(0));
	}
}
