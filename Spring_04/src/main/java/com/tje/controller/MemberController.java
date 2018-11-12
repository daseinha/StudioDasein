package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tje.services.*;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping("/memberList")
	public String memberList(Model model) {
		
		Object result = service.memberListservice();
		model.addAttribute("memberList", result);
		
		return "/member/list";
		
	}
	
	@RequestMapping("/memberInfo/{member_id}")
	public String memberInfo(
			Model model,
			@PathVariable("member_id") String member_id) {
		
		Object result = service.memberInfoservice(member_id);
		model.addAttribute("member", result);
		
		return "/member/info";
		
	}
	
}











