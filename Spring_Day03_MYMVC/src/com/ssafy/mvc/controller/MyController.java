package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.MyService;

@Controller
public class MyController {
	
	private MyService MyService;
	
	@Autowired
	public void setMyService(MyService mys) {
		this.MyService = mys;
	}
	
	@RequestMapping("home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();

		System.out.println("home 요청이 왔다.");
		
		
		MyService.doSomething();
		
		mav.addObject("msg", "Welcome to Spring MVC");
		
		
		//View 이름을 지정해주고 넘김
		//포워딩 한 것과 같음
		mav.setViewName("home");
		return mav;
	}
	
	//get요청만을 위한 것
	@GetMapping("test1")
	public String test1() {
		//반환타입이 String 이라면 반환값이 viewname이 된다
		return "test1"; // WEB-INF/view/test1.jsp
	}
	
	//반환 타입은 문자열로 쓰고 데이터도 넘기고 싶다.
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "데이터를 실어서 보냈습니다.");
		return "test2";
	}
	
	//사용자가 데이터를 줬음
	//파라미터로 값을 받고 싶어
	//기본값으로는 null이 들어간다.
	@GetMapping("test3")
	public String test3(Model model, @RequestParam(value="myid")String id,String pwd, @RequestParam(defaultValue ="1") int age) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		model.addAttribute("age", age);
		
		return "test3";
	}
	@PostMapping("test4")
	public String test4(Model model,User user) {
		
		model.addAttribute("user",user);
		return "test4";
	}
}
