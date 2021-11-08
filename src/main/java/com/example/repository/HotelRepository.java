package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

@Repository
public class HotelRepository {
	
	private static final RowMapper<Hotel>HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	public List<Hotel> searchByLessThanPrice(Integer price) {
		
		String sql = "SELECT hotel_name,nearest_station,price "
				+ " FROM hotels "
				+ " WHERE price <= :price;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel>hotelList = template.query(sql, param,HOTEL_ROW_MAPPER);
		
		return hotelList;
	}

}
