package com.chungang.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chungang.project.model.countryRes;
import com.chungang.project.service.countryService;

@Controller
public class countrylistController {
	
	@Autowired
	countryService cs;
	
	
	@RequestMapping(value = "/usdlist.do", method = RequestMethod.GET)
	public String usd_rate(Model model){
		
		List<countryRes> list = cs.selectByCountry("미국");
		model.addAttribute("list", list);
		model.addAttribute("name", "미국");
		
		return "country_list";
	}
	
	@RequestMapping(value = "/jpylist.do", method = RequestMethod.GET)
	public String japen_rate(Model model){
		
		List<countryRes> list = cs.selectByCountry("일본");
		model.addAttribute("list", list);
		model.addAttribute("name", "일본");
		
		return "country_list";
	}
	
	@RequestMapping(value = "/cnylist.do", method = RequestMethod.GET)
	public String china_rate(Model model){
		
		List<countryRes> list = cs.selectByCountry("중국");
		model.addAttribute("list", list);
		model.addAttribute("name", "중국");
		
		return "country_list";
	}
	
	@RequestMapping(value = "/eurlist.do", method = RequestMethod.GET)
	public String europe_rate(Model model){
		
		List<countryRes> list = cs.selectByCountry("유럽");
		model.addAttribute("list", list);
		model.addAttribute("name", "유럽");
		
		return "country_list";
	}
	
	@RequestMapping(value = "/gbplist.do", method = RequestMethod.GET)
	public String britsh_rate(Model model){
		
		List<countryRes> list = cs.selectByCountry("영국");
		model.addAttribute("list", list);
		model.addAttribute("name", "영국");
		
		return "country_list";
	}
	
}
