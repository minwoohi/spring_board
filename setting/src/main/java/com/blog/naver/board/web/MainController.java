package com.blog.naver.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/") 
	public String viewFirstPage(){ // String 리턴 타입의 경우 화면만 보여주겠다. 
		// 파라미터 함께 보낼 경우 다른 타입 되어야 함
		return "first";
	}
	
	@RequestMapping("/second")
	public String viewSecondPage(){
		return "second";
	}
	
	@RequestMapping("/third")
	public String viewThirdPage(){
		return "third";
	}
	
	@RequestMapping("/myInfo")
	public ModelAndView viewMyPage(){
		ModelAndView view = new ModelAndView();
		
		view.setViewName("info");
		
		view.addObject("name", "minwoo");
		view.addObject("age", "30");
		view.addObject("job", "백수");
		
		return view;
	}
}
