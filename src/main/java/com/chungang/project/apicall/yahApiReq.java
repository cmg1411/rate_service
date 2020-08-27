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
public class yahApiReq {
	public List<CounRate> getItemsFromOpenApi()
			throws UnsupportedEncodingException, JsonProcessingException, ParseException {

		String url = "https://earthquake.kr:23490";
		RestTemplate restTemplate = new RestTemplate();
		JSONParser jsonParse = new JSONParser();
//String decodeServiceKey = URLDecoder.decode(serviceKey, "UTF-8");


		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		
		
		
		
		//파싱
		List<CounRate> baseList = new ArrayList<CounRate>();
		CounRate counrate = null;
		
		JSONObject jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 
		
		JSONArray USDKRW = (JSONArray) jsonObject.get("USDKRW");
		counrate = new CounRate();
		counrate.setCountry("미국");
		counrate.setBaseRate(USDKRW.get(0).toString());
		baseList.add(counrate);
		
		JSONArray JPYKRW = (JSONArray) jsonObject.get("JPYKRW");
		counrate = new CounRate();
		counrate.setCountry("일본");
		counrate.setBaseRate(JPYKRW.get(0).toString());
		baseList.add(counrate);
		
		JSONArray EURKRW = (JSONArray) jsonObject.get("EURKRW");
		counrate = new CounRate();
		counrate.setCountry("유럽");
		counrate.setBaseRate(EURKRW.get(0).toString());
		baseList.add(counrate);
		
		JSONArray CNYKRW = (JSONArray) jsonObject.get("CNYKRW");
		counrate = new CounRate();
		counrate.setCountry("중국");
		counrate.setBaseRate(CNYKRW.get(0).toString());
		baseList.add(counrate);
		
		JSONArray GBPKRW = (JSONArray) jsonObject.get("GBPKRW");
		counrate = new CounRate();
		counrate.setCountry("영국");
		counrate.setBaseRate(GBPKRW.get(0).toString());
		baseList.add(counrate);
		
		return baseList;
	}
}
