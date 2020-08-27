package com.chungang.project.apicall;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chungang.project.model.CounRate;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class goodApiReq {
   public List<CounRate> getItemsFromOpenApi()
         throws UnsupportedEncodingException, JsonProcessingException, ParseException {

      JSONParser jsonParse = new JSONParser();
      RestTemplate restTemplate = new RestTemplate();
      List<CounRate> baseList = new ArrayList<CounRate>();
      CounRate counrate = null;
//String decodeServiceKey = URLDecoder.decode(serviceKey, "UTF-8");

      String url = null;
      ResponseEntity<String> response = null;
      JSONObject jsonObject = null;
      JSONObject ExchangeRates = null;
      JSONObject Row = null;
      
      //미국
      url = "http://ds.gscms.co.kr:8888/Rest/ExchangeRates/081/USD?type=json&sessionID=test&date=20191021";
      response = restTemplate.getForEntity(url, String.class);
      
      jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 

      ExchangeRates = (JSONObject) jsonObject.get("ExchangeRates");
      Row = (JSONObject) ExchangeRates.get("Row");
      counrate = new CounRate();
      counrate.setCountry("미국");
      counrate.setBaseRate(Row.get("매매기준율").toString());
      baseList.add(counrate);
      
      
      //일본
      url = "http://ds.gscms.co.kr:8888/Rest/ExchangeRates/081/JPY?type=json&sessionID=test&date=20191021";
      response = restTemplate.getForEntity(url, String.class);
      
      jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 

      ExchangeRates = (JSONObject) jsonObject.get("ExchangeRates");
      Row = (JSONObject) ExchangeRates.get("Row");
      counrate = new CounRate();
      counrate.setCountry("일본");
      counrate.setBaseRate(Row.get("매매기준율").toString());
      baseList.add(counrate);
      
      
      //유럽
      url = "http://ds.gscms.co.kr:8888/Rest/ExchangeRates/081/EUR?type=json&sessionID=test&date=20191021";
      response = restTemplate.getForEntity(url, String.class);
      
      jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 

      ExchangeRates = (JSONObject) jsonObject.get("ExchangeRates");
      Row = (JSONObject) ExchangeRates.get("Row");
      counrate = new CounRate();
      counrate.setCountry("유럽");
      counrate.setBaseRate(Row.get("매매기준율").toString());
      baseList.add(counrate);
      
      
      //중국
      url = "http://ds.gscms.co.kr:8888/Rest/ExchangeRates/081/CNY?type=json&sessionID=test&date=20191021";
      response = restTemplate.getForEntity(url, String.class);
      
      jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 

      ExchangeRates = (JSONObject) jsonObject.get("ExchangeRates");
      Row = (JSONObject) ExchangeRates.get("Row");
      counrate = new CounRate();
      counrate.setCountry("중국");
      counrate.setBaseRate(Row.get("매매기준율").toString());
      baseList.add(counrate);
      
      
      //영국
      url = "http://ds.gscms.co.kr:8888/Rest/ExchangeRates/081/GBP?type=json&sessionID=test&date=20191021";
      response = restTemplate.getForEntity(url, String.class);
      
      jsonObject = (JSONObject) jsonParse.parse(response.getBody().toString()); 

      ExchangeRates = (JSONObject) jsonObject.get("ExchangeRates");
      Row = (JSONObject) ExchangeRates.get("Row");
      counrate = new CounRate();
      counrate.setCountry("영국");
      counrate.setBaseRate(Row.get("매매기준율").toString());
      baseList.add(counrate);
      
      return baseList;
   }
}