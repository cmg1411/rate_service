package com.chungang.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chungang.project.service.bankService;


@Controller
public class BankController {

	@Autowired
	bankService bs;
	
	@RequestMapping("/bankService.do")
	public String indextest() {
		return "index";
	}

}
