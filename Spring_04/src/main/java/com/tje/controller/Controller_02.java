package com.tje.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// 스프링에서 세션을 사용하는 방법
// 2. @SessionAttributes 을 사용
//  - @Controller 클래스의 선언부에 적용
//  - 해당 클래스 내부에서 사용하게 되는 세션 객체를 의미
//  - SessionAttributes(세션에저장될이름(키)값)
//  - @SessionAttributes 가 적용된 클래스 내부의 모든 
//    @RequestMapping 메소드들은 @ModelAttribute 을 사용하여 
//    해당 세션의 데이터를 전달받을 수 있습니다.
@SessionAttributes({"sessionData1", "isLogin", "loginId", "loginMember"})  
public class Controller_02 {
	@ModelAttribute
	// 스프링에서 세션을 사용하는 방법
	// 1. 기존의 HttpSerssion 객체를 사용
	// @RequestMapping 메소드의 매개변수로 HttpSession 객체를 
	// 전달받을 수 있습니다.
	@RequestMapping(value="/generateSession_1", method=RequestMethod.GET)
	public String generateSession_1(HttpSession session) {
		
		session.setAttribute("message", "Session 영역에 저장된 데이터");
		
		return "showMessage";
	}
	
	// @ModelAttribute 가 적용된 메소드는
	// 동일한 컨트롤러 클래스 내부의 모든 @RequestMapping 메소드가
	// 실행될 때 마다 반복되어 실행되며, 리턴되는 데이터를
	// @ModelAttribute에 선언된 키값으로 Model 객체에 저장합니다.
	@ModelAttribute("modelAttrData")
	public String getMedelAttrData() {
		return "@ModelAttribute 메소드 테스트";
	}
	
	// @ModelAttribute 이 메소드의 매개변수에 선언되는 경우
	// 1. 기본값(모델)에서 해당 키 값의 데이터 유무를 확인
	// 1-1. 만약 존재한다면 해당 데이터를 매개변수로 대입
	// 1-2. 만약 존재하지 않는다면 요청 객체의 파라메터 정보와
	//      매개변수에 선언된 클래스의 멤버필드(프로퍼티)를 비교하여 
	//      객체를 생성
	// 1-3. 1-2가 성공하면 메소드 내부로 진입(키값으로 모델 객체에 데이터 저장), 
	//      실패한다면 400번 에러가 발생
	@RequestMapping(value="/generateSession_2", method=RequestMethod.GET)
	public String generateSession_2(
			@ModelAttribute("modelAttrData") String data
			) {
		
		System.out.println(data);		
		
		return "showMessage";
	}
	
	// @ModelAttribute 메소드를 사용하여
	// 세션 영역에 값을 저장하느 메소드
	// @ModelAttribute 을 사용하여 세션 데이터를
	// 추출할 때 발생할 수 있는 에러를 방지하기 위한 용도
	// @SessionAttributes에 적용된 키값으로 정의되어
	// 아래의 메소드에서 반환된 값은 세션 영역에 
	// 저장됩니다.
	@ModelAttribute("sessionData1")
	public String getSessionData1() {
		return "세션에 저장된 sessionData1";
	}
	
	// @ModelAttribute 메소드의 매개변수를 지정할 때,
	// 키 값으로 @SessionAttributes 에 지정된 키 값을 설정하는 경우
	// 세션 영역에서 해당 키값의 존재 유무를 판단
	// 만약 존재하는 경우 해당 데이터를 매개변수로 대입
	// 존재하지 않는 경우 에러가 발생
	// 에러 발생 방지를 위해서 처리하는 방법
	// 1. 올바른 경로를 따라서 진행 - 위험성이 높음
	// 2. 해당 키값으로 지정된 @ModelAttribute 메소드를 생성
	@RequestMapping(value="/generateSession_3", method=RequestMethod.GET)
	public String generateSession_3(
			@ModelAttribute("sessionData1") String data
			) {
		
		System.out.println(data);		
		
		return "showMessage";
	}
	
	@RequestMapping(value="/generateSession_4", method=RequestMethod.GET)
	public String generateSession_4(Model model) {
		
		model.addAttribute("message", "generateSession_4");
		// @SessionAttributes 이 적용된 클래스 내부에서 
		// 모델 객체를 활용하여 데이터를 입력할 때 
		// @SessionAttributes의 선언에 사용된 키값으로
		// 데이터를 저장하면 세션 영역에 데이터가 저장됩니다.
		model.addAttribute("sessionData1", "generateSession_4");
		
		return "showMessage";
	}
	
	
	
	
}













