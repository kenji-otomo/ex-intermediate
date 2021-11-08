package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Team;

@SpringBootTest
class IntermediateServiceTest {
	
	
	@Autowired
	IntermediateService service;

	@Test
	void testShowList() {
		List<Team> list = service.showList();
		System.out.println(list);
		Team team = list.get(0);
		System.out.println(team);
		String name = team.getTeamName();
		System.out.println(name);
		assertEquals("読売ジャイアンツ",name,"1 失敗");
	}

	@Test
	void testShowDetail() {
		Team team = service.showDetail(1);
		assertEquals("読売ジャイアンツ", team.getTeamName());
	}

}
