package com.chungang.project.service;

import java.util.List;

import com.chungang.project.model.Coun_Bank;
import com.chungang.project.model.bankRes;

public interface bankService {
	void initApideletes();
	void initApiinserts(Coun_Bank counbank);
	void Apiupdate(Coun_Bank counbank);
	List<bankRes> selectByBank(String bankname);
}
