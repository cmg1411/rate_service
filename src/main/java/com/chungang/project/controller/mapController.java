package com.chungang.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chungang.project.model.GeocodeRequestDTO;
import com.chungang.project.util.MapUtil;

@Controller
public class mapController {

	@Autowired
	MapUtil maputil;
	
	@RequestMapping("/mapSearch.do")
	public String map_search() {
		return "map";
	}
	
	@RequestMapping(value="/geocoderajax", method=RequestMethod.POST, produces= {"application/json"})
	public @ResponseBody Map<String, Object> GeocoderService(@RequestBody final GeocodeRequestDTO geocodeRequestdto){
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("address : " + geocodeRequestdto.getAddress());
		
		Float[] coords = maputil.geoCoding(geocodeRequestdto);
		
		retVal.put("id", "success");
		retVal.put("latitude", coords[0]);
		retVal.put("longitude", coords[1]);
		
		return retVal;
	}
	
}
