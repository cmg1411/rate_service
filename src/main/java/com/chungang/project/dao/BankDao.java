package com.chungang.project.dao;

import java.util.List;

import com.chungang.project.model.Coun_Bank;
import com.chungang.project.model.bankResDAO;


public interface BankDao {
	void truncateData();
	void insertInitData(Coun_Bank counbank);
	void updateData(Coun_Bank counbank);
	List<bankResDAO> selectByBank(String bankname);
}
