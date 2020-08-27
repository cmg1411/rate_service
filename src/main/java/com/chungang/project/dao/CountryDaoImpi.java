package com.chungang.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chungang.project.model.countryRes;

@Repository
public class CountryDaoImpi implements CountryDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<countryRes> selectByCountry(String countryname) {
		return session.selectList("selectbycountryname", countryname);
	}

}
