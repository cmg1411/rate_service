package com.chungang.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungang.project.dao.CountryDao;
import com.chungang.project.model.countryRes;

@Service
public class countryServiceImpl implements countryService {
	
	@Autowired
	CountryDao cd;
	
	@Override
	public List<countryRes> selectByCountry(String countryname) {
		List<countryRes> dao = cd.selectByCountry(countryname);
		
		return dao;
	}

}
