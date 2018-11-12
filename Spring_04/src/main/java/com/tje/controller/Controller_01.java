package com.tje.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller_01 {

	// 쿠키를 생성하는 @RequestMapping 메소드
	// 스프링에서 쿠키를 생성하여 클라이언트에게 전달하는 메소드
	@RequestMapping(value="/generateCookie", method=RequestMethod.GET)
	public String generateCookie(
			HttpServletResponse response, Model model) {
		Cookie cookie = new Cookie("CookieTest", "Hello_Spring_MVC~!");
		response.addCookie(cookie);
		
		model.addAttribute("message", "Cookie 생성 완료");
		
		return "showMessage";
	}
	
	// 쿠키 데이터를 추출하는 방법
	// 1. HttpServletRequest 객체를 활용하는 방법
	//  - 특정 클래스에 종속되는 코드로 스프링에서는 사용되지 않음
	// 2. @CookieValue 을 사용하여 쿠키 데이터를 추출을 지원
	//   - @CookieValue(쿠키이름) String value : 
	//     쿠키이름에 해당되는 값을 value에 저장
	//   - required 기본값이 true 이기 때문에 해당 쿠키가 존재하지 않는 경우
	//     에러가 발생(400번 에러 발생)
	//   - required=false 로 지정하면 해당 쿠키가 존재하지 않더라도
	//     null 값을 대체하여 처리
	//   - defaultValue 속성을 사용해서 쿠키 데이터가 존재하지 않는 경우
	//     기본값을 설정할 수 있음
	@RequestMapping(value="/checkCookie", method=RequestMethod.GET)
	public String checkCookie(
		@CookieValue(value="CookieTest", defaultValue="쿠키가 없습니다", required=false) String cookieValue,
		Model model) {
		
		model.addAttribute("message", cookieValue);
		
		return "showMessage";
	}
	
	
}













