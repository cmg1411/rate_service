package com.chungang.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chungang.project.model.Coun_Bank;
import com.chungang.project.model.bankRes;
import com.chungang.project.service.bankService;

@Controller
public class banklistController {

	@Autowired
	bankService bs;
	
	
	@RequestMapping(value = "/sinlist.do", method = RequestMethod.GET)
	public String sinhan_rate(Model model){
		
		List<bankRes> list = bs.selectByBank("신한");
		model.addAttribute("list", list);
		model.addAttribute("name", "신한");
		
		return "bank_list";
	}
	
	@RequestMapping(value = "/kuklist.do", method = RequestMethod.GET)
	public String kukmin_rate(Model model){
		
		List<bankRes> list = bs.selectByBank("국민");
		model.addAttribute("list", list);
		model.addAttribute("name", "국민");
		
		return "bank_list";
	}
	
	@RequestMapping(value = "/nhlist.do", method = RequestMethod.GET)
	public String nh_rate(Model model){
		
		List<bankRes> list = bs.selectByBank("농협");
		model.addAttribute("list", list);
		model.addAttribute("name", "농협");
		
		return "bank_list";
	}
	
	@RequestMapping(value = "/hanalist.do", method = RequestMethod.GET)
	public String hana_rate(Model model){
		
		List<bankRes> list = bs.selectByBank("하나");
		model.addAttribute("list", list);
		model.addAttribute("name", "하나");
		
		return "bank_list";
	}
	
	@RequestMapping(value = "/urilist.do", method = RequestMethod.GET)
	public String uri_rate(Model model){
		
		List<bankRes> list = bs.selectByBank("우리");
		model.addAttribute("list", list);
		model.addAttribute("name", "우리");
		
		return "bank_list";
	}
	
}
