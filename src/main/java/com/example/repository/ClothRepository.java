package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

@Repository
public class ClothRepository {
	
	private static final RowMapper<Cloth>CLOTH_ROW_MAPPER 
							= new BeanPropertyRowMapper<>(Cloth.class);

	@Autowired
	NamedParameterJdbcTemplate template;
	
	public List<Cloth> findByGenderAndColor(Integer gender,String color) {
		
		String sql = "SELECT genre,size,price FROM clothes "
				+ " WHERE gender = :gender AND color = :color "
				+ " ORDER BY id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		
		List<Cloth>clothList = template.query(sql,param,CLOTH_ROW_MAPPER);
		
		return clothList;
	}
	
	
	
}
