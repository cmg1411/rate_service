package com.chungang.project.apicall;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chungang.project.model.CounRate;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class kebApiReq {
	public List<CounRate> getItemsFromOpenApi()
			throws UnsupportedEncodingException, JsonProcessingException, ParseException {

		String url = "http://fx.kebhana.com/FER1101M.web";
		JSONParser jsonParse = new JSONParser();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8"))); // Response Header to
																								// UTF-8

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		String resbody = response.getBody().toString();
		String resbodysub = resbody.substring(27);
		
		
		List<CounRate> baseList = new ArrayList<CounRate>();
		
		JSONObject jsonObject = (JSONObject) jsonParse.parse(resbodysub); 
		
		JSONArray rates = (JSONArray) jsonObject.get("리스트");
		
		for(int i=0; i < rates.size(); i++) {
			JSONObject rateObject = (JSONObject) rates.get(i);
			CounRate counrate = new CounRate();
			
			if(((String)rateObject.get("통화명")).equals("미국 USD")) {
				counrate.setCountry("미국");
				counrate.setBaseRate((String)rateObject.get("매매기준율"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("통화명")).equals("일본 JPY 100")) {
				counrate.setCountry("일본");
				counrate.setBaseRate((String)rateObject.get("매매기준율"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("통화명")).equals("유로 EUR")) {
				counrate.setCountry("유럽");
				counrate.setBaseRate((String)rateObject.get("매매기준율"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("통화명")).equals("중국 CNY")) {
				counrate.setCountry("중국");
				counrate.setBaseRate((String)rateObject.get("매매기준율"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("통화명")).equals("영국 GBP")) {
				counrate.setCountry("영국");
				counrate.setBaseRate((String)rateObject.get("매매기준율"));
				baseList.add(counrate);
			}
			
			if(baseList.size()==5)
				break;
		}
		
		return baseList;
	}
}
