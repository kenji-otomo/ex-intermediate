package com.example.form;

import java.util.List;

public class ClothForm {
	
	private List<Integer> genderList; 
	
	private List<Integer> colorList;

	public List<Integer> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Integer> genderList) {
		this.genderList = genderList;
	}

	public List<Integer> getColorList() {
		return colorList;
	}

	public void setColorList(List<Integer> colorList) {
		this.colorList = colorList;
	}

	@Override
	public String toString() {
		return "ClothForm [genderList=" + genderList + ", colorList=" + colorList + "]";
	}
	
	

}
