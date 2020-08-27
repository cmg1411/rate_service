package com.chungang.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungang.project.dao.BankDao;
import com.chungang.project.model.Coun_Bank;
import com.chungang.project.model.bankRes;
import com.chungang.project.model.bankResDAO;

@Service
public class bankServiceImpl implements bankService {
	
	@Autowired
	private BankDao bd;
	
	@Override
	public void initApideletes() {
		bd.truncateData();
	}

	@Override
	public void initApiinserts(Coun_Bank counbank) {
		bd.insertInitData(counbank);
	}

	@Override
	public void Apiupdate(Coun_Bank counbank) {
		bd.updateData(counbank);
	}


	@Override
	public List<bankRes> selectByBank(String bankname) {
		List<bankResDAO> dao = bd.selectByBank(bankname);
		
		List<bankRes> list = new ArrayList<bankRes>();
		for(bankResDAO bankrd : dao) {
			bankRes res = new bankRes();
			res.setCounNa(bankrd.getCounNa());
			res.setBuy(bankrd.getTbRate()+(bankrd.getFees()*bankrd.getTbRate()/100));
			res.setSell(bankrd.getTbRate()-(bankrd.getFees()*bankrd.getTbRate()/100));
			res.setTbRate(bankrd.getTbRate());
			res.setFees(bankrd.getFees());
			
			list.add(res);
		}
		
		return list;
	}

}
