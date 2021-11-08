package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

@Repository
public class IntermediateRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team>TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);

	
	
	public List<Team> showList() {
		
		String sql = "SELECT id, league_name, headquarters, inauguration, history "
				+ " FROM teams "
				+ " ORDER BY inauguration;";
		
		List<Team>teamList = template.query(sql, TEAM_ROW_MAPPER);
		
		return teamList;
	}
	
	public Team showDetail(Integer id) {
		
		String sql = "SELECT id, league_name, headquarters, inauguration, history "
				+ " FROM teams "
				+ " WHERE id = :id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
	
}
