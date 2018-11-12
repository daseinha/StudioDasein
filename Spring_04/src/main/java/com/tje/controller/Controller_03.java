package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tje.services.*;

@Controller
public class Controller_03 {
	
	@Autowired
	private Service_01 service;

	@RequestMapping("mvcTest")
	public String mvcTest(Model model) {
		
		Object message = service.service();
		model.addAttribute("message", message);
		
		return "showMessage";
	}
	
}











