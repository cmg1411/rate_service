package com.chungang.project.dao;

import java.util.List;

import com.chungang.project.model.countryRes;

public interface CountryDao {
	List<countryRes> selectByCountry(String countryname);
}
