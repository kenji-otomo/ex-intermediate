package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Hotel;

@SpringBootTest
class HotelServiceTest {
	
	@Autowired
	HotelService service;

	@Test
	void testSearchByLessThanPrice1() {
		List<Hotel>list = service.searchByLessThanPrice(4999);
		
		assertEquals(0,list.size());
	}
	@Test
	void testSearchByLessThanPrice2() {
		List<Hotel>list = service.searchByLessThanPrice(5000);
		
		assertEquals("ホテルローズガーデン新宿", list.get(0).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice3() {
		List<Hotel>list = service.searchByLessThanPrice(9999);
		
		assertEquals("ホテルローズガーデン新宿", list.get(0).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice4() {
		List<Hotel>list = service.searchByLessThanPrice(10000);
		
		assertEquals("横浜ベイホテル東急", list.get(0).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice5() {
		List<Hotel>list = service.searchByLessThanPrice(14999);
		
		assertEquals("横浜ベイホテル東急", list.get(0).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice6() {
		List<Hotel>list = service.searchByLessThanPrice(15000);
		
		assertEquals("東京ベイ舞浜ホテル", list.get(3).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice7() {
		List<Hotel>list = service.searchByLessThanPrice(19999);
		
		assertEquals("東京ベイ舞浜ホテル", list.get(3).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice8() {
		List<Hotel>list = service.searchByLessThanPrice(20000);
		
		assertEquals("パレスホテル東京", list.get(1).getHotelName());
	}
	@Test
	void testSearchByLessThanPrice9() {
		List<Hotel>list = service.searchByLessThanPrice(20001);
		
		assertEquals("パレスホテル東京", list.get(1).getHotelName());
	}
	
	@Test
	void testFindAll10() {
		List<Hotel>list = service.findAll();
		
		assertEquals("パレスホテル東京", list.get(1).getHotelName());

	}

}
