package com.chungang.project.apicall;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chungang.project.model.CounRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class nhApiReq {
	
	public List<CounRate> getItemsFromOpenApi(String ApiNm, String Tsymd, String Trtm, String Iscd, String FintechApsno,
								      String APISvcCd, String Istuno, String AccessToken, String Btb, String Inymd) throws UnsupportedEncodingException, JsonProcessingException, ParseException {
		
        String url = "https://developers.nonghyup.com/InquireExchangeRate.nh";
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
		JSONParser jsonParse = new JSONParser();
        //String decodeServiceKey = URLDecoder.decode(serviceKey, "UTF-8");
        
        LinkedHashMap<String, Object> nhheader = new LinkedHashMap<String, Object>();
        nhheader.put("ApiNm", ApiNm);
        nhheader.put("Tsymd", Tsymd);
        nhheader.put("Trtm", Trtm);
        nhheader.put("Iscd", Iscd);
        nhheader.put("FintechApsno", FintechApsno);
        nhheader.put("ApiSvcCd", APISvcCd);
        nhheader.put("Istuno", Istuno);
        nhheader.put("AccessToken", AccessToken);
        LinkedHashMap<String, Object> bd = new LinkedHashMap<String, Object>();
        bd.put("Header", nhheader);
        bd.put("Btb", Btb);
        bd.put("Inymd", Inymd);
        
        String body = null;
        try {
			body = objectMapper.writeValueAsString(bd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		
        System.out.println(body);
        
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
		HttpEntity entity = new HttpEntity(body, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		
		//�뙆�떛
		List<CounRate> baseList = new ArrayList<CounRate>();
		
		JSONObject jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 
		
		JSONArray rates = (JSONArray) jsonObject.get("REC");
		
		for(int i=0; i < rates.size(); i++) {
			JSONObject rateObject = (JSONObject) rates.get(i);
			CounRate counrate = new CounRate();
			
			if(((String)rateObject.get("Crcd")).equals("USD")) {
				counrate.setCountry("미국");
				counrate.setBaseRate((String)rateObject.get("BrgnBsrt"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("Crcd")).equals("JPY")) {
				counrate.setCountry("일본");
				counrate.setBaseRate((String)rateObject.get("BrgnBsrt"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("Crcd")).equals("EUR")) {
				counrate.setCountry("유럽");
				counrate.setBaseRate((String)rateObject.get("BrgnBsrt"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("Crcd")).equals("CNY")) {
				counrate.setCountry("중국");
				counrate.setBaseRate((String)rateObject.get("BrgnBsrt"));
				baseList.add(counrate);
			}
			if(((String)rateObject.get("Crcd")).equals("GBP")) {
				counrate.setCountry("영국");
				counrate.setBaseRate((String)rateObject.get("BrgnBsrt"));
				baseList.add(counrate);
			}
			
			if(baseList.size()==5)
				break;
		}
		
		return baseList;
    }
}
