package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.IntermediateRepository;

@Service
@Transactional
public class IntermediateService {

	@Autowired
	IntermediateRepository repository;
	
	public List<Team> showList() {
		return repository.showList();
	}
	
	public Team showDetail(Integer id) {
		return repository.showDetail(id);
	}
}
