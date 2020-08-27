package com.chungang.project.apicall;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chungang.project.model.CounRate;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class pubApiReq {
	public List<CounRate> getItemsFromOpenApi(String authkey, String searchdate)
			throws UnsupportedEncodingException, JsonProcessingException, ParseException {

		String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
		RestTemplate restTemplate = new RestTemplate();
		JSONParser jsonParse = new JSONParser();
//String decodeServiceKey = URLDecoder.decode(serviceKey, "UTF-8");

		url += "?authkey=";
		url += authkey;
		url += "&searchdate=";
		url += searchdate;
		url += "&data=AP01";


		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		
		
		
		//파싱
		List<CounRate> baseList = new ArrayList<CounRate>();
		
		JSONArray rates = (JSONArray) jsonParse.parse(response.getBody().toString()); 
		
		for(int i=0; i < rates.size(); i++) {
			JSONObject rateObject = (JSONObject) rates.get(i);
			CounRate counrate = new CounRate();
			
			if(((String)rateObject.get("cur_nm")).equals("미국 달러")) {
				counrate.setCountry("미국");
				counrate.setBaseRate((String)rateObject.get("deal_bas_r"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("cur_nm")).equals("일본 옌")) {
				counrate.setCountry("일본");
				counrate.setBaseRate((String)rateObject.get("deal_bas_r"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("cur_nm")).equals("유로")) {
				counrate.setCountry("유럽");
				counrate.setBaseRate((String)rateObject.get("deal_bas_r"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("cur_nm")).equals("위안화")) {
				counrate.setCountry("중국");
				counrate.setBaseRate((String)rateObject.get("deal_bas_r"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("cur_nm")).equals("영국 파운드")) {
				counrate.setCountry("영국");
				counrate.setBaseRate((String)rateObject.get("deal_bas_r"));
				baseList.add(counrate);
			}
			
			if(baseList.size()==5)
				break;
		}
		
		return baseList;
	}
}
