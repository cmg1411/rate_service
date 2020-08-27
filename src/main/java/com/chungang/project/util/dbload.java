package com.chungang.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chungang.project.apicall.goodApiReq;
import com.chungang.project.apicall.kebApiReq;
import com.chungang.project.apicall.nhApiReq;
import com.chungang.project.apicall.pubApiReq;
import com.chungang.project.apicall.yahApiReq;
import com.chungang.project.model.CounRate;
import com.chungang.project.model.Coun_Bank;
import com.chungang.project.service.bankService;

@Component
public class dbload {
	
	@Autowired
	bankService bs;
	
	@Autowired
	kebApiReq keb;

	@Autowired
	goodApiReq good;
	
	@Autowired
	pubApiReq pub;
	
	@Autowired
	nhApiReq nh;
	
	@Autowired
	yahApiReq yah;
	
	@PostConstruct
	public void dbloading() throws Exception{
		
		List<CounRate> list = null;
		bs.initApideletes();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();		
		String today = format.format(time);	
		
		long tuno= 2;
		String tuno_str = Long.toString(++tuno);
		
		list = keb.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("하나");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.initApiinserts(cb);
		}
		
		
		
		String ApiNm = "InquireExchangeRate";
		String Tsymd = today; // 변해야함
		String Trtm = "020500";
		String Iscd = "000345";
		String FintechApsno = "001";
		String APISvcCd = "DrawingTransferA";
		String Istuno = tuno_str; //변해야함
		String AccessToken = "cfb3a5c2a0a22bb201f525f848e76d22f9d555b0938fc4493bddb73bd19c9e1e";
		String Btb = "0001";
		String Inymd = "20191213";
		list = nh.getItemsFromOpenApi(ApiNm, Tsymd,Trtm,Iscd,FintechApsno,APISvcCd,Istuno,AccessToken,Btb, Inymd);
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("농협");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.initApiinserts(cb);
		}
		
		list = good.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("신한");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.initApiinserts(cb);
		}
		
		
		String authkey = "EicPUL0YcpnS7CKuPqPVFqRjzFTZbR2W";
		String searchdate = today;
		String base = null;
		list = pub.getItemsFromOpenApi(authkey, searchdate);
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("우리");
			cb.setCounNa(l.getCountry());
			if(l.getBaseRate().contains(",")) {
				base = l.getBaseRate().replace(",", "");
			}else {
				base = l.getBaseRate();
			}
			double baserate = Double.valueOf(base);
			cb.setTbRate(baserate);
			bs.initApiinserts(cb);
		}
		
		list = yah.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("국민");
			cb.setCounNa(l.getCountry());
			if(l.getCountry().equals("일본")) {
				cb.setTbRate(Double.valueOf(l.getBaseRate())*100);
			}else {
				cb.setTbRate(Double.valueOf(l.getBaseRate()));
			}
			bs.initApiinserts(cb);
		}
	}
	
	//24시간마다 update
	@Scheduled(cron = "* * */24 * * *")
	public void dbupdate() throws Exception{

		List<CounRate> list = null;
		bs.initApideletes();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();		
		String today = format.format(time);	
		
		long tuno= 2;
		String tuno_str = Long.toString(++tuno);
		
		list = keb.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("하나");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.Apiupdate(cb);
		}
		
		
		
		String ApiNm = "InquireExchangeRate";
		String Tsymd = today; // 변해야함
		String Trtm = "020500";
		String Iscd = "000345";
		String FintechApsno = "001";
		String APISvcCd = "DrawingTransferA";
		String Istuno = tuno_str; //변해야함
		String AccessToken = "cfb3a5c2a0a22bb201f525f848e76d22f9d555b0938fc4493bddb73bd19c9e1e";
		String Btb = "0001";
		String Inymd = "20191213";
		list = nh.getItemsFromOpenApi(ApiNm, Tsymd,Trtm,Iscd,FintechApsno,APISvcCd,Istuno,AccessToken,Btb, Inymd);
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("농협");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.Apiupdate(cb);
		}
		
		list = good.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("신한");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.Apiupdate(cb);
		}
		
		
		String authkey = "EicPUL0YcpnS7CKuPqPVFqRjzFTZbR2W";
		String searchdate = today;
		String base = null;
		list = pub.getItemsFromOpenApi(authkey, searchdate);
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("우리");
			cb.setCounNa(l.getCountry());
			if(l.getBaseRate().contains(",")) {
				base = l.getBaseRate().replace(",", "");
			}else {
				base = l.getBaseRate();
			}
			double baserate = Double.valueOf(base);
			cb.setTbRate(baserate);
			bs.Apiupdate(cb);
		}
		
		list = yah.getItemsFromOpenApi();
		for(CounRate l : list) {
			Coun_Bank cb = new Coun_Bank();
			cb.setBankNa("국민");
			cb.setCounNa(l.getCountry());
			cb.setTbRate(Double.valueOf(l.getBaseRate()));
			bs.Apiupdate(cb);
		}
	}

}
