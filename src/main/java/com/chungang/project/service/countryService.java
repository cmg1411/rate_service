package com.chungang.project.service;

import java.util.List;

import com.chungang.project.model.bankRes;
import com.chungang.project.model.countryRes;

public interface countryService {
	List<countryRes> selectByCountry(String countryname);
}
