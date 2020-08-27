package com.chungang.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chungang.project.model.Coun_Bank;
import com.chungang.project.model.bankResDAO;

@Repository
public class BankDaoImpl implements BankDao{

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public void insertInitData(Coun_Bank counbank) {
		session.insert("insertAPIData", counbank);
	}

	@Override
	public void truncateData() {
		session.delete("truncateData");
	}

	@Override
	public void updateData(Coun_Bank counbank) {
		session.update("updateData", counbank);
	}

	@Override
	public List<bankResDAO> selectByBank(String bankname) {
		
		return session.selectList("selectbybankname", bankname);
	}
}
